package com.repo.meta;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.model.db.DatasetFilterChain;
import com.repo.base.BaseJpaRepository;

/**
 * Created by ej on 8/19/14.
 */
@Repository
@RepositoryDefinition(domainClass = DatasetFilterChain.class, idClass = Long.class)
public interface FilterChainRepository{ //extends BaseJpaRepository<DatasetFilterChain, Long> {
}
