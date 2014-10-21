package ph.gov.deped.data.export.xlsx;

import com.bits.sql.JdbcTypes;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.bits.sql.JdbcTypes.*;

/**
 * Created by ej on 10/21/14.
 */
public class XlsxCellWriter {
    
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    
    private int bufferSize = DEFAULT_BUFFER_SIZE;
    
    private Disruptor<XlsxCellWriteEvent> disruptor;
    
    private RingBuffer<XlsxCellWriteEvent> ringBuffer;

    public XlsxCellWriter() {
        this.disruptor = createDisruptor();
        initDisruptor(this.disruptor);
        this.ringBuffer = disruptor.getRingBuffer();
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }
    
    public void publish(Workbook wb, Row row, Cell cell, FormattedElement fe) {
        ringBuffer.publishEvent((event, sequence) -> {
            event.setWorkbook(wb);
            event.setFormattedElement(fe);
            event.setCell(cell);
            event.setRow(row);
        });
    }

    private Disruptor<XlsxCellWriteEvent> createDisruptor() {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        return new Disruptor<>(XlsxCellWriteEvent::new, bufferSize, executorService);
    }
    
    private void initDisruptor(Disruptor<XlsxCellWriteEvent> disruptor) {
        disruptor.handleEventsWith((event, sequence, endOfBatch) ->
                write(event.getWorkbook(), event.getRow(), event.getCell(), event.getFormattedElement()));
        disruptor.start();
    }

    private void write(Workbook wb, Row row, Cell cell, FormattedElement fe) {
        CellStyle cellStyle = fe.getCellFormat().build(wb);
        cell.setCellStyle(cellStyle);
        if (fe.getCellType() != null) {
            cell.setCellType(fe.getCellType().intValue());
        }
        if (row.getRowNum() == 0) {
            cell.setCellValue((String) fe.getCellContents());
        }
        else {
            if (isBoolean(fe.getColumnElement().getDataType(), fe.getColumnElement().getPrecision())) {
                cell.setCellValue((String) fe.getCellContents());
            }
            else if (isNumeric(fe.getColumnElement().getDataType())) {
                cell.setCellValue(JdbcTypes.getDoubleValue(fe.getCellContents()));
            }
            else if (isCalendarType(fe.getColumnElement().getDataType())) {
                cell.setCellValue(JdbcTypes.getDateValue(fe.getCellContents()));
            }
            else {
                cell.setCellValue(JdbcTypes.getStringValue(fe.getCellContents()));
            }
        }
    }
}
