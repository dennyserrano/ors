package ph.gov.deped.data.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.*;

/**
 * @author ej
 * @since Oct 27, 2014 09:52
 */
public class JsonResponse implements Externalizable {

    private static final long serialVersionUID = -7373381922664235378L;
    
    private String sessionId;
    
    private String code;
    
    private String message;

    public JsonResponse() {}

    @JsonCreator
    public JsonResponse(@JsonProperty("sessionId") String sessionId,
                        @JsonProperty("code") String code,
                        @JsonProperty("message") String message) {
        this.sessionId = sessionId;
        this.code = code;
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeChars(sessionId);
        out.writeChars(code);
        out.writeChars(message);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        sessionId = in.readLine();
        code = in.readLine();
        message = in.readLine();
    }
}
