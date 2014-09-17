package ph.gov.deped.data.dto.ds;

import java.io.Serializable;

/**
 * Created by ej on 8/28/14.
 */
public class Column extends Element implements Serializable {

    private static final long serialVersionUID = 158117985957771716L;

    private final int columnId;

    public Column(long id, String name, String desccription, String meaning, long datasetId, int columnId) {
        super(id, name, desccription, meaning, datasetId);
        this.columnId = columnId;
    }

    public int getColumnId() {
        return columnId;
    }
}
