package ph.gov.deped.config;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ejb.stateless.interfaces.QueueServiceBeanRemote;
import com.file.ejb.remote.interfaces.FileServiceRemote;

@Configuration
@Import({EJBProperties.class})
public class EJBConfiguration {

	public static final String INITIAL_CONTEXT="org.wildfly.naming.client.WildFlyInitialContextFactory";
	public static final String PROTOCOL="http-remoting://";
	public static final Logger log=LogManager.getLogger(EJBConfiguration.class);
	
	
	@Autowired
	private EJBProperties ejbProp;
	
	@Bean
	public QueueServiceBeanRemote queueService() throws NamingException
	{
		log.info("EJB Queue Service Url:"+ejbProp.getQueueServiceUrl());
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	    properties.put( Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
	    properties.put(Context.PROVIDER_URL,PROTOCOL+ejbProp.getQueueServiceUrl());
        final Context context = new InitialContext(properties);
        QueueServiceBeanRemote sr= (QueueServiceBeanRemote) context.lookup(getEjbUrl("queuegtw_queuelistener-0.0.1-SNAPSHOT","QueueServiceBean",QueueServiceBeanRemote.class.getName()));
        return sr;
	}
	
//	public static void main(String[] args) throws NamingException {
////		log.info("EJB Queue Service Url:"+ejbProp.getQueueServiceUrl());
//		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
//        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT);
//        jndiProperties.put(Context.PROVIDER_URL,"http-remoting://"+"10.10.2.69:8080");
//        jndiProperties.put("jboss.naming.client.ejb.context", "true");
//        jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejbuser");
//        jndiProperties.put(Context.SECURITY_CREDENTIALS, "3jbU$3r");
//        final Context context = new InitialContext(jndiProperties);
////        
//        NamingEnumeration<NameClassPair> list = context.list("");
//        while (list.hasMore()) {
//          System.out.println(list.next().getName());
//        }
//        
//        FileServiceRemote sr= (FileServiceRemote) context.lookup(getEjbUrl("file_listener-0.0.1-SNAPSHOT","FileServiceImpl",FileServiceRemote.class.getName()));
//        sr.getFileName("");
//	}
	
//	public static void main(String[] args) throws NamingException {
//		
//		Properties properties = new Properties();
//		 properties.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT);
//	     properties.put( Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
//	     properties.put( "org.jboss.ejb.client.scoped.context", "true" );
//	     properties.put( "remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false" );
//	     properties.put( "remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false" );
//	     properties.put( "remote.connections", "default" );
//
//	     properties.put( "remote.connection.default.host", "10.10.2.69" );
//	     properties.put( "remote.connection.default.port", String.valueOf( 8080) );
//	     properties.put( "remote.connection.default.username", "ejbuser" );
//	     properties.put( "remote.connection.default.password", "3jbU$3r" );
//	     final Context context = new InitialContext(properties);
//	     NamingEnumeration<NameClassPair> list = context.list("");
//	        while (list.hasMore()) {
//	          System.out.println(list.next().getName());
//	        }
//	}
	
	@Bean
	public FileServiceRemote fileService() throws NamingException
	{
		log.info("EJB File Service Url:"+ejbProp.getFileServiceUrl());
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	    properties.put( Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
	    properties.put(Context.PROVIDER_URL,PROTOCOL+ejbProp.getFileServiceUrl());
        final Context context = new InitialContext(properties);
        FileServiceRemote sr= (FileServiceRemote) context.lookup(getEjbUrl("file_listener-0.0.1-SNAPSHOT","FileServiceImpl",FileServiceRemote.class.getName()));
        return sr;
	}
	
	private static String getEjbUrl(String moduleName,String implementingClass,String className)
	{
		return String.format("ejb:/%s/%s!%s", moduleName,implementingClass,className);
	}
	
}
