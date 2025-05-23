package crypto_tracker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainSystem {
    private MainWindow window;
    private DatabaseHandler dbHandler;
    private List<Currency> currencies;

    public MainSystem() {
        initializeData();
        initializeWindow();
        
//        dbHandler = new DatabaseHandler(this);
    }
// Getters and Setters
    public List<Currency> getCurrencies() {
        return this.currencies;
    }
    
    public DatabaseHandler getDbHandler() {
    	return this.dbHandler;
    }

// Methods
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
    
    public Currency addCurrency(String name) {
    	return Currency.Create(this, name);
    }
}
