package ph.gov.deped.common.command;

import java.io.Serializable;

/**
 * Created by ej on 8/20/14.
 */
public interface IContext<REQ extends IRequest, RES extends IResponse> extends Serializable {

    REQ getRequest();

    RES getResponse();
}
