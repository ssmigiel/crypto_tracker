package crypto_tracker;

import java.util.Date;

public class Transaction {
	private Currency currency;
	private boolean isBuyTransaction;
	private boolean isSellTransaction;
	private Date dateAdded;
	private float amount;
	private float price;
	private float usdtAmount;	
	
	public Transaction(Currency currency, boolean isBuyTransaction, boolean isSellTransaction, Date dateAdded,
					   float amount, float price, float usdtAmount) {
		super();
		this.currency = currency;
		this.isBuyTransaction = isBuyTransaction;
		this.isSellTransaction = isSellTransaction;
		this.dateAdded = dateAdded;
		this.amount = amount;
		this.price = price;
		this.usdtAmount = usdtAmount;
	}

// Getters and Setters
	public Currency getCurrency() {
		return currency;
	}
	private void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public boolean getIsBuyTransaction() {
		return isBuyTransaction;
	}
	public void setIsBuyTransaction(boolean isBuyTransaction) {
		this.isBuyTransaction = isBuyTransaction;
	}

	public boolean getIsSellTransaction() {
		return isSellTransaction;
	}
	public void setIsSellTransaction(boolean isSellTransaction) {
		this.isSellTransaction = isSellTransaction;
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
	
	public float getUsdtAmount() {
		return usdtAmount;
	}
	public void setUsdtAmount(float usdtAmount) {
		this.usdtAmount = usdtAmount;
	}

// Static methods
	public static Transaction CreateBuyTransaction(Currency currency, Date dateAdded, float amount, float price, float usdtAmount) {
		Transaction transaction = new Transaction(currency, true, false, dateAdded, amount, price, usdtAmount);
		
		return transaction;
	}
	
	public static Transaction CreateSellTransaction(Currency currency, Date dateAdded, float amount, float price, float usdtAmount) {
		Transaction transaction = new Transaction(currency, false, true, dateAdded, amount, price, usdtAmount);
		
		return transaction;
	}
	
	public static void Delete(Transaction transaction) {
		if(transaction.getIsBuyTransaction()) {
			transaction.getCurrency().getBuyTransactions().remove(transaction);
		}
		else {
			transaction.getCurrency().getSellTransactions().remove(transaction);
		}
		
		transaction.setCurrency(null);
	}
	
}
