package ph.gov.deped.common.query;

/**
 * Created by ej on 9/11/14.
 */
public abstract class Projections {
    
    public static Projection column(String columnName) {
        return new Projection(columnName);
    }

    public static Projection column(String tablePrefix, String columnName, String alias) {
        return new Projection(tablePrefix, columnName, alias);
    }
}
