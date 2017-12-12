package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.model.db.DatasetHead;
import com.model.support.Dataset;
import com.repo.meta.DatasetRepository;

import ph.gov.deped.common.AppMetadata;
import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindAllDatasetsCommand implements ICommand<FindAllDatasetsContext> {

    private DatasetRepository datasetRepository;

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Transactional(value = AppMetadata.TXM, readOnly = true) void execute(FindAllDatasetsContext context) {
        List<DatasetHead> datasetHeads = datasetRepository.findByVisibleAndOwnerId(true, 1, new Sort(Sort.Direction.ASC, DatasetHead.RANKING));
        
        datasetHeads.sort((h1, h2) -> h1.compareTo(h2));
        List<Dataset> datasets = datasetHeads.stream()
                .map(head -> {
                    Dataset dataset = new Dataset(head.getId(), head.getName(), head.getDescription(), head.getParentDatasetHead());
//                    dataset.setSubDatasets(findChildDatasets(dataset));
                    return dataset;
                }).collect(Collectors.toCollection(LinkedList::new));
        context.setDatasets(datasets);
        context.createResponse();
    }
    
    private List<Dataset> findChildDatasets(Dataset parent) {
        return datasetRepository.findByParentDatasetHeadAndVisible(parent.getId(), true)
                .parallelStream()
                .map(sd -> new Dataset(sd.getId(), sd.getName(), sd.getDescription(), sd.getParentDatasetHead()))
                .map(dataset -> {
                    dataset.setSubDatasets(findChildDatasets(dataset));
                    return dataset;
                })
                .collect(Collectors.toList());
    }
}
