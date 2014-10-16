package ph.gov.deped.data.export;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;

/**
* Created by ej on 10/16/14.
*/
public class CellFormat implements XlsxStyleBuilder<CellStyle>, Serializable {

    private static final long serialVersionUID = -28263102408794187L;
    
    private FontStyle fontStyle;
    
    private String dataFormat;
    
    private Short borderWeightLeft;
    
    private Short borderWeightRight;
    
    private Short borderWeightTop;
    
    private Short borderWeightBottom;
    
    private Short borderColorLeft;
    
    private Short borderColorRight;
    
    private Short borderColorTop;
    
    private Short borderColorBottom;
    
    private Short fillPattern;
    
    private Short fillBackgroundColor;
    
    private Short indentation;
    
    private Short rotation;
    
    private Short verticalAlign;
    
    private Short horizontalAlign;
    
    private Boolean shrinkToFit;
    
    private Boolean wrapText;

    public void setFontStyle(FontStyle fontStyle) {
        this.fontStyle = fontStyle;
    }

    /**
     * @see org.apache.poi.ss.usermodel.DataFormat
     * @see org.apache.poi.ss.usermodel.CellStyle#setDataFormat(short)
     * @param dataFormat
     */
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public void setBorderWeightLeft(Short borderWeightLeft) {
        this.borderWeightLeft = borderWeightLeft;
    }

    public void setBorderWeightRight(Short borderWeightRight) {
        this.borderWeightRight = borderWeightRight;
    }

    public void setBorderWeightTop(Short borderWeightTop) {
        this.borderWeightTop = borderWeightTop;
    }

    public void setBorderWeightBottom(Short borderWeightBottom) {
        this.borderWeightBottom = borderWeightBottom;
    }

    public void setBorderColorLeft(Short borderColorLeft) {
        this.borderColorLeft = borderColorLeft;
    }

    public void setBorderColorRight(Short borderColorRight) {
        this.borderColorRight = borderColorRight;
    }

    public void setBorderColorTop(Short borderColorTop) {
        this.borderColorTop = borderColorTop;
    }

    public void setBorderColorBottom(Short borderColorBottom) {
        this.borderColorBottom = borderColorBottom;
    }

    public void setFillPattern(Short fillPattern) {
        this.fillPattern = fillPattern;
    }

    public void setFillBackgroundColor(Short fillBackgroundColor) {
        this.fillBackgroundColor = fillBackgroundColor;
    }

    public void setIndentation(Short indentation) {
        this.indentation = indentation;
    }

    public void setRotation(Short rotation) {
        this.rotation = rotation;
    }

    public void setVerticalAlign(Short verticalAlign) {
        this.verticalAlign = verticalAlign;
    }

    public void setHorizontalAlign(Short horizontalAlign) {
        this.horizontalAlign = horizontalAlign;
    }

    public void setShrinkToFit(Boolean shrinkToFit) {
        this.shrinkToFit = shrinkToFit;
    }

    public void setWrapText(Boolean wrapText) {
        this.wrapText = wrapText;
    }
    
    public CellStyle build(Workbook wb) {
        CellStyle cs = wb.createCellStyle();
        if (fontStyle != null) {
            cs.setFont(fontStyle.build(wb));
        }
        if (dataFormat != null) {
            DataFormat df = wb.createDataFormat();
            cs.setDataFormat(df.getFormat(this.dataFormat));
        }
        if (borderWeightLeft != null) {
            cs.setBorderLeft(borderWeightLeft.shortValue());
        }
        if (borderWeightRight != null) {
            cs.setBorderRight(borderWeightRight.shortValue());
        }
        if (borderWeightTop != null) {
            cs.setBorderTop(borderWeightTop.shortValue());
        }
        if (borderWeightBottom != null) {
            cs.setBorderBottom(borderWeightBottom.shortValue());
        }
        if (borderColorLeft != null) {
            cs.setLeftBorderColor(borderColorLeft.shortValue());
        }
        if (borderColorRight != null) {
            cs.setRightBorderColor(borderColorRight.shortValue());
        }
        if (borderColorTop != null) {
            cs.setTopBorderColor(borderColorTop.shortValue());
        }
        if (borderColorBottom != null) {
            cs.setBottomBorderColor(borderColorBottom.shortValue());
        }
        if (fillPattern != null) {
            cs.setFillPattern(fillPattern.shortValue());
        }
        if (fillBackgroundColor != null) {
            cs.setFillBackgroundColor(fillBackgroundColor.shortValue());
        }
        if (indentation != null) {
            cs.setIndention(indentation.shortValue());
        }
        if (rotation != null) {
            cs.setRotation(rotation.shortValue());
        }
        if (verticalAlign != null) {
            cs.setVerticalAlignment(verticalAlign.shortValue());
        }
        if (horizontalAlign != null) {
            cs.setAlignment(horizontalAlign.shortValue());
        }
        if (shrinkToFit != null && shrinkToFit) {
            cs.setShrinkToFit(shrinkToFit);
        }
        if (wrapText != null && wrapText) {
            cs.setWrapText(wrapText);
        }
        return cs;
    }
}
