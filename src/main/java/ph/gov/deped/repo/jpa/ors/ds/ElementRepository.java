package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetElement.class, idClass = Long.class)
public interface ElementRepository extends BaseJpaRepository<DatasetElement, Long> {

    @Override DatasetElement findOne(Long id);

    List<DatasetElement> findByDatasetHead(DatasetHead datasetHead);

    DatasetElement findByDatasetHeadAndName(DatasetHead datasetHead, String name);
}
