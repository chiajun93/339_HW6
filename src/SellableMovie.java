public class SellableMovie extends SellableItem {

	/* Final members for sale price code */
	public SellableMovie(int id, String title) {
		super(id, title);
	}

	@Override
	public double calculateSaleCost(int numbPurchased) {
		return numbPurchased * salePrice;
	}
}
