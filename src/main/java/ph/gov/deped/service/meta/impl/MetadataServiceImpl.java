package ph.gov.deped.service.meta.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bits.sql.BigDecimalValueMapper;
import com.bits.sql.DoubleValueMapper;
import com.bits.sql.FloatValueMapper;
import com.bits.sql.IntegerValueMapper;
import com.bits.sql.JdbcType;
import com.bits.sql.ShortValueMapper;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.RequestContext;
import ph.gov.deped.data.dto.ds.Dataset;
import ph.gov.deped.data.dto.ds.Element;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.ors.ds.DatasetRepository;
import ph.gov.deped.repo.jpa.ors.ds.ElementRepository;
import ph.gov.deped.service.meta.api.FindAllDatasetsRequest;
import ph.gov.deped.service.meta.api.FindAllDatasetsResponse;
import ph.gov.deped.service.meta.api.FindDatasetRequest;
import ph.gov.deped.service.meta.api.FindDatasetResponse;
import ph.gov.deped.service.meta.api.MetadataService;
import ph.gov.deped.service.meta.api.MetadataSynchronizationException;
import ph.gov.deped.service.meta.api.SynchronizeMetadataContext;
import ph.gov.deped.service.meta.api.SynchronizeMetadataRequest;
import ph.gov.deped.service.meta.api.SynchronizeMetadataResponse;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ej on 8/20/14.
 */
public @Service class MetadataServiceImpl implements MetadataService {

    private static final Logger log = LogManager.getLogger(MetadataServiceImpl.class);

    private static final String[] aggregateList=new String[]{
    	"decimal",
    	"double",
    	"float",
    	"mediumint",
    	"smallint",
    	"tinyint"
    	};

    private SynchronizeMetadataCommand synchronizeMetadataCommand;

    private FindAllDatasetsCommand findAllDatasetsCommand;

    private FindDatasetCommand findDatasetCommand;

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;

    public @Autowired void setSynchronizeMetadataCommand(SynchronizeMetadataCommand synchronizeMetadataCommand) {
        this.synchronizeMetadataCommand = synchronizeMetadataCommand;
    }

    public @Autowired void setFindAllDatasetsCommand(FindAllDatasetsCommand findAllDatasetsCommand) {
        this.findAllDatasetsCommand = findAllDatasetsCommand;
    }

    public @Autowired void setFindDatasetCommand(FindDatasetCommand findDatasetCommand) {
        this.findDatasetCommand = findDatasetCommand;
    }

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public @Transactional(AppMetadata.TXM) void startSynchronizing() throws MetadataSynchronizationException {
        log.entry();
        SynchronizeMetadataContext context = new SynchronizeMetadataContext(new SynchronizeMetadataRequest());
        synchronizeMetadataCommand.execute(context);
        SynchronizeMetadataResponse response = context.getResponse();
        if (!response.getResponseContext().successful()) {
            throw new MetadataSynchronizationException();
        }
        log.exit();
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<? extends Dataset> findTopLevelDatasets() {
        FindAllDatasetsRequest request = new FindAllDatasetsRequest(new RequestContext());
        FindAllDatasetsContext context = new FindAllDatasetsContext(request);
        findAllDatasetsCommand.execute(context);
        FindAllDatasetsResponse response = context.getResponse();
        return response.getDatasets();
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) Dataset findDataset(long id) {
        FindDatasetRequest request = new FindDatasetRequest(new RequestContext(), id);
        FindDatasetContext context = new FindDatasetContext(request);
        findDatasetCommand.execute(context);
        FindDatasetResponse response = context.getResponse();
        return response.getDataset();
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findOwnedDatasets(int ownerId) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerId(true, ownerId, new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        return datasetHeads.parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), dh.getParentDatasetHead()))
                .collect(toList());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findNotOwnedDatasets(int ownerId) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerIdNot(true, ownerId, new Sort(Sort.Direction.ASC, DatasetHead.NAME));
        return datasetHeads.parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), dh.getParentDatasetHead()))
                .collect(toList());
    }

    public @Transactional Dataset saveDataset(Dataset dataset) {

        return dataset;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Dataset> findSubdatasets(long headId)  {
        List<DatasetHead> subdatasets = datasetRepository.findByParentDatasetHead(headId);
        return subdatasets.parallelStream()
                .map(sd -> findDataset(sd.getId()))
                .collect(toList());
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) List<Element> findElements(long headId) {
        List<DatasetElement> datasetElements = elementRepository.findByDatasetId(headId);
        return datasetElements.parallelStream()
                .map(de -> new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), headId,de.isVisible(),isAggregate(de)))
                .collect(toList());
    }
    
    private boolean isAggregate(DatasetElement de)
    {
    	
    	for(String dataType: aggregateList)
    	{
    		if(de.getColumnMetaData().getDataType().equals(dataType))
    			return true;
    	}
    	
    	return false;
    }
}
