package ph.gov.deped.data.dto.ds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ej on 8/28/14.
 */
public class Dataset implements Serializable {

    private static final long serialVersionUID = -7999904235124974013L;

    private final long id;

    private final String name;

    private final String description;

    private final List<Dataset> subDatasets = new ArrayList<>();

    private final List<Element> elements = new ArrayList<>();

    private String icon;

    public Dataset(long id, String name, String description) {
        this(id, name, description, Collections.emptyList(), Collections.emptyList());
    }

    public Dataset(long id, String name, String description, List<? extends Dataset> subDatasets, List<? extends Element> elements) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subDatasets.addAll(subDatasets);
        this.elements.addAll(elements);
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

    public List<? extends Dataset> getSubDatasets() {
        return Collections.unmodifiableList(this.subDatasets);
    }

    public List<? extends Element> getElements() {
        return Collections.unmodifiableList(this.elements);
    }

    public int getSubDatasetsCount() {
        return subDatasets.size();
    }

    public int getElementsCount() {
        return elements.size();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isPhysical() {
        return false;
    }
}
