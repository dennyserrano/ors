package ph.gov.deped.data.config;

import java.util.HashMap;
import java.util.Map;

import ph.gov.deped.common.EbeisMetadata;
import ph.gov.deped.common.LisMetadata;
import ph.gov.deped.common.dw.DbType;

public abstract class DbMappings {

    private static final Map<String, DbType> map = new HashMap<>();
    
    static {
        map.put(EbeisMetadata.DS, DbType.EBEIS);
        map.put(LisMetadata.DS, DbType.LIS);
    }
    
    public static DbType getDbType(String dataSourceName) {
        return map.get(dataSourceName);
    }
}
