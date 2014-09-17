package ph.gov.deped.data.dto.ds;

import java.io.Serializable;

/**
 * Created by ej on 8/28/14.
 */
public class Element implements Serializable {

    private static final long serialVersionUID = 5051970119831782659L;

    private final long id;

    private final String name;

    private final String description;

    private final String meaning;

    private final long datasetId;

    public Element(long id, String name, String description, String meaning, long datasetId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.meaning = meaning;
        this.datasetId = datasetId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMeaning() {
        return meaning;
    }

    public long getDatasetId() {
        return datasetId;
    }
}
