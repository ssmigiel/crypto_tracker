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

    public List<Currency> getCurrencies() {
        return this.currencies;
    }

    private void initializeData() {
        currencies = new ArrayList<>();
    // TODO implement DB connection to store and retrieve data
        currencies.add(new Currency("TAO"));
        currencies.add(new Currency("ONDO"));
        currencies.add(new Currency("KAS"));
    }

    private void initializeWindow() {
        this.window = new MainWindow(this, 600, 500);
    }
}
