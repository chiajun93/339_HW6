/**
 * Created by chiajun on 4/22/16.
 */
public class TransactionStrategy {
    public double calculateSaleCost(AbstractTransaction trans){
        SaleTransaction sale = (SaleTransaction)trans;
        return sale.getNumItemsSold() * sale.getSaleItem().getSalePrice();
    }
}
