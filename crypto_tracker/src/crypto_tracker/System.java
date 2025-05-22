package crypto_tracker;

import java.util.ArrayList;
import java.util.List;

public class System {
    private MainWindow window;
    private List<Currency> currencies;

    public System() {
        initializeData();
        initializeWindow();
    }
// Getters and Setters
    public List<Currency> getCurrencies() {
        return this.currencies;
    }

// Methods    
    private void initializeData() {
        currencies = new ArrayList<>();
    // TODO implement DB connection to store and retrieve data
        currencies.add(new Currency(this, "TAO"));
        currencies.add(new Currency(this, "ONDO"));
        currencies.add(new Currency(this, "KAS"));
    }

    private void initializeWindow() {
        this.window = new MainWindow(this, 600, 500);
    }
}
