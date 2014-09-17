package ph.gov.deped.service.etl.meta;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ej on 8/14/14.
 */
public class MetadataRegistry {

    private static final ConcurrentMap<String, MetadataHolder> meta = new ConcurrentHashMap<>();
    
    public void register(String key, MetadataHolder holder) {
        if (!meta.containsKey(key)) {
            meta.put(key, holder);
        }
    }
    
    public Set<String> getMetadataKeys() {
        return meta.keySet();
    }
    
    public MetadataHolder getMetadata(String key) {
        return meta.get(key);
    }
}
