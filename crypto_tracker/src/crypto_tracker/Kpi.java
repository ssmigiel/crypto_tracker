package crypto_tracker;

public class Kpi {
    private Currency currency;

    private String name;
    private String displayName;
    private float value;

    public Kpi(Currency currency, String name, String displayName, float value) {
        this.currency = currency;
        this.name = name;
        this.displayName = displayName;
        this.value = value;
    }

// Getters and Setters
    public Currency getCurrency() {
		return currency;
	}
	private void setCurrency(Currency currency) {
		this.currency = currency;
	}

    public String getName() {
		return name;
	}

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
	
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
