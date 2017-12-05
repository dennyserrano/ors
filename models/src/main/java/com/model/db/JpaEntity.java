package com.model.db;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * Created by ej on 8/20/14.
 */
public interface JpaEntity<ID extends Serializable> extends Serializable, Persistable<ID> {

    default boolean isNew() {
        return getId() == null;
    }

    @Override boolean equals(Object o);

    @Override int hashCode();

    @Override String toString();
}
