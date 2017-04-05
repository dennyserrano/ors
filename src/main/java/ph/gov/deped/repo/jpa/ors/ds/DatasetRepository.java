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
public interface DatasetRepository extends BaseJpaRepository<DatasetHead, Long> {

    @Override DatasetHead findOne(Long id);

    List<DatasetHead> findByVisibleAndOwnerId(boolean visible, int ownerId, Sort sort);

    List<DatasetHead> findByVisibleAndOwnerIdNot(boolean visible, int ownerId, Sort sort);

    DatasetHead findByName(String name);

    List<DatasetHead> findByParentDatasetHead(Long id);

    List<DatasetHead> findByParentDatasetHeadAndVisible(Long id, boolean visible);

    @Query("select distinct dh from DatasetHead dh "
    		+ "join fetch dh.tableMetaData "
    		+ "join fetch dh.datasetElements de "
    		+ "join fetch de.columnMetaData where dh.id in (3)")
    List<DatasetHead> findMe();
    
}
