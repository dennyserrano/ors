package ph.gov.deped.repo.jpa.ors.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.meta.ColumnMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * Created by ej on 8/15/14.
 */
@Repository
@RepositoryDefinition(domainClass = ColumnMetadata.class, idClass = Integer.class)
public interface ColumnMetadataRepository extends BaseJpaRepository<ColumnMetadata, Integer> {

    List<ColumnMetadata> findByTableId(Integer tableId);
}
