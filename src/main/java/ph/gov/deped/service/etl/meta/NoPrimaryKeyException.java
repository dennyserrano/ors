package ph.gov.deped.service.etl.meta;

/**
 * Created by ej on 9/11/14.
 */
public class NoPrimaryKeyException extends RuntimeException {

    private static final long serialVersionUID = -7454852372076129702L;

    private final String tableName;

    public NoPrimaryKeyException(String tableName) {
        super(String.format("Table [%s] has no primary key.", tableName));
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
