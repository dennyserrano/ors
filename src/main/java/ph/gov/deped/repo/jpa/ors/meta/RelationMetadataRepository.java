package ph.gov.deped.repo.jpa.ors.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.meta.RelationMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

/**
 * @author ej
 * @since Nov 05, 2014 11:46
 */
@Repository
@RepositoryDefinition(domainClass = RelationMetadata.class, idClass = Integer.class)
public interface RelationMetadataRepository extends BaseJpaRepository<RelationMetadata, Integer> {
}
