package ph.gov.deped.data.export.xlsx;

import java.io.Serializable;

/**
 * Created by ej on 10/16/14.
 */
public interface FormattedValue extends Serializable {
    
    CellFormat getCellFormat();

    <O extends Serializable> O getCellContents();
}
