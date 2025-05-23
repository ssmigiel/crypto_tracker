package crypto_tracker;

import javax.swing.JOptionPane;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

public class DatabaseHandler {
	private MainSystem system;
	private SessionFactory sessionFactory;
	private boolean isConnected;
	
	public DatabaseHandler(MainSystem system) {
		this.system = system;
		isConnected = false;
		
		initializeConnection();
	}
	
// Getters and Setters	
	public MainSystem getSystem() {
		return system;
	}

	public boolean getIsConnected() {
		return isConnected;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

// Methods	
	private void initializeConnection() {
    	try {
    		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			  .configure() // configures settings from hibernate.cfg.xml
    			  .build();
    		System.out.println("TEST");
    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    		System.out.println("TEST2");
    		isConnected = true;
    	}
    	catch(Exception e) {
//    		StandardServiceRegistryBuilder.destroy( registry );
    		
    		JOptionPane.showMessageDialog(null, "Database connection could not be established \n"
					+ "Application is working with local data", "Error", JOptionPane.INFORMATION_MESSAGE);
    	}
    }

    

    protected void tearDown() throws Exception {
	   if ( sessionFactory != null ) {
		  sessionFactory.close();
	   }
    }
}
