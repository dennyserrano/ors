package ph.gov.deped.service.etl.ds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.annotation.Autowired;

import ph.gov.deped.service.etl.meta.MetadataHolder;
import ph.gov.deped.service.etl.meta.MetadataRegistry;

/**
* Created by ej on 9/10/14.
*/
public class PhysicalTableItemReader extends AbstractItemCountingItemStreamItemReader<MetadataHolder> {

    private @Autowired MetadataRegistry metadataRegistry;

    private List<String> keys;

    public PhysicalTableItemReader() {
        setName("PhysicalTableItemReader");
        setSaveState(false);
    }

    protected void doOpen() throws Exception {
        keys = new ArrayList<>(metadataRegistry.getMetadataKeys());
    }

    protected MetadataHolder doRead() throws Exception {
        return metadataRegistry.getMetadata(keys.get(getCurrentItemCount()));
    }

    protected void doClose() throws Exception {
        keys = null;
    }
}
