package ph.gov.deped.common.command;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by ej on 8/20/14.
 */
public class RequestContext implements Serializable {

    private static final long serialVersionUID = 1617794913088944664L;

    private final Instant timestamp;

    public RequestContext() {
        this.timestamp = Instant.now();
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
