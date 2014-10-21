package ph.gov.deped.data.export.xlsx;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by ej on 10/21/14.
 */
public class XlsxCellWriteEvent {
    
    private Workbook workbook;
    
    private Row row;
    
    private Cell cell;
    
    private FormattedElement formattedElement;

    public XlsxCellWriteEvent() {}

    public XlsxCellWriteEvent(Workbook workbook, Row row, Cell cell, FormattedElement formattedElement) {
        this.workbook = workbook;
        this.row = row;
        this.cell = cell;
        this.formattedElement = formattedElement;
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public FormattedElement getFormattedElement() {
        return formattedElement;
    }

    public void setFormattedElement(FormattedElement formattedElement) {
        this.formattedElement = formattedElement;
    }
}
