package ph.gov.deped.common.query;

/**
 * Created by ej on 9/2/14.
 */
public abstract class QueryBuilders {

    public static ProjectionBuilder read() {
        return new SelectQueryBuilder();
    }
}
