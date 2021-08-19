package snake;
public class Item {
	private static final int ITEM_LOC = 25;
	private int x, y;
	public Item() {
		x = ITEM_LOC;
		y = ITEM_LOC;
	}
	public Item(int itemXIn, int itemYIn) {
		x = itemXIn;
		y = itemYIn;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setNewLocation(int itemXIn, int itemYIn) {
		x = itemXIn >= 0 ? itemXIn : x;
		y = itemYIn >= 0 ? itemYIn : y;
	}
	@Override
	public String toString() {
		return String.format("The item is located at position (%s, %s)", getX(), getY());
	}
}
