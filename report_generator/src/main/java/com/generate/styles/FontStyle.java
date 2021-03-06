package com.generate.styles;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @see org.apache.poi.ss.usermodel.Font
 * @since  Oct 16, 2014
 * @author ej
*/
public class FontStyle implements XlsxStyleBuilder<Font>, Serializable {
    
    public static final String[] FIELDS = new String[] {
            "fontName", "height", "color", "bold", "italic", "underline"
    };

    public static final String DEFAULT_FONT_NAME = "Arial";
    
    private static final long serialVersionUID = 2115195258993046530L;
    
    private String fontName;
    
    private Short height;
    
    private Short color;
    
    private Boolean bold;
    
    private Boolean italic;
    
    private Byte underline;

    public FontStyle setFontName(String fontName) {
        this.fontName = fontName;
        return this;
    }

    public FontStyle setHeight(short height) {
        this.height = height;
        return this;
    }
    
    public FontStyle setColor(short color) {
        this.color = color;
        return this;
    }
    
    public FontStyle setBold(boolean bold) {
        this.bold = bold;
        return this;
    }
    
    public FontStyle setItalic(boolean italic) {
        this.italic = italic;
        return this;
    }
    
    public FontStyle setUnderline(byte underline) {
        this.underline = underline;
        return this;
    }
    
    public Font build(Workbook wb) {
        Font font = wb.createFont();
        if (!isBlank(fontName)) {
            font.setFontName(fontName);
        }
        if (height != null) {
            font.setFontHeightInPoints(height.shortValue());
        }
        if (color != null) {
            font.setColor(color.shortValue());
        }
        if (bold != null) {
            font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        }
        if (italic != null) {
            font.setItalic(italic);
        }
        if (underline != null) {
            font.setUnderline(underline.byteValue());
        }
        return font;
    }
}
