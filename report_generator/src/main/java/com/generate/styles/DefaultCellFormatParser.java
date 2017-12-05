package com.generate.styles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author ej
 * @since Oct 23, 2014 11:16
 */
public class DefaultCellFormatParser implements CellFormatParser {
    
    private static final Logger log = LogManager.getLogger(DefaultCellFormatParser.class);
    
    private static final String ONE = "1";
    
    public ElementFormatter parse(String format) {
        String[] cellFormatTokens = format.split("\\" + PIPE);
        FontStyle fontStyle = isBlank(cellFormatTokens[0]) ? null : parseFontStyle(cellFormatTokens[0]);
        CellFormat f = new CellFormat();
        f.setFontStyle(fontStyle);
        if (!isBlank(cellFormatTokens[1])) {
            f.setDataFormat(cellFormatTokens[1]);
        }
        if (!isBlank(cellFormatTokens[2])) {
            f.setCellType(new Integer(cellFormatTokens[2]));
        }
        if (!isBlank(cellFormatTokens[3])) {
            f.setIndentation(new Short(cellFormatTokens[3]));
        }
        if (!isBlank(cellFormatTokens[4])) {
            f.setRotation(new Short(cellFormatTokens[4]));
        }
        if (!isBlank(cellFormatTokens[5])) {
            f.setVerticalAlign(new Short(cellFormatTokens[5]));
        }
        if (!isBlank(cellFormatTokens[6])) {
            f.setHorizontalAlign(new Short(cellFormatTokens[6]));
        }
        if (!isBlank(cellFormatTokens[7]) && ONE.equals(cellFormatTokens[7])) {
            f.setShrinkToFit(Boolean.TRUE);
        }
        if (!isBlank(cellFormatTokens[8]) && ONE.equals(cellFormatTokens[8])) {
            f.setWrapText(Boolean.TRUE);
        }
        return ce -> new FormattedElement(ce, f);
    }
    
    private FontStyle parseFontStyle(String fontStylePart) {
        String[] fontStyleTokens = fontStylePart.split(SEMICOLON);
        FontStyle fontStyle = new FontStyle();
        if (fontStyleTokens.length == 1) {
            Optional<Method> optional = methods.parallelStream()
                    .filter(m -> m.getName().equals(fontStyleTokens[0]))
                    .findFirst();
            if (!optional.isPresent()) {
                throw new RuntimeException(String.format("No such font style is defined [$s].", fontStyleTokens[0]));
            }
            Method method = optional.get();
            try {
                fontStyle = (FontStyle) method.invoke(null);
            }
            catch (IllegalAccessException|InvocationTargetException ex) {
                log.error("Unable to retrieve/call the pre-defined font style [{}].", fontStyleTokens[0]);
                log.throwing(ex);
            }
        }
        if (!isBlank(fontStyleTokens[0])) {
            fontStyle.setFontName(fontStyleTokens[0]);
        }
        if (!isBlank(fontStyleTokens[1])) {
            fontStyle.setHeight(new Short(fontStyleTokens[1]));
        }
        if (!isBlank(fontStyleTokens[2])) {
            fontStyle.setColor(new Short(fontStyleTokens[2]));
        }
        if (!isBlank(fontStyleTokens[3]) && ONE.equals(fontStyleTokens[3])) {
            fontStyle.setBold(Boolean.TRUE);
        }
        if (!isBlank(fontStyleTokens[4]) && ONE.equals(fontStyleTokens[4])) {
            fontStyle.setItalic(Boolean.TRUE);
        }
        if (!isBlank(fontStyleTokens[5])) {
            fontStyle.setUnderline(new Byte(fontStyleTokens[5]));
        }
        return fontStyle;
    }
}
