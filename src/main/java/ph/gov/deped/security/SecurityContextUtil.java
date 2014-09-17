package ph.gov.deped.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by ej on 8/20/14.
 */
public class SecurityContextUtil {

    public String getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        else {
            return String.valueOf(principal);
        }
    }

    public boolean hasAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication() != null;
    }

    public void setAuthentication(Authentication authentication) {
        SecurityContextHolder.clearContext();
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    public Authentication createInternalUserAuthentication(String principal, GrantedAuthority... authorities) {
        Authentication auth = new InternalUserAuthentication(principal, authorities);
        setAuthentication(auth);
        return auth;
    }

    public void removeAuthentication() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}
