package def;

public class Library {
	private Game head;
	
	//Inserts purchased items
	public void add(String name, double price) {
		add(new Game(name,price));
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
	
	//Refunds purchased items
	public void refund(String name) {
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
	    System.out.println(">\n"+name+" is successfully refunded.");
	}
	public boolean isPurchased(String name) {
		boolean cond = false;
		Game current = head;
		while(current!=null && !current.getName().equalsIgnoreCase(name)) {
			current=current.next;
		}
		if(current!=null)
			cond=true;
		return cond;
	}
	public int display() {
		int position = 1;
		if(head==null)
			System.out.println("Library is currently empty.");
		else {
			Game current = head;
			while(current!=null) {
				current.setLibPos(position);
				System.out.println((position++)+". "+current.getName());
				current=current.next;
			}
		}
		System.out.println(position+". Back");
		return position;
	}
	//Searches for matching positions in the library
	public Game findByLibPos(int pos) {
		Game current = head;
		while(current!=null && current.getLibPos()!=pos) {
			current=current.next;
		}
		return current;
	}
}
