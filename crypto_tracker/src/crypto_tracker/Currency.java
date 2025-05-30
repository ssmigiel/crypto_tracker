package crypto_tracker;

import java.util.Comparator;
import java.util.Date;
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
	private boolean isSoftDeleted;
	private Kpi averageBuyPrice;
	private Kpi averageSellPrice;
	private Kpi amountOwned;
	private Kpi investedUsdt;
	private Kpi retrievedUsdt;
	private Kpi profit;
	
	// Default empty constructor required by hibernate
	public Currency() {
		
	}
	
	public Currency(MainSystem system, String name) {
		super();
		this.system = system;
		this.name = name;
		this.isSoftDeleted = false;
		this.averageBuyPrice = new Kpi(this, "averageBuyPrice", "Average Buy Price",  0);
		this.averageSellPrice = new Kpi(this, "averageSellPrice", "Average Sell Price",  0);
		this.amountOwned = new Kpi(this, "amountOwned", "Amount Owned", 0);
		this.investedUsdt = new Kpi(this, "investedUsdt","Invested Usdt", 0);
		this.retrievedUsdt = new Kpi(this, "retrievedUsdt", "Retrieved Usdt", 0);
		this.profit = new Kpi(this, "profit", "Profit", 0);
	}

// Getters and setters
	public MainSystem getSystem() {
		return system;
	}
	private void setSystem(MainSystem system) {
		this.system = system;
	}

	public boolean getIsSoftDeleted() {
		return isSoftDeleted;
	}
	private void setIsSoftDeleted(boolean isSoftDeleted) {
		this.isSoftDeleted = isSoftDeleted;
	}
	
	public List<Transaction> getBuyTransactions() {
		return buyTransactions;
	}
	private void setBuyTransactions(List<Transaction> buyTransactions) {
		this.buyTransactions = buyTransactions;
	}

	public List<Transaction> getSellTransactions() {
		return sellTransactions;
	}
	private void setSellTransactions(List<Transaction> sellTransactions) {
		this.sellTransactions = sellTransactions;
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
	
	public Kpi getAverageBuyPrice() {
		return averageBuyPrice;
	}
	
	public Kpi getAverageSellPrice() {
		return averageSellPrice;
	}
	
	public Kpi getAmountOwned() {
		return amountOwned;
	}
	
	public Kpi getInvestedUsdt() {
		return investedUsdt;
	}
	
	public Kpi getRetrievedUsdt() {
		return retrievedUsdt;
	}
	
	public Kpi getProfit() {
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
		this.profit.setValue(this.retrievedUsdt.getValue() - this.investedUsdt.getValue());
	}
	
	public void calcAverageBuyPrice() {
		float sum = 0;
		float weightsSum = 0;
		
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			Transaction transaction = this.buyTransactions.get(i);
			sum += transaction.getPrice() * transaction.getAmount();
			weightsSum += transaction.getAmount();
		}
		
		this.averageBuyPrice.setValue(sum / weightsSum);
	}

	public void calcAverageSellPrice() {
		float sum = 0;
		float weightsSum = 0;
		
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			Transaction transaction = this.sellTransactions.get(i);
			sum += transaction.getPrice() * transaction.getAmount();
			weightsSum += transaction.getAmount();
		}
		
		this.averageSellPrice.setValue(sum / weightsSum);
	}
	
	public void calcInvestedUsdt() {
		float value = 0;
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			value += this.buyTransactions.get(i).getUsdtAmount();
		}
		this.investedUsdt.setValue(value);
	}
	
	public void calcRetrievedUsdt() {
		float value = 0;
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			value += this.sellTransactions.get(i).getUsdtAmount();
		}
		this.retrievedUsdt.setValue(value);
	}
	
	public void calcAmountOwned() {
		float value = 0;
		for(int i = 0; i < this.buyTransactions.size(); i++) {
			value += this.buyTransactions.get(i).getAmount();
		}
		for(int i = 0; i < this.sellTransactions.size(); i++) {
			value += this.sellTransactions.get(i).getAmount();
		}
		
		this.amountOwned.setValue(value);
	}
	
	public Transaction addBuyTransaction(Date dateAdded, float amount, float price, float usdtAmount) {
		return Transaction.CreateBuyTransaction(this, dateAdded, amount, price, usdtAmount);
	}
	
	public Transaction addSellTransaction(Date dateAdded, float amount, float price, float usdtAmount) {
		return Transaction.CreateSellTransaction(this, dateAdded, amount, price, usdtAmount);
	}
	
	private void removeAllTransactions() {
		this.removeAllBuyTransactions();
		this.removeAllSellTransactions();
	}
	
	private void removeAllBuyTransactions() {
		if(this.buyTransactions != null) {
			for(int i = 0; i < this.buyTransactions.size();i++) {
				Transaction.Delete(this.buyTransactions.get(i));
			}
		}
	}
	
	private void removeAllSellTransactions() {
		if(this.sellTransactions != null){
			for(int i = 0; i < this.sellTransactions.size();i++) {
				Transaction.Delete(this.sellTransactions.get(i));
			}
		}
	}
	
// Static methods
	public static Currency Create(MainSystem system, String name) {
		Currency currency = new Currency(system, name);
		MainSystem sys = currency.getSystem();

		sys.getCurrencies().add(currency);
		sys.getCurrencies().sort(Comparator.comparing(Currency::getName));

		return currency;
	}
	
	public static void Delete(Currency currency) {
		currency.removeAllTransactions();
		
		MainSystem sys = currency.getSystem();
		sys.getCurrencies().remove(currency);
		currency.setSystem(null);
		currency.setIsSoftDeleted(true);
	}
	
	public static Currency getCurrencyByName(List<Currency> currencies, String name) {
		for(Currency c : currencies){
			if(c.getName().equals(name)) {
				return c;
			}
		}

		return null;
	}

}
