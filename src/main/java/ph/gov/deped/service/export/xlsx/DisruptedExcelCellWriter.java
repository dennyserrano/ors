package ph.gov.deped.service.export.xlsx;

import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ej on 10/21/14.
 */
@SuppressWarnings({"unchecked"})
public class DisruptedExcelCellWriter extends DefaultExcelCellWriter implements ExcelCellWriter, InitializingBean, DisposableBean {

    private static final Logger log = LogManager.getLogger(DisruptedExcelCellWriter.class);
    
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    
    private final DefaultExcelCellWriter defaultExcelCellWriter;
    
    private int bufferSize = DEFAULT_BUFFER_SIZE;

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private Disruptor<XlsxCellWriteEvent> disruptor;
    
    private RingBuffer<XlsxCellWriteEvent> ringBuffer;

    public DisruptedExcelCellWriter(DefaultExcelCellWriter defaultExcelCellWriter) {
        this.defaultExcelCellWriter = defaultExcelCellWriter;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void afterPropertiesSet() throws Exception {
        this.disruptor = new Disruptor<>(XlsxCellWriteEvent::new, bufferSize, executorService);
        this.disruptor.handleExceptionsWith(new ExceptionHandler() {
            public void handleEventException(Throwable ex, long sequence, Object event) {
                throw new RuntimeException(ex);
            }
            public void handleOnStartException(Throwable ex) {
                throw new RuntimeException(ex);
            }
            public void handleOnShutdownException(Throwable ex) {
                throw new RuntimeException(ex);
            }
        });
        this.disruptor.handleEventsWith((event, sequence, endOfBatch) ->
                super.write(event.getWorkbook(), event.getRow(), event.getCell(), event.getValue()));
        this.ringBuffer = disruptor.start();
    }

    public void destroy() throws Exception {
        this.executorService.shutdown();
        this.disruptor.shutdown();
    }

    public @Override void write(Workbook wb, Row row, Cell cell, Serializable value) {
        ringBuffer.publishEvent((event, sequence) -> {
            event.setWorkbook(wb);
            event.setValue(value);
            event.setCell(cell);
            event.setRow(row);
        });
    }
}
