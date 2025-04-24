package def;

public class Game {
	
	//Attributes
	private double price;
	private String name;
	private int libPos=0;
	private int wishPos=0;
	private int storePos=0;
	private int filteredStorePos=0;
	private int cartPos=0;
	
	//Tree Pointers
	Game left;
	Game right;
	
	//LinkedList Pointers
	Game prev;
	Game next;
	
	//Constructor
	public Game(String name,double price) {
		setPrice(price);
		setName(name);
		this.left = null;
		this.right = null;
		this.prev = null;
		this.next = null;
	}
	
	//Methods
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getLibPos() {
		return libPos;
	}

	public void setLibPos(int libPos) {
		this.libPos = libPos;
	}

	public int getWishPos() {
		return wishPos;
	}

	public void setWishPos(int wishPos) {
		this.wishPos = wishPos;
	}

	public int getStorePos() {
		return storePos;
	}

	public void setStorePos(int storePos) {
		this.storePos = storePos;
	}
	
	public int getFilteredStorePos() {
		return filteredStorePos;
	}

	public void setFilteredStorePos(int filteredStorePos) {
		this.filteredStorePos = filteredStorePos;
	}

	public int getCartPos() {
		return cartPos;
	}

	public void setCartPos(int cartPos) {
		this.cartPos = cartPos;
	}

	public String toString() {
		return getName() +" -$" +getPrice();  
	}
	
}
