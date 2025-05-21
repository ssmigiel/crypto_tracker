package crypto_tracker;

import java.util.Date;

public class DataEntry {
	private Currency currency;
	private Date dateAdded;
	private float amount;
	private float price;
	private float usdtPaid;
	
	public DataEntry(Currency currency, Date dateAdded, float amount, float price, float usdtPaid) {
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
	
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
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
