import java.util.ArrayList;

/**
 * 
 * @author Chiajun Tai
 *
 */
public class Customer {
	/* This determines the unique customer */
	private int customerID;
	
	/* */
	private String name;
	
	
	/* Seperate rental and sale bonus points for possible feature later on */
	private int rentalBonusPoints = 0;
	
	private int saleBonusPoints = 0;
	
	/* Aggregate owed amount for rental*/
	private double rentalCost = 0;
	
	/* Aggregate owed amount for sale */
	private double saleCost = 0;
	
	private ArrayList<AbstractTransaction> transactions;
	
	
	public Customer(int id, String name) {
		this.customerID = id;
		this.name = name;
		transactions = new ArrayList<>();
	}
	
	/**
	 * Update transaction information each time s/he purchases/rents a product
	 * @param trans
	 */
	public void addTransaction(AbstractTransaction trans) {
		transactions.add(trans);
		double transCost = trans.calculateCost();
		if(trans instanceof RentalTransaction) {
			rentalCost = transCost;
			addPreferredCustomerPoints(trans);
		}
		else {
			saleCost = transCost;
			// bonus part for sale
		}
		// check and update points for frequent customer
	}
	
	/**
	 * Prepare for the rental statement
	 * @return
	 */
	public String getRentalStatement() {
		StringBuilder statement = new StringBuilder();
		statement.append("Customer: " + name + "\n" );
		
		/* Rental transaction summary */
		for(AbstractTransaction trans : transactions) {
			if(trans instanceof RentalTransaction)
				// summarize for rental items
				statement.append(((RentalTransaction) trans).getItemTitle() + "\t" + trans.calculateCost() + "\n");
			else
				// summarize for sale items
				statement.append(((SaleTransaction) trans).getItemTitle() + "\t" + trans.calculateCost() + "\n");
		}
		
		return statement.toString();
	}
	
	private void addPreferredCustomerPoints(AbstractTransaction trans) {
		//
		rentalBonusPoints ++;
		
		// Any bonus is also included
		rentalBonusPoints += trans.bonusTransPoints();
	}
	
	private void addBonusFrequentRenterPoints(ArrayList<RentalTransaction> rt) {
		CalculateRenterPoints pointsAge = new RenterPointsByAge();
		CalculateRenterPoints pointsCategory = new RenterPointsByCategory();
		CalculateRenterPoints pointsDuration = new RenterPointsByDuration();
		if(pointsAge.rewardEligible(rt, this.age)) {
			this.rentalBonusPoints = pointsAge.calculatePoints(rt, this.rentalBonusPoints);
		}
		if(pointsCategory.rewardEligible(rt, this.age)) {
			this.rentalBonusPoints = pointsCategory.calculatePoints(rt, this.rentalBonusPoints);
		}
		if(pointsDuration.rewardEligible(rt, this.age)) {
			this.rentalBonusPoints += pointsDuration.calculatePoints(rt, this.rentalBonusPoints);
		}
	}
	/**
	 * 
	 */
	private void addSaleBonusPoints() {
		
	}
}
