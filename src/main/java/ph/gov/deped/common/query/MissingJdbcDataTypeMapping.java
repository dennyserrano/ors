package ph.gov.deped.common.query;

public class MissingJdbcDataTypeMapping extends RuntimeException {

    private static final long serialVersionUID = 614975031130412045L;

    private final String colType;

    public MissingJdbcDataTypeMapping(String colType) {
        super(String.format("Missing Data type mapping for [%s].", colType));
        this.colType = colType;
    }

    public String getColType() {
        return colType;
    }
}
