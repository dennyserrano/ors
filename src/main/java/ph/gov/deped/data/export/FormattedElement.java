package ph.gov.deped.data.export;

import ph.gov.deped.data.dto.ColumnElement;

import java.io.Serializable;

/**
 * Created by ej on 10/16/14.
 */
public class FormattedElement implements FormattedValue, Serializable {

    private static final long serialVersionUID = -1034249000455070779L;
    
    private ColumnElement columnElement;
    
    private CellFormat cellFormat;

    public FormattedElement() {
        this(null);
    }

    public FormattedElement(ColumnElement columnElement) {
        this(columnElement, null);
    }

    public FormattedElement(ColumnElement columnElement, CellFormat cellFormat) {
        this.columnElement = columnElement;
        this.cellFormat = cellFormat;
    }

    public ColumnElement getColumnElement() {
        return columnElement;
    }

    public void setColumnElement(ColumnElement columnElement) {
        this.columnElement = columnElement;
    }

    public void setCellFormat(CellFormat cellFormat) {
        this.cellFormat = cellFormat;
    }

    public CellFormat getCellFormat() {
        return cellFormat;
    }
    
    public String getCellContents() {
        return String.valueOf(this.columnElement.getValue());
    }
}
