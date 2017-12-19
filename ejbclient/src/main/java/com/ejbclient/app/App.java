package com.ejbclient.app;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejb.stateless.interfaces.QueueServiceBeanRemote;


public class App implements CommandLineRunner{
	
	public static void main(String[] args) {
		 SpringApplication app = new SpringApplication(App.class);
	      
	        app.run(args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Properties properties = new Properties();
		 properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	     properties.put( Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming" );
	    
	     final Context context = new InitialContext(properties);
	     
	     System.out.println("==========EXEC============");
	     
	     NamingEnumeration<NameClassPair> list = context.list("");
	        while (list.hasMore()) {
	          System.out.println(list.next().getName());
	        }
	  
        QueueServiceBeanRemote sr= (QueueServiceBeanRemote) context.lookup(getEjbUrl("queuegtw_queuelistener-0.0.1-SNAPSHOT","QueueServiceBean",QueueServiceBeanRemote.class.getName()));   
	    sr.queue(null);    
	}
	
//	@Override
//	public void run(String... arg0) throws Exception {
//		
//		Properties clientProperties = new Properties();
//	    clientProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
//	    clientProperties.put("remote.connections", "default");
//	    clientProperties.put("remote.connection.default.port", "8080");
//	    clientProperties.put("remote.connection.default.host", "10.10.2.69");
//	    clientProperties.put("remote.connection.default.username", "ejbuser");
//	    clientProperties.put("remote.connection.default.password", "3jbU$3r");
//	    clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");
//
//	    EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(clientProperties);
//	    ContextSelector<EJBClientContext> contextSelector = new ConfigBasedEJBClientContextSelector(ejbClientConfiguration);
//	    EJBClientContext.setSelector(contextSelector);
//
//	    Properties properties = new Properties();
//	    properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//	    Context context = new InitialContext(properties);
//	    QueueServiceBeanRemote qs= (QueueServiceBeanRemote) context.lookup(getEjbUrl("queuegtw_queuelistener-0.0.1-SNAPSHOT","QueueServiceBean",QueueServiceBeanRemote.class.getName()));  
//	    qs.queue(null);
//	}
	
	private static String getEjbUrl(String moduleName,String implementingClass,String className)
	{
		return String.format("ejb:/%s/%s!%s", moduleName,implementingClass,className);
	}
	
}
