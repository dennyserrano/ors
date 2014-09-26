package ph.gov.deped.common.dw;

/**
 * Created by ej on 8/14/14.
 */
public enum DbType {
    EBEIS {
        public String getDbName() { return "sisdb"; }
    },
    LIS {
        public String getDbName() { return "lis2db"; }
    },
    DWRHS {
        public String getDbName() { return "sisdbtest"; }
    };

    public static DbType findByName(String dbName) {
        for (DbType dbType : values()) {
            if (dbName.equals(dbType.getDbName())) {
                return dbType;
            }
        }
        return DbType.DWRHS;
    }

    public static DbType findById(int id) {
        return values()[id];
    }

    public abstract String getDbName();
    
    public @Override String toString() {
        return getDbName().toUpperCase();
    }
}
