package crypto_tracker;

import java.time.LocalDate;

public class DataEntry {
	private Currency currency;
	private LocalDate dateAdded;
	private float amount;
	private float price;
	private float usdtPaid;
	
	public DataEntry(Currency currency, LocalDate dateAdded, float amount, float price, float usdtPaid) {
		super();
		this.currency = currency;
		this.dateAdded = dateAdded;
		this.amount = amount;
		this.price = price;
		this.usdtPaid = usdtPaid;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public float getUsdtPaid() {
		return usdtPaid;
	}
	public void setUsdtPaid(float usdtPaid) {
		this.usdtPaid = usdtPaid;
	}
	
}
