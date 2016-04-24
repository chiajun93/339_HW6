/**
 * Class for a rental transaction, each rental transaction unit keeps track of one rental item
 * All transactions are buried in Customer class
 * @author Chiajun Tai
 *
 */
package hw6;

public class RentalTransaction extends AbstractTransaction {

	private final int RENTAL_BONUS_POINT = 1;
	private final int MIN_DURANTION_FOR_BONUS = 2;
	
	/* Instead of movie as in HW2, we have a RentableItem in each Rental */
	RentableItem rentalItem;
	
	// number of days the movie has been rented
	private int rentalDuration;
	private double cost;


	public RentalTransaction(RentableItem item, int duration) {
		this.rentalItem = item;
		this.rentalDuration = duration;
		this.cost = 0;
	}
	
	public RentableItem getRentableItem() {
		return rentalItem;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	
	public String getItemTitle() {
		return rentalItem.getTitle();
	}
	
	/**
	 * This calculates cost for this rental unit
	 * @return
	 */
	@Override
	public double calculateCost(Customer customer) {
		return rentalItem.calculateRentalCost(rentalDuration);
	}

	@Override
	public double bonusTransPoints() {
		int bonus = 0;
		if(rentalItem instanceof RentableNewReleaseMovie && rewardEgligble())
			bonus = RENTAL_BONUS_POINT;
		
		return bonus;
	}
	
	public boolean rewardEgligble() {
		return (rentalDuration >= MIN_DURANTION_FOR_BONUS);
	}
	
	public int getBonusRental() {
		return this.RENTAL_BONUS_POINT;
	}
	
	public int getMinDuration() {
		return this.MIN_DURANTION_FOR_BONUS;
	}

	@Override
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public double getCost(){
		return cost;
	}
	
}