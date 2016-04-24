import java.util.Date;

public abstract class AbstractTransaction {

	protected int transactionID;
	
	protected Date transactionTime;
	
	protected double cost;
	
	public abstract double calculateCost(Customer customer);
	
	public abstract double bonusTransPoints();
	
	public abstract void setCost(double cost);
	
	public abstract double getCost();
}