package ph.gov.deped.common.query;

import static org.apache.commons.lang3.StringUtils.startsWith;

/**
 * Created by PSY on 2014/09/03.
 */
public class ParameterExpression implements Expression<String> {

    private final String parameter;

    public ParameterExpression(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter.trim();
    }

    public String get() {
        return startsWith(getParameter(), ":") ? getParameter() : ":" + getParameter();
    }
}
