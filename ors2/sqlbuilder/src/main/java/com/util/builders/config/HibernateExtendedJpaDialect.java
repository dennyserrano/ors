package com.util.builders.config;

import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: PSY
 * Date: 3/28/12
 * Time: 8:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateExtendedJpaDialect extends HibernateJpaDialect implements JpaDialect, Serializable {

    private static final long serialVersionUID = -7067525405487293658L;

    private FlushModeType flushMode = FlushModeType.AUTO;

    public void setFlushMode(FlushModeType flushMode) {
        this.flushMode = flushMode;
    }

    @Override
    public Object beginTransaction(EntityManager entityManager, TransactionDefinition definition) throws PersistenceException, SQLException, TransactionException {
        entityManager.setFlushMode(flushMode);
        if (definition.getTimeout() != TransactionDefinition.TIMEOUT_DEFAULT) {
            getSession(entityManager).getTransaction().setTimeout(definition.getTimeout());
        }
        entityManager.getTransaction().begin();
        return prepareTransaction(entityManager, definition.isReadOnly(), definition.getName());
    }
}
