package crypto_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainSystem {
	private static Connection con;
	
    private MainWindow window;
    private List<Currency> currencies;

    public MainSystem() {
    	initializeConnection();
    	
        initializeData();
        initializeWindow();
    }
// Getters and Setters
    public List<Currency> getCurrencies() {
        return this.currencies;
    }

// Methods
    private void initializeConnection() {
    	try {
    		Class.forName("org.sqlite.JDBC");
    		con = DriverManager.getConnection("jdbc:sqlite:CryptoTrasker.db");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    private void initializeData() {
        currencies = new ArrayList<>();
    // TODO implement DB connection to store and retrieve data
        currencies.add(new Currency(this, "TAO"));
        currencies.add(new Currency(this, "ONDO"));
        currencies.add(new Currency(this, "KAS"));
        
        // Sort currencies by name
        currencies.sort(Comparator.comparing(Currency::getName));
    }

    private void initializeWindow() {
        this.window = new MainWindow(this, 600, 500);
    }
}
