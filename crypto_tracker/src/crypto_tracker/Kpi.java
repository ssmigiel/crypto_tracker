package crypto_tracker;

public class Kpi {
    private Currency currency;

    private String name;
    private float value;

    public Kpi(Currency currency, String name, float value) {
        this.currency = currency;
        this.name = name;
        this.value = value;
    }

// Getters and Setters
    public Currency getCurrency() {
		return currency;
	}
	private void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
