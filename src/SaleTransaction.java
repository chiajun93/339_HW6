public class SaleTransaction extends AbstractTransaction {
	
	/* Define final static variable specialized for sale here */
	
	private SellableItem saleItem;
	
	/* Number of sold items of this kind */
	private int numberItemsSold;

	public SaleTransaction(SellableItem item, int numPurchased) {
		this.saleItem = item;
		this.numberItemsSold = numPurchased;
	}
	
	public String getItemTitle() {
		return saleItem.getTitle();
	}
	
	@Override
	/**
	 * @param numberItemsSold
	 * In case, sale price changes in number of purchased items, you may 
	 * move numberItemSold to subclasses of SellableItem
	 */
	public double calculateCost(Customer customer) {
		int rentalItems = customer.getNumRentalItems();
        if(rentalItems >= 3 && rentalItems <= 5)
            return new SaleDiscount1().calculateSaleCost(this);
		else if(rentalItems > 5)
			return new SaleDiscount2().calculateSaleCost(this);
        else
		    return new TransactionStrategy().calculateSaleCost(this);
	}

	@Override
	public double bonusTransPoints() {
		// TODO Do advanced for sale point here
		return 0;
	}

	public int getNumItemsSold(){
		return numberItemsSold;
	}

	public SellableItem getSaleItem(){
		return saleItem;
	}

}
