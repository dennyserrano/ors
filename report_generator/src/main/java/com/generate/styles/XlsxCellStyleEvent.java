package com.generate.styles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author ej
 * @since Nov 05, 2014 17:57
 */
public class XlsxCellStyleEvent {

    private Workbook workbook;

    private Row row;

    private Cell cell;

    private FormattedElement formattedElement;

    public XlsxCellStyleEvent() {}

    public XlsxCellStyleEvent(Workbook workbook, Row row, Cell cell, FormattedElement formattedElement) {
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
