import java.util.ArrayList;

/**
 * Created by chiajun on 4/21/16.
 */
public class TypeStrategy extends RentalStrategy {

    @Override
    public int computeFrequentPt(AbstractTransaction trans) {
        return super.computeFrequentPt(trans) * 2;
    }
}
