package ph.gov.deped.data.export;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by ej on 10/16/14.
 */
public interface XlsxStyleBuilder<T> {
    
    T build(Workbook wb);
}
