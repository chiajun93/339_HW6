/**
 * Although New Release is not really a category of movie (like Regular and Children,
 * but this creation facilitates calculations that are done for its own sake
 * @author thanhng
 *
 */
public class RentableNewReleaseMovie extends RentableMovie {

	private final double RENTAL_COST_MUL = 3;
	
	public RentableNewReleaseMovie(int id, String title) {
		super(id, title);
	}
	
	@Override
	public double calculateRentalCost(int daysRented) {
		return daysRented * RENTAL_COST_MUL;
	}

}
