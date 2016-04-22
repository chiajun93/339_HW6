/**
 * A class for all items available in the store
 * @author thanhng
 *
 */
public class Item {
	/* */
	protected String title;
	
	/* This can be different among products, e.g. ISBN of books.*/
	protected int id;
	
	/* Several common properties of items in the store can be declared here */
	
	public Item(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getID() {
		return id;
	}
	
}
