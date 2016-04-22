public abstract class SellableItem extends Item {
	
	protected double salePrice;

	public SellableItem(int id, String title) {
		super(id, title);
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	/**
	 * Sale price sale can be determined when product data are entered
	 * @param price
	 */
	public void setSalePrice(double price) {
		salePrice = price;
	}
	
	public abstract double calculateSaleCost(int numbPurchased);

}
