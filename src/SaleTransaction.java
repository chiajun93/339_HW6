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
	public double calculateCost() {
		return saleItem.calculateSaleCost(numberItemsSold);
	}

	@Override
	public double bonusTransPoints() {
		// TODO Do advanced for sale point here
		return 0;
	}

}
