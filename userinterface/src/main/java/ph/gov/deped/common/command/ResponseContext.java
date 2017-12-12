package ph.gov.deped.common.command;

import java.io.Serializable;
import java.time.Instant;

/**
 * Created by ej on 8/20/14.
 */
public class ResponseContext implements Serializable {

    private static final long serialVersionUID = -5782062332601867637L;

    private final Instant timestamp;

    private final CommandState commandState;

    public ResponseContext(boolean success) {
        this.commandState = success ? CommandState.SUCCESS : CommandState.FAILED;
        this.timestamp = Instant.now();
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public CommandState getCommandState() {
        return commandState;
    }

    public boolean successful() {
        return CommandState.SUCCESS == commandState;
    }
}
