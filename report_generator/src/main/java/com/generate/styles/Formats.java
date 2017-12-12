package com.generate.styles;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 * Created by ej on 10/16/14.
 */
public abstract class Formats {
    
    private static final short DEFAULT_FONT_SIZE = 8;
    
    private static final String DEFAULT_INTEGER_FORMAT = "#,##0";
    
    private static final String DEFAULT_DECIMAL_FORMAT = "#,###.00";
    
    private static final String DEFAULT_DATE_FORMAT = "mm-dd-yyyy";
    
    private static final String DEFAULT_TIME_FORMAT = "hh:mm:ss A/P";
    
    private static final String DEFAULT_DATETIME_FORMAT = DEFAULT_DATE_FORMAT + " " + DEFAULT_TIME_FORMAT;
    
    public static FontStyle defaultFont() {
        return new FontStyle().setHeight(DEFAULT_FONT_SIZE).setFontName(FontStyle.DEFAULT_FONT_NAME);
    }
    
    public static FontStyle normal() {
        return new FontStyle().setHeight(DEFAULT_FONT_SIZE).setFontName(FontStyle.DEFAULT_FONT_NAME);
    }
    
    public static FontStyle bold() {
        return normal().setBold(true);
    }
    
    public static FontStyle italic() {
        return normal().setItalic(true);
    }
    
    public static FontStyle heading1() {
        return bold().setHeight((short) 24);
    }
    
    public static FontStyle heading2() {
        return bold().setHeight((short) 20);
    }
    
    public static FontStyle heading3() {
        return normal().setHeight((short) 16);
    }
    
    public static FontStyle heading4() {
        return heading2().setHeight((short) 14);
    }
    
    public static FontStyle heading5() {
        return heading4().setHeight((short) 12);
    }
    
    public static FontStyle heading6() {
        return bold();
    }
    
    public static CellFormat defaultHeader() {
        CellFormat cf = new CellFormat();
        cf.setFontStyle(heading6());
        cf.setCellType(Cell.CELL_TYPE_STRING);
        return cf;
    }
    
    public static CellFormat text() {
        CellFormat cf = new CellFormat();
        cf.setFontStyle(defaultFont());
        cf.setCellType(Cell.CELL_TYPE_STRING);
        cf.setWrapText(Boolean.TRUE);
        return cf;
    }
    
    public static CellFormat integer() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_INTEGER_FORMAT);
        cf.setCellType(Cell.CELL_TYPE_NUMERIC);
        cf.setFontStyle(defaultFont());
        cf.setIndentation(CellStyle.ALIGN_RIGHT);
        return cf;
    }
    
    public static CellFormat decimal() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_DECIMAL_FORMAT);
        cf.setCellType(Cell.CELL_TYPE_NUMERIC);
        cf.setFontStyle(defaultFont());
        cf.setIndentation(CellStyle.ALIGN_RIGHT);
        return cf;
    }
    
    public static CellFormat date() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_DATE_FORMAT);
        cf.setFontStyle(defaultFont());
        cf.setCellType(Cell.CELL_TYPE_STRING);
        return cf;
    }
    
    public static CellFormat date(String dataFormat) {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(dataFormat);
        cf.setFontStyle(defaultFont());
        cf.setCellType(Cell.CELL_TYPE_STRING);
        return cf;
    }
    
    public static CellFormat time() {
        CellFormat cf = new CellFormat();
        cf.setFontStyle(defaultFont());
        cf.setDataFormat(DEFAULT_TIME_FORMAT);
        cf.setCellType(Cell.CELL_TYPE_STRING);
        return cf;
    }
    
    public static CellFormat datetime() {
        CellFormat cf = new CellFormat();
        cf.setFontStyle(defaultFont());
        cf.setDataFormat(DEFAULT_DATETIME_FORMAT);
        cf.setCellType(Cell.CELL_TYPE_STRING);
        return cf;
    }
    
    public static ElementFormatter booleanValue() {
        return ce -> new FormattedElement(ce, defaultHeader(),
                (ce.getValue() != null && ((Boolean) ce.getValue()) ? "YES" : "NO"));
    }
    
    public static ElementFormatter headerValue() {
        return ce -> new FormattedElement(ce, defaultHeader(), ce.getValue());
    }
    
    public static ElementFormatter stringValue() {
        return ce -> new FormattedElement(ce, text(), String.valueOf((Object) ce.getValue()));
    }
    
    public static ElementFormatter longValue() {
        return ce -> new FormattedElement(ce, integer());
    }
    
    public static ElementFormatter decimalValue() {
        return ce -> new FormattedElement(ce, decimal());
    }
    
    public static ElementFormatter yearValue() {
        return ce -> new FormattedElement(ce, date("####"));
    }
    
    public static ElementFormatter dateValue() {
        return ce -> new FormattedElement(ce, date());
    }
    
    public static ElementFormatter timeValue() {
        return ce -> new FormattedElement(ce, time());
    }
    
    public static ElementFormatter datetimeValue() {
        return ce -> new FormattedElement(ce, datetime());
    }
}
