import java.util.ArrayList;

/**
 * 
 * @author thanhng
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
		
		/* Rental transaction summary */
		for(AbstractTransaction trans : transactions) {
			if(trans instanceof RentalTransaction)
				// summarize for rental items
				statement.append(((RentalTransaction) trans).getItemTitle() + "\t" + trans.calculateCost());
			else
				// summarize for sale items
				statement.append(((SaleTransaction) trans).getItemTitle() + "\t" + trans.calculateCost());
		}
		
		return statement.toString();
	}
	
	private void addPreferredCustomerPoints(AbstractTransaction trans) {
		//
		rentalBonusPoints ++;
		
		// Any bonus is also included
		rentalBonusPoints += trans.bonusTransPoints();
	}
	
	/**
	 * 
	 */
	private void addSaleBonusPoints() {
		
	}
}
