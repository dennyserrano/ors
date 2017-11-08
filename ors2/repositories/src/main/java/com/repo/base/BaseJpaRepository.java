package com.repo.base;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.db.JpaEntity;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by ej on 8/20/14.
 */
@NoRepositoryBean
public interface BaseJpaRepository<T extends JpaEntity<ID>, ID extends Serializable>
        extends PagingAndSortingRepository<T, ID>, JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    @Modifying
    T insert(T entity);

    Collection<T> findAllByPage(int pageNum, int countPerPage, Sort.Order order);

    boolean hasValue(String property, Serializable value);
}
