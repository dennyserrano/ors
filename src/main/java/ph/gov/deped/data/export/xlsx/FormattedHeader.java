package ph.gov.deped.data.export.xlsx;

import java.io.Serializable;

/**
 * Created by ej on 10/16/14.
 */
public class FormattedHeader implements FormattedValue, Serializable {

    private static final long serialVersionUID = -5250741297468936971L;
    
    private final String header;
    
    private final CellFormat cf;

    public FormattedHeader(String header) {
        this.header = header;
        this.cf = Formats.text();
        this.cf.setFontStyle(Formats.bold());
        this.cf.setWrapText(true);
    }

    public CellFormat getCellFormat() {
        return cf;
    }

    public String getCellContents() {
        return this.header;
    }
}
