package com.util.builders.config;

import org.joda.time.DateTime;
import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.model.db.JpaEntity;
import com.repo.base.BaseJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ej on 8/20/14.
 */
@NoRepositoryBean
public class BaseJpaRepositorySupport<T extends JpaEntity<ID>, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseJpaRepository<T, ID> {

//    private static final Set<String> excludedProps = new HashSet<>(
//            Arrays.asList(
//                    BaseJpaEntity.CREATED_BY,
//                    BaseJpaEntity.DATE_CREATED,
//                    BaseJpaEntity.UPDATED_BY,
//                    BaseJpaEntity.DATE_UPDATED,
//                    BaseJpaEntity.LAST_MODIFIED_BY,
//                    BaseJpaEntity.LAST_MODIFIED_DATE
//            )
//    );

    private final EntityManager em;

    private final Class<T> persistentClass;


    public BaseJpaRepositorySupport(Class<T> domainClass, EntityManager em ) {
        super(domainClass, em);
        this.em = em;
        this.persistentClass = domainClass;
        
    }

    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }

    @SuppressWarnings({"unchecked"})
    public T insert(T entity) {
        
//        if (entity instanceof Auditable) {
//            Auditable<String, ID> ae = (Auditable<String, ID>) entity;
//            ae.setCreatedBy(createdBy);
//            ae.setCreatedDate(DateTime.now());
//            if (!entity.isNew()) {
//                ae.setLastModifiedBy(createdBy);
//                ae.setLastModifiedDate(DateTime.now());
//            }
//        }
        return super.save(entity);
    }

    @SuppressWarnings({"unchecked"})
    public @Override <S extends T> S save(S entity) {
//        final String createdBy = securityContextUtil.getPrincipal();
//        if (entity instanceof Auditable) {
//            Auditable<String, ID> ae = (Auditable<String, ID>) entity;
//            ae.setCreatedBy(createdBy);
//            ae.setCreatedDate(DateTime.now());
//            if (!entity.isNew()) {
//                ae.setLastModifiedBy(createdBy);
//                ae.setLastModifiedDate(DateTime.now());
//            }
//        }
        return super.save(entity);
    }

    public Collection<T> findAllByPage(int pageNum, int countPerPage, Sort.Order order) {
        PageRequest pg = new PageRequest(pageNum, countPerPage, new Sort(order));
        return super.findAll(pg).getContent();
    }

    public boolean hasValue(String property, Serializable value) {
//        if (excludedProps.contains(property)) {
//            return false;
//        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getPersistentClass());
        Root<T> root = cq.from(getPersistentClass());
        cb.and(cb.conjunction(), cb.equal(root.get(property), value));
        return em.createQuery(cq).getMaxResults() > 0;
    }
}
