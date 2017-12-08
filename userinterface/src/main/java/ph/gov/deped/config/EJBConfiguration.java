package ph.gov.deped.config;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ejb.stateless.interfaces.QueueServiceBeanRemote;

@Configuration
@Import({EJBProperties.class})
public class EJBConfiguration {

	public static final String INITIAL_CONTEXT="org.wildfly.naming.client.WildFlyInitialContextFactory";
	public static final String PROTOCOL="http+remote";
	public static final String MODULE_NAME="queuegtw_ejb-0.0.1-SNAPSHOT-jar-with-dependencies";
	public static final String IMPLEMENTING_CLASS="QueueServiceBean";
	
	@Autowired
	private EJBProperties ejbProp;
	
	@Bean
	public QueueServiceBeanRemote queueService() throws NamingException
	{
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL,"remote+http://"+ejbProp.getUrl());
        final Context context = new InitialContext(jndiProperties);
        QueueServiceBeanRemote sr= (QueueServiceBeanRemote) context.lookup(getEjbUrl());
        sr.queue(null);
        return sr;
	}
	
	private String getEjbUrl()
	{
		return String.format("ejb:/%s/%s!%s", MODULE_NAME,IMPLEMENTING_CLASS,QueueServiceBeanRemote.class.getName());
	}
	
}
