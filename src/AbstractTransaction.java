import java.util.Date;

/**
 * This class processes a transaction (sale/rental). For simplicity in the scope of this problem, each transaction is for
 * one sale/rental product.
 * @author thanhng
 *
 */
public abstract class AbstractTransaction {

	protected int transactionID;
	
	protected Date transactionTime;
	
	public abstract double calculateCost();
	
	public abstract double bonusTransPoints();
}
