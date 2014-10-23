package ph.gov.deped.service.export.xlsx;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.Serializable;

/**
* Created by ej on 10/16/14.
*/
public class CellFormat implements XlsxStyleBuilder<CellStyle>, Serializable {
    
    public static final String[] FIELDS = new String[] {
            "fontStyle", "dataFormat", "cellType", "indentation", "rotation",
            "verticalAlign", "horizontalAlign", "shrinkToFit", "wrapText"
    };

    private static final long serialVersionUID = -28263102408794187L;
    
    private FontStyle fontStyle;
    
    private String dataFormat;
    
    private Integer cellType;
    
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

    /**
     * @see org.apache.poi.ss.usermodel.Cell
     * 
     * @param cellType
     */
    public void setCellType(int cellType) {
        this.cellType = cellType;
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

    protected Integer getCellType() {
        return cellType;
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
        if (shrinkToFit != null) {
            cs.setShrinkToFit(shrinkToFit);
        }
        if (wrapText != null) {
            cs.setWrapText(wrapText);
        }
        return cs;
    }
}
