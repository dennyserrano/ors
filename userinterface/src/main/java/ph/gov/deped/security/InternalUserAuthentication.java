package ph.gov.deped.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ej on 8/20/14.
 */
public class InternalUserAuthentication extends AbstractAuthenticationToken implements Authentication, Serializable {

    private static final long serialVersionUID = 4508262447071523882L;

    private final String internalUserId;

    public InternalUserAuthentication(String internalUserId, GrantedAuthority... authorities) {
        super(new ArrayList<>(Arrays.asList(authorities)));
        this.internalUserId = internalUserId;
    }

    public Object getCredentials() {
        return null;
    }

    public Object getPrincipal() {
        return internalUserId;
    }

    public String getInternalUserId() {
        return internalUserId;
    }
}
