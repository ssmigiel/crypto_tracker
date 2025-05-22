package crypto_tracker;

import java.util.List;

public class System {
    private MainWindow window;
    private List<Currency> currencies;

    public System() {
        this.window = new MainWindow(600, 500);
    }

    public List<Currency> getCurrencies() {
        return this.currencies;
    }
}
