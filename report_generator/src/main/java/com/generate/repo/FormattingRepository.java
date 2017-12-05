package com.generate.repo;

import com.generate.styles.ElementFormatter;


/**
 * @author ej
 * @since Oct 22, 2014 18:15
 */
public interface FormattingRepository {
    
    ElementFormatter findByKey(String key);
    
    ElementFormatter findByDatasetElement(long headId, String elementName);
}
