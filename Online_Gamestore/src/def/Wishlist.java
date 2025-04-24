package def;

public class Wishlist {
	private Game head;
	Library lib;
	
	public Wishlist(Library lib) {
		this.lib=lib;
	}
	//Inserts items 
	public void add(String name, double price) {
		if(!lib.isPurchased(name)) {
			if(!isAdded(name)) {
				System.out.println(">\n"+name+" is successfully added to the wishlist.");
				add(new Game(name,price));
			}
			else
				System.out.println(">\n"+name+" is already in the wishlist.");
		}
		else
			System.out.println(">\n"+name+" is already purchased.");
	}
	public void add(Game game) {
		if(head==null) {
			head=game;
		}
		else {
			Game current = head;
			while(current.next!=null){
				current=current.next;
			}
			current.next = game;
			game.prev=current;
		}
	}
	//Deletes items
	public void drop(String name) {
	    Game current = head;

	    while (current != null && !current.getName().equalsIgnoreCase(name)) {
	        current = current.next;
	    }

	    if (current == head) {
	        head = current.next;
	        if (head != null) {
	            head.prev = null;
	        }
	    } else {
	        current.prev.next = current.next;
	        if (current.next != null) {
	            current.next.prev = current.prev;
	        }
	    }
	    System.out.println(">\n"+name+" is successfully removed from the wishlist.");
	}
	public boolean isAdded(String name) {
		boolean isAdded = false;
		Game current = head;
	    
		while (current != null && !current.getName().equalsIgnoreCase(name)) {
	        current = current.next;
	    }
		if(current!=null) {
			isAdded = true;
		}
		return isAdded;
	}
	public int display() {
		int position = 1;
		if(head==null)
			System.out.println("Wishlist is currently empty.");
		else {
			Game current = head;
			while(current!=null) {
				current.setWishPos(position);
				System.out.println((position++)+". "+current.getName()+" -$"+current.getPrice());
				current=current.next;
			}
		}
		System.out.println(position+". Back");
		return position;
	}
	//Searches for matching positions in the wishlist
	public Game findByWishPos(int pos) {
		Game current = head;
		while(current!=null && current.getWishPos()!=pos) {
			current=current.next;		
		}
		return current;
	}
}
