package ph.gov.deped.data.dto.ds;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ej on 8/28/14.
 */
public class Dataset implements Serializable {

    private static final long serialVersionUID = -7999904235124974013L;

    private long id;

    private String name;

    private String description;

    private List<Dataset> subDatasets = new ArrayList<>();

    private List<Element> elements = new ArrayList<>();

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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDatasets(List<Dataset> subDatasets) {
        this.subDatasets = subDatasets;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Dataset)) {
            return false;
        }
        Dataset rhs = (Dataset) obj;
        return new EqualsBuilder()
                .append(this.id, rhs.id)
                .append(this.name, rhs.name)
                .append(this.description, rhs.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(name)
                .append(description)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", name)
                .append("description", description)
                .append("subDatasets", subDatasets)
                .append("elements", elements)
                .append("icon", icon)
                .toString();
    }
}
