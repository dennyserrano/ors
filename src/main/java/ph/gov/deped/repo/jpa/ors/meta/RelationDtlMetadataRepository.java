package ph.gov.deped.repo.jpa.ors.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ph.gov.deped.data.ors.meta.RelationDtlMetadata;
import ph.gov.deped.repo.jpa.api.BaseJpaRepository;

import java.util.List;

/**
 * @author ej
 * @since Nov 05, 2014 11:46
 */
@Repository
@RepositoryDefinition(domainClass = RelationDtlMetadata.class, idClass = Integer.class)
public interface RelationDtlMetadataRepository extends BaseJpaRepository<RelationDtlMetadata, Integer> {
    
    List<RelationDtlMetadata> findByRelationId(Integer relationId);
}
