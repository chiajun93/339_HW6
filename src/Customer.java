import java.util.ArrayList;

/**
 * 
 * @author Chiajun Tai
 *
 */
public class Customer {
	private int customerID;
	private String name;
	private int age;
	private int rentalBonusPoints = 0;
	private int saleBonusPoints = 0;
	
	/* Aggregate owed amount for rental*/
	private double rentalCost = 0;
	
	/* Aggregate owed amount for sale */
	private double saleCost = 0;
	
	private ArrayList<AbstractTransaction> transactions;
	
	public Customer(int id, String name, int age) {
		this.customerID = id;
		this.name = name;
		this.age = age;
		transactions = new ArrayList<>();
	}

	public int getAge(){
		return age;
	}

	public ArrayList<AbstractTransaction> getTransactions(){
		return transactions;
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

        statement.append("\nTotal frequent rental points:\t" + rentalBonusPoints + "\n");
		return statement.toString();
	}

	public int getRentalBonusPoints(){
		return rentalBonusPoints;
	}

    public int totalMovieTypes(){
        ArrayList<String> types = new ArrayList<>();

        for(int i = 0; i < transactions.size(); i++){
            RentalTransaction trans = (RentalTransaction)transactions.get(i);
            if(!types.contains(trans.getRentableItem().getClass().toString())){
                types.add(trans.getRentableItem().getClass().toString());
            }
        }

        return types.size();
    }

    public boolean containsNewMovie(){
        for(AbstractTransaction trans: transactions){
            if(trans instanceof RentalTransaction){
                if(((RentalTransaction) trans).getRentableItem() instanceof RentableNewReleaseMovie)
                    return true;
            }
        }

        return false;
    }
	
	private void addPreferredCustomerPoints(AbstractTransaction trans) {
        if(totalMovieTypes() > 2)
            rentalBonusPoints += new TypeStrategy().computeFrequentPt(trans);
        else if(age >= 18 && age <= 22 && containsNewMovie())
            rentalBonusPoints += new AgeStrategy().computeFrequentPt(trans);
        else
		    rentalBonusPoints += new RentalStrategy().computeFrequentPt(trans);
	}

	private void addSaleBonusPoints() {
		
	}
}
