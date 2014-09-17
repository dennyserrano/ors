package ph.gov.deped.common.query;

/**
 * Created by ej on 9/2/14.
 */
public interface CriteriaFilterBuilder {

    CriteriaChainBuilder eq(String value);

    CriteriaChainBuilder eq(Number value);

    CriteriaChainBuilder eq(Character character);

    CriteriaChainBuilder is(Boolean value);

    CriteriaChainBuilder isNotNull();

    CriteriaChainBuilder isNull();
}
