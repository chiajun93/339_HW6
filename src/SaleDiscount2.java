/**
 * Created by chiajun on 4/22/16.
 */
public class SaleDiscount2 extends TransactionStrategy{
    @Override
    public double calculateSaleCost(AbstractTransaction trans) {
        return super.calculateSaleCost(trans) * 0.5;
    }
}
