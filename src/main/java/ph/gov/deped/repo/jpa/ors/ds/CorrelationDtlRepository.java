package ph.gov.deped.repo.jpa.ors.ds;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.db.DatasetCorrelation;
import com.model.db.DatasetCorrelationDtl;

import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by PSY on 2014/09/30.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetCorrelationDtl.class, idClass = Long.class)
public interface CorrelationDtlRepository extends BaseJpaRepository<DatasetCorrelationDtl, Long> {

    List<DatasetCorrelationDtl> findByDatasetCorrelation(DatasetCorrelation datasetCorrelation);
}
