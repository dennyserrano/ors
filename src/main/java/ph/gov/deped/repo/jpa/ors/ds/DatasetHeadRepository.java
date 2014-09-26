package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.ds.DatasetHead;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetHead.class, idClass = Long.class)
public interface DatasetHeadRepository extends BaseJpaRepository<DatasetHead, Long> {

    @Override DatasetHead findOne(Long id);

    List<DatasetHead> findByVisibleAndOwnerId(boolean visible, int ownerId, Sort sort);

    DatasetHead findByName(String name);

    @Query("SELECT h FROM DatasetTable t JOIN t.datasetHead h WHERE t.tableId IS NOT NULL")
    List<DatasetHead> findAllPhysicalTables();
}
