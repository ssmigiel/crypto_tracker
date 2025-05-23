package crypto_tracker;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DatabaseHandler {
	private MainSystem system;
	private static Connection con;
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

// Methods	
	private void initializeConnection() {
    	try {
    		Class.forName("org.sqlite.JDBC");
    		con = DriverManager.getConnection("jdbc:sqlite:CryptoTracker.db");
    		isConnected = true;
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "Database connection could not be established \n"
					+ "Application is working with local data", "Error", JOptionPane.INFORMATION_MESSAGE);
    	}
    }
}
