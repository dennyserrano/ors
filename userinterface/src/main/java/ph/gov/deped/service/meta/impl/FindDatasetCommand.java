package ph.gov.deped.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;
import com.model.support.Dataset;
import com.model.support.Element;
import com.repo.meta.DatasetRepository;
import com.repo.meta.ElementRepository;

import ph.gov.deped.common.command.Command;
import ph.gov.deped.common.command.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ej on 9/5/14.
 */
public @Command class FindDatasetCommand implements ICommand<FindDatasetContext> {

    private DatasetRepository datasetRepository;

    private ElementRepository elementRepository;

    public @Autowired void setDatasetRepository(DatasetRepository datasetRepository) {
        this.datasetRepository = datasetRepository;
    }

    public @Autowired void setElementRepository(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    public void execute(FindDatasetContext context) {
        final long id = context.getRequest().getId();
        DatasetHead head = datasetRepository.findOne(id);
//        List<DatasetElement> datasetElements = elementRepository.findByDatasetHead(head);

        List<Dataset> subDatasets = datasetRepository.findByParentDatasetHead(head.getId())
                .parallelStream()
                .map(dh -> new Dataset(dh.getId(), dh.getName(), dh.getDescription(), head.getId()))
                .collect(Collectors.toList());

//        List<Element> elements = datasetElements.parallelStream()
//                .map(de -> new Element(de.getId(), de.getName(), de.getDescription(), de.getMeaning(), head.getId(),de.isVisible(),false))
//                .collect(Collectors.toList());
        
        context.setDataset(new Dataset(head.getId(), head.getName(), head.getDescription(), head.getParentDatasetHead(), subDatasets,new ArrayList<Element>()));
        context.createResponse();
    }
}
