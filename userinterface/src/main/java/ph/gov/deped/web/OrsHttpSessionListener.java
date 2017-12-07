package ph.gov.deped.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * @author ej
 * @since Nov 03, 2014 10:21
 */
public class OrsHttpSessionListener implements HttpSessionListener {

    private static final Logger log = LogManager.getLogger(OrsHttpSessionListener.class);

    public OrsHttpSessionListener() {
        log.info("OrsHttpSessionListener instantiated.");
    }
    
    public void sessionCreated(HttpSessionEvent se) {
        log.debug("HTTP Session Created [{}]", se.getSession().getId());
        log.debug("HTTP Session Created on [{}]", new Date(se.getSession().getCreationTime()));
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        log.debug("HTTP Session Destroyed [{}]", se.getSession().getId());
    }
}
