import java.util.ArrayList;

public class RenterPointsByAge implements CalculateRenterPoints {

	
	@Override
	public int bonusTransPoints(ArrayList<RentalTransaction> rt, int bonus) {
		int bonus *= 2;
		return bonus;
	}

	@Override
	public boolean rewardEligible(ArrayList<RentalTransaction> rt, int age) {
		if(age > 17 && age < 23) {
			for(RentalTransaction rental : rt){
				if(rental.getRentableItem() instanceof RentableNewReleaseMovie)
				return true;
			}
		}
		return false;
	}

}