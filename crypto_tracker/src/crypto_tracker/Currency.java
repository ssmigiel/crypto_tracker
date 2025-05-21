package crypto_tracker;

import java.util.List;

public class Currency {
	private List<Transaction> buyTransactions;
	private List<Transaction> sellTransactions;
	
	private String name;
	private float averageBuyPrice;
	private float averageSellPrice;
	private float amountOwned;
	private float investedUsdt;
	private float retrievedUsdt;
	private float profit;
	
	public Currency(String name) {
		super();
		this.name = name;
		this.averageBuyPrice = 0;
		this.averageSellPrice = 0;
		this.amountOwned = 0;
		this.investedUsdt = 0;
		this.retrievedUsdt = 0;
	}

// Getters and setters
	public List<Transaction> getBuyTransactions() {
		return buyTransactions;
	}
	
	public List<Transaction> getSellTransactions() {
		return sellTransactions;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public float getAverageBuyPrice() {
		return averageBuyPrice;
	}
	
	public float getAverageSellPrice() {
		return averageSellPrice;
	}
	
	public float getAmountOwned() {
		return amountOwned;
	}
	
	public float getInvestedUsdt() {
		return investedUsdt;
	}
	
	public float getRetrievedUsdt() {
		return retrievedUsdt;
	}
	
	public float getProfit() {
		return profit;
	}

// Methods
	public void recalculate() {
		this.calcAverageBuyPrice();
		this.calcProfit();
	}
	
	public void calcProfit() {
		this.profit = this.retrievedUsdt - this.investedUsdt;
	}
	
	public void calcAverageBuyPrice() {
		float value = 0;
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			value += this.buyTransactions.get(i).getPrice();
		}
		value /= this.buyTransactions.size();
		this.averageBuyPrice = value;
	}
	
}
