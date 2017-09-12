package ph.gov.deped.service.export.xlsx.stylers;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import ph.gov.deped.common.util.builders.impl.ColumnElement;
import ph.gov.deped.service.export.xlsx.FormattedElement;
import ph.gov.deped.service.export.xlsx.XlsxCellStyleEvent;
import ph.gov.deped.service.export.xlsx.stylers.interfaces.ColumnElementExcelHeaderCellStyler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ej
 * @since Nov 05, 2014 17:58
 */
public class DisruptedExcelCellStyler implements InitializingBean, DisposableBean {

    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private int bufferSize = DEFAULT_BUFFER_SIZE;
    
    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private Disruptor<XlsxCellStyleEvent> disruptor;
    
    private RingBuffer<XlsxCellStyleEvent> ringBuffer;

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void afterPropertiesSet() throws Exception {
        this.disruptor = new Disruptor<>(XlsxCellStyleEvent::new, bufferSize, executorService);
        this.disruptor.handleEventsWith((event, sequence, endOfBatch) -> {
            FormattedElement fe = event.getFormattedElement();
            Workbook wb = event.getWorkbook();
            Cell cell = event.getCell();
            CellStyle cellStyle = fe.getCellFormat().build(wb);
            cell.setCellStyle(cellStyle);
            if (fe.getCellType() != null) {
                cell.setCellType(fe.getCellType().intValue());
            }
        });
        this.ringBuffer = disruptor.start();
    }

    public void destroy() throws Exception {
        this.executorService.shutdown();
        this.disruptor.shutdown();
    }
    
//    public void applyStyle(Workbook wb, Row row, Cell cell,ColumnElement ce) {
////        ringBuffer.publishEvent((event, sequence) -> {
////            event.setWorkbook(wb);
////            event.setFormattedElement(fe);
////            event.setCell(cell);
////            event.setRow(row);
////        });
//    }

//	@Override
//	public void applyStyle(Workbook wb, Sheet sheet, Row row, Cell cell,
//			ColumnElement ce) {
//		// TODO Auto-generated method stub
//		
//	}
}
