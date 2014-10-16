package ph.gov.deped.data.export;

/**
 * Created by ej on 10/16/14.
 */
public abstract class Formats {
    
    private static final short DEFAULT_FONT_SIZE = 12;
    
    private static final String DEFAULT_INTEGER_FORMAT = "#,###";
    
    private static final String DEFAULT_DECIMAL_FORMAT = "#,###.00";
    
    private static final String DEFAULT_DATE_FORMAT = "mmm dd, yyyy";
    
    private static final String DEFAULT_TIME_FORMAT = "hh:mm:ss A/P";
    
    private static final String DEFAULT_DATETIME_FORMAT = DEFAULT_DATE_FORMAT + " " + DEFAULT_TIME_FORMAT;
    
    public static FontStyle normal() {
        return new FontStyle().setHeight(DEFAULT_FONT_SIZE);
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
    
    public static CellFormat text() {
        return new CellFormat();
    }
    
    public static CellFormat integer() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_INTEGER_FORMAT);
        return cf;
    }
    
    public static CellFormat decimal() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_DECIMAL_FORMAT);
        return cf;
    }
    
    public static CellFormat date() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_DATE_FORMAT);
        return cf;
    }
    
    public static CellFormat time() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_TIME_FORMAT);
        return cf;
    }
    
    public static CellFormat datetime() {
        CellFormat cf = new CellFormat();
        cf.setDataFormat(DEFAULT_DATETIME_FORMAT);
        return cf;
    }
}
