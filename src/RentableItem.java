public abstract class RentableItem extends Item {

	protected double rentalPrice;
	
	public RentableItem(int id, String title) {
		super(id, title);
	}
	
	public double getRentalPrice() {
		return rentalPrice;
	}
	
	public void setRentalPrice(double price) {
		rentalPrice = price;
	}
	
	public abstract double calculateRentalCost(int daysRented);

}
