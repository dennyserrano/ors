package ph.gov.deped.repo.jpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import ph.gov.deped.data.JpaEntity;
import ph.gov.deped.security.SecurityContextUtil;

import javax.persistence.EntityManager;

import java.io.Serializable;

/**
 * Created by ej on 8/20/14.
 */
public class BaseJpaRepositoryFactoryBean<R extends JpaRepository<T, ID>, T extends JpaEntity<ID>, ID extends Serializable>
        extends JpaRepositoryFactoryBean<R, T, ID> {

    private @Autowired SecurityContextUtil securityContextUtil;

    public @Override RepositoryFactorySupport createRepositoryFactory(EntityManager em) {
        return new BaseJpaRepositoryFactory<>(em, securityContextUtil);
    }

    @SuppressWarnings({"unchecked"})
    private static class BaseJpaRepositoryFactory<T extends JpaEntity<ID>, ID extends Serializable> extends JpaRepositoryFactory {

        private final SecurityContextUtil securityContextUtil;

        private final EntityManager entityManager;

        public BaseJpaRepositoryFactory(EntityManager entityManager, SecurityContextUtil securityContextUtil) {
            super(entityManager);
            this.securityContextUtil = securityContextUtil;
            this.entityManager = entityManager;
        }

        protected @Override SimpleJpaRepository<T, ID> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {
            return new BaseJpaRepositorySupport<>((Class<T>) metadata.getDomainType(), entityManager, securityContextUtil);
        }

        protected @Override Object getTargetRepository(RepositoryMetadata metadata) {
            return new BaseJpaRepositorySupport<>((Class<T>) metadata.getDomainType(), entityManager, securityContextUtil);
        }

        protected @Override Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return BaseJpaRepository.class;
        }
    }
}
