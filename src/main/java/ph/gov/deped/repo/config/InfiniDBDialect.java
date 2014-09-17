package ph.gov.deped.repo.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by ej on 9/1/14.
 */
public class InfiniDBDialect extends MySQL5InnoDBDialect {

    public @Override String getTableTypeString() {
        return " Engine=InfiniDB";
    }
}
