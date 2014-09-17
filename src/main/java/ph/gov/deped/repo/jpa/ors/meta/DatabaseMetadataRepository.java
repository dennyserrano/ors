package ph.gov.deped.repo.jpa.ors.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.meta.DatabaseMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by ej on 8/15/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatabaseMetadata.class, idClass = Integer.class)
public interface DatabaseMetadataRepository extends BaseJpaRepository<DatabaseMetadata, Integer> {
}
