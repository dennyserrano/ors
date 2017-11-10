package com.generate.styles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;

/**
 * Created by ej on 10/21/14.
 */
public class XlsxCellWriteEvent {
    
    private Workbook workbook;
    
    private Row row;
    
    private Cell cell;
    
    private Serializable value;

    public XlsxCellWriteEvent() {}

    public XlsxCellWriteEvent(Workbook workbook, Row row, Cell cell, Serializable value) {
        this.workbook = workbook;
        this.row = row;
        this.cell = cell;
        this.value = value;
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

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }
}
