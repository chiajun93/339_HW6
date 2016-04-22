/**
 * 
 * @author thanhng
 *
 */
public class RentableChildrenMovie extends RentableMovie {
	
	/* */
	private final int RENTAL_DURATION_LIMIT = 2;
	private final double RENTAL_BASE_COST = 2;
	private final double LATE_FEE = 1.5;
	
	/**
	 * 
	 */
	public RentableChildrenMovie(int id, String title) {
		super(id, title);
	}
	
	@Override
	public double calculateRentalCost(int daysRented) {
		double rentalCost = RENTAL_BASE_COST;
		
		// Additional fee calculation in case rental is expired
		if(daysRented > RENTAL_DURATION_LIMIT) {
			// do calculation here
		}
		return rentalCost;
	}

}
