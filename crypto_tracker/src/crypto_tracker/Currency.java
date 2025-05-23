package crypto_tracker;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="CURRENCIES")
public class Currency {
	private MainSystem system;
	private List<Transaction> buyTransactions;
	private List<Transaction> sellTransactions;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	private float averageBuyPrice;
	private float averageSellPrice;
	private float amountOwned;
	private float investedUsdt;
	private float retrievedUsdt;
	private float profit;
	
	// Default empty constructor required by hibernate
	public Currency() {
		
	}
	
	public Currency(MainSystem system, String name) {
		super();
		this.system = system;
		this.name = name;
		this.averageBuyPrice = 0;
		this.averageSellPrice = 0;
		this.amountOwned = 0;
		this.investedUsdt = 0;
		this.retrievedUsdt = 0;
	}

// Getters and setters
	public MainSystem getSystem() {
		return system;
	}
	
	public List<Transaction> getBuyTransactions() {
		return buyTransactions;
	}
	
	public List<Transaction> getSellTransactions() {
		return sellTransactions;
	}
	
	public Long getId() {
		return id;
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
		this.calcInvestedUsdt();
		this.calcRetrievedUsdt();
		this.calcAmountOwned();
		this.calcAverageBuyPrice();
		this.calcAverageSellPrice();
		this.calcProfit();
	}
	
	public void calcProfit() {
		this.profit = this.retrievedUsdt - this.investedUsdt;
	}
	
	public void calcAverageBuyPrice() {
		float sum = 0;
		float weightsSum = 0;
		
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			Transaction transaction = this.buyTransactions.get(i);
			sum += transaction.getPrice() * transaction.getAmount();
			weightsSum += transaction.getAmount();
		}
		
		this.averageBuyPrice = sum / weightsSum;
	}

	public void calcAverageSellPrice() {
		float sum = 0;
		float weightsSum = 0;
		
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			Transaction transaction = this.sellTransactions.get(i);
			sum += transaction.getPrice() * transaction.getAmount();
			weightsSum += transaction.getAmount();
		}
		
		this.averageSellPrice = sum / weightsSum;
	}
	
	public void calcInvestedUsdt() {
		float value = 0;
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			value += this.buyTransactions.get(i).getUsdtAmount();
		}
		this.investedUsdt = value;
	}
	
	public void calcRetrievedUsdt() {
		float value = 0;
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			value += this.sellTransactions.get(i).getUsdtAmount();
		}
		this.retrievedUsdt = value;
	}
	
	public void calcAmountOwned() {
		float value = 0;
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			value += this.buyTransactions.get(i).getAmount();
		}
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			value += this.sellTransactions.get(i).getAmount();
		}
		
		this.amountOwned = value;
	}
	
// Static methods
	public static Currency Create(MainSystem system, String name) {
		Currency currency = new Currency(system, name);
		return currency;
	}
	
}
