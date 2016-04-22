/**
 * Created by chiajun on 4/22/16.
 */
public class AgeStrategy extends RentalStrategy {
    @Override
    public int computeFrequentPt(AbstractTransaction trans) {
        return super.computeFrequentPt(trans) * 2;
    }
}
