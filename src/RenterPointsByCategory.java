import java.util.ArrayList;
import java.util.HashSet;

public class RenterPointsByCategory implements CalculateRenterPoints {

	@Override
	public int bonusTransPoints(ArrayList<RentalTransaction> rt, int bonus) {
		int bonus *= 2;
		return bonus;
	}

	@Override
	public boolean rewardEligible(ArrayList<RentalTransaction> rt, int age) {
		HashSet<String> categories = new HashSet<String>();
		for(RentalTransaction rental : rt) {
        	categories.add(rental.getRentableItem.getClass().toString());
        }
		if(categories.size() > 2) return true;
		return false;
	}

}