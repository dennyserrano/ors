package ph.gov.deped.data.dto;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.model.support.Dataset;
import com.model.support.Element;

/**
 * @author ej
 * @since Nov 17, 2014 17:55
 */
public class ElementsTable implements Serializable {
    
    private static final long serialVersionUID = 9002503694801097957L;
    
    private List<Dataset> datasets = new ArrayList<>();
    
    private List<Map<Long, Element>> elements = new ArrayList<>();

    public List<Dataset> getDatasets() {
        return datasets;
    }
    
    public void addDataset(Dataset dataset) {
        datasets.add(dataset);
    }

    public List<Map<Long, Element>> getElements() {
        return elements;
    }

    public void setElements(List<Map<Long, Element>> elements) {
        this.elements = elements;
    }
    
    public Integer getDatasetsCount() {
        return datasets.size();
    }

    public List<Long> getElementsIndex() {
        int count = elements.size();
        List<Long> rowIdx = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rowIdx.add(new Long(i));
        }
        return rowIdx;
    }
}
