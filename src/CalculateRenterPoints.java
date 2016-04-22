import java.util.ArrayList;

public interface CalculateRenterPoints {
	
	public double bonusTransPoints(ArrayList<RentalTransaction> rt, int points);
	
	public boolean rewardEligible(ArrayList<RentalTransaction> rt, int age);
	
}