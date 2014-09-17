package ph.gov.deped.common.query;

/**
 * Created by ej on 9/2/14.
 */
public class WildcardProjection extends Projection {

    public WildcardProjection() {
        super("", "*", null);
    }

    public WildcardProjection(String tablePrefix) {
        super(tablePrefix, "*", null);
    }
}
