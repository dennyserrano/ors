package ph.gov.deped.service.export.xlsx;

import ph.gov.deped.data.dto.ColumnElement;

import java.io.Serializable;

/**
 * Created by ej on 10/16/14.
 */
@SuppressWarnings({"unchecked"})
public class FormattedElement implements FormattedValue, Serializable {

    private static final long serialVersionUID = -1034249000455070779L;
    
    private ColumnElement columnElement;
    
    private CellFormat cellFormat;
    
    private Serializable valueOverride;

    public FormattedElement(ColumnElement columnElement) {
        this(columnElement, null);
    }

    public FormattedElement(ColumnElement columnElement, CellFormat cellFormat) {
        this(columnElement, cellFormat, columnElement.getValue());
    }

    public FormattedElement(ColumnElement columnElement, CellFormat cellFormat, Serializable valueOverride) {
        this.columnElement = columnElement;
        this.cellFormat = cellFormat;
        this.valueOverride = valueOverride;
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

    public void setValueOverride(String valueOverride) {
        this.valueOverride = valueOverride;
    }

    public CellFormat getCellFormat() {
        return cellFormat;
    }
    
    public Integer getCellType() {
        return cellFormat.getCellType();
    }
    
    public <O extends Serializable> O getCellContents() {
        return (O) valueOverride == null ? this.columnElement.getValue() : (O) valueOverride;
    }
}
