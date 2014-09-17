package ph.gov.deped.repo.jpa.ors.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.meta.TableMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * Created by ej on 8/15/14.
 */
@Repository
@RepositoryDefinition(domainClass = TableMetadata.class, idClass = Integer.class)
public interface TableMetadataRepository extends BaseJpaRepository<TableMetadata, Integer> {
}
