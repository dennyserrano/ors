package ph.gov.deped.common;

/**
 * Created by ej on 8/13/14.
 */
public interface HiveMetadata extends Constants {

    public static final String HIVE = "HIVE";

    public static final String hive = "hive";

    public static final String HIVE_PROPERTIES = hive + PROPS_SUFFIX;

    public static final String HIVE_DS = hive + DS_SUFFIX;

    public static final String HIVE_SCHEMA = "deped";

    public static final String FORMAT_PARQUET = "parquet";

    public static final String FORMAT_AVRO = "avro";

    public static final String FORMAT_CSV = "csv";

    public static final String HIVE_JDBC_TEMPLATE = "hiveJdbcTemplate";
}
