package ph.gov.deped.repo.jpa.ors;

import ph.gov.deped.service.export.xlsx.ElementFormatter;

/**
 * @author ej
 * @since Oct 22, 2014 18:15
 */
public interface FormattingRepository {
    
    ElementFormatter findByKey(String key);
    
    ElementFormatter findByDatasetElement(long headId, String elementName);
}
