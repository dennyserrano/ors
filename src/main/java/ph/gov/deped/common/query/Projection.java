package ph.gov.deped.common.query;

import ph.gov.deped.data.ors.ds.DatasetElement;
import ph.gov.deped.data.ors.meta.ColumnMetadata;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static ph.gov.deped.common.query.Keywords.AS;
/**
 * Created by ej on 9/2/14.
 */
public class Projection extends ColumnExpression {

    private final String alias;

    public Projection(ColumnMetadata columnMetadata, String alias) {
        super(columnMetadata);
        this.alias = alias;
    }

    public Projection(String tablePrefix, ColumnMetadata columnMetadata, String alias) {
        super(tablePrefix, columnMetadata);
        this.alias = alias;
    }

    public Projection(DatasetElement element, String alias) {
        super(element);
        this.alias = alias;
    }

    public Projection(String tablePrefix, DatasetElement element, String alias) {
        super(tablePrefix, element);
        this.alias = alias;
    }
    
    public Projection(String tablePrefix, String columnName, String alias) {
        super(tablePrefix, columnName);
        this.alias = alias;
    }
    
    public Projection(String columnName) {
        super(columnName);
        this.alias = "";
    }

    public String getAlias() {
        return alias;
    }

    public @Override String get() {
        return isBlank(getAlias()) ? super.get() : super.get() + AS.get() + getAlias();
    }
}
