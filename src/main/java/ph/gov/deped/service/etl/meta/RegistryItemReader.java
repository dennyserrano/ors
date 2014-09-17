package ph.gov.deped.service.etl.meta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.annotation.Autowired;

/**
* Created by ej on 8/28/14.
*/
public class RegistryItemReader extends AbstractItemCountingItemStreamItemReader<String>
        implements ItemStreamReader<String> {

    private static final Logger log = LogManager.getLogger(RegistryItemReader.class);

    private List<String> keyClasses = new ArrayList<>();

    private MetadataRegistry metadataRegistry;

    public RegistryItemReader() {
        setName("RegistryItemReader");
        setSaveState(false);
    }

    public @Autowired void setMetadataRegistry(MetadataRegistry metadataRegistry) {
        this.metadataRegistry = metadataRegistry;
    }

    protected void doOpen() throws Exception {
        Set<String> keyClassSet = metadataRegistry.getMetadataKeys();
        log.trace("Found entity classes [{}].", keyClassSet.size());
        keyClasses.addAll(keyClassSet);
        setMaxItemCount(keyClassSet.size() - 1);
        setCurrentItemCount(-1);
    }

    protected String doRead() throws Exception {
        return keyClasses.get(getCurrentItemCount());
    }

    protected void doClose() throws Exception {
        keyClasses.clear();
    }
}
