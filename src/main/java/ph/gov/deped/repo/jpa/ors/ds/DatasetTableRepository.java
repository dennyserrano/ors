package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.data.ors.ds.DatasetTable;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetTable.class, idClass = Long.class)
public interface DatasetTableRepository extends BaseJpaRepository<DatasetTable, Long> {

    List<DatasetTable> findByDatasetHead(DatasetHead datasetHead);
}
