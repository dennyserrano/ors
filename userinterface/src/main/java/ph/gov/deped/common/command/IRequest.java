package ph.gov.deped.common.command;

import java.io.Serializable;

/**
 * Created by ej on 8/20/14.
 */
public interface IRequest extends Serializable {

    RequestContext getRequestContext();
}
