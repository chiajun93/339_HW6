/**
 * Created by chiajun on 4/21/16.
 */
public class RentalStrategy {

    public int computeFrequentPt(AbstractTransaction trans){
        int rentalBonusPoints = 1;
        rentalBonusPoints += trans.bonusTransPoints();

        return rentalBonusPoints;
    }
}
