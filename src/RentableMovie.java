public class RentableMovie extends RentableItem {

	public RentableMovie(int id, String title) {
		super(id, title);
	}

	@Override
	public double calculateRentalCost(int daysRented) {
		return 0;
	}

}
