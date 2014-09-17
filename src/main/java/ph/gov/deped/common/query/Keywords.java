package ph.gov.deped.common.query;

/**
 * Created by PSY on 2014/09/03.
 */
public abstract class Keywords {

    public static final SqlExpression SELECT = () -> "SELECT ";

    public static final SqlExpression FROM = () -> " FROM ";

    public static final SqlExpression AS = () -> " AS ";

    public static final SqlExpression JOIN = () -> " JOIN ";

    public static final SqlExpression ON = () -> " ON ";

    public static final SqlExpression WHERE = () -> " WHERE ";

    public static final SqlExpression NULL = () -> " NULL";

    public static final SqlExpression ORDER_BY = () -> " ORDER BY ";

    public static final SqlExpression DESC = () -> " DESC";
}
