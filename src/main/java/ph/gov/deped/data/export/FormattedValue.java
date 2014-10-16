package ph.gov.deped.data.export;

import java.io.Serializable;

/**
 * Created by ej on 10/16/14.
 */
public interface FormattedValue extends Serializable {
    
    CellFormat getCellFormat();
    
    String getCellContents();
}
