package crypto_tracker;

import java.util.List;

public class Currency {
	private List<DataEntry> dataEntries;
	
	private String name;
	private float averageBuyPrice;
	private float averageSellPrice;
	private float amountOwned;
	private float investedUsdt;
	private float retrievedUsdt;
	private float profit;
	
	public Currency(String name, float averageBuyPrice, float averageSellPrice, float amountOwned, 
					float investedUsdt, float retrievedUsdt, float profit) {
		super();
		this.name = name;
		this.averageBuyPrice = averageBuyPrice;
		this.averageSellPrice = averageSellPrice;
		this.amountOwned = amountOwned;
		this.investedUsdt = investedUsdt;
		this.retrievedUsdt = retrievedUsdt;
		this.profit = profit;
	}

	public List<DataEntry> getDataEntries() {
		return dataEntries;
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
	public void setAverageBuyPrice(float averageBuyPrice) {
		this.averageBuyPrice = averageBuyPrice;
	}
	
	public float getAverageSellPrice() {
		return averageSellPrice;
	}
	public void setAverageSellPrice(float averageSellPrice) {
		this.averageSellPrice = averageSellPrice;
	}
	
	public float getAmountOwned() {
		return amountOwned;
	}
	public void setAmountOwned(float amountOwned) {
		this.amountOwned = amountOwned;
	}
	
	public float getInvestedUsdt() {
		return investedUsdt;
	}
	public void setInvestedUsdt(float investedUsdt) {
		this.investedUsdt = investedUsdt;
	}
	
	public float getRetrievedUsdt() {
		return retrievedUsdt;
	}
	public void setRetrievedUsdt(float retrievedUsdt) {
		this.retrievedUsdt = retrievedUsdt;
	}
	
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	
}
