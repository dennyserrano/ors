package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.db.DatasetElement;
import com.model.db.DatasetHead;

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
    
    List<DatasetElement> findByDatasetHeadId(Long datasetHeadHd);
    
    @Query("select de from DatasetElement de "
    	 + "join fetch de.columnMetaData "
    	 + "where de.datasetHead.id=?1")
    List<DatasetElement> findByDatasetId(Long datasetId);

    DatasetElement findByDatasetHeadAndName(DatasetHead datasetHead, String name);

    DatasetElement findByDatasetHeadIdAndName(long id, String schoolYear);
}
