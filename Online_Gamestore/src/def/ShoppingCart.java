package def;
import java.util.*;

public class ShoppingCart {
	Stack<Game> st = new Stack<>();
	Library lib;
	Wishlist wish;
	public ShoppingCart(Library lib,Wishlist wish) {
		this.wish=wish;
		this.lib=lib;
	}
	
	//Push
	public void insert(String name, double price) {
		if(!isAdded(name)) {
			st.push(new Game(name,price));
			System.out.println(">\n"+name+" is successfully added to the cart.");
		}
		else
			System.out.println(">\n"+name+" is already in the cart.");
	}
	//Display 
	public int display() {
		Stack<Game> temp = new Stack<>();
		int position = 1;
		double price = 0;
		if(st.isEmpty()) {
			System.out.println("Shopping cart is currently empty.");
		}
		else {
			while(!st.isEmpty()) {
				st.peek().setCartPos(position);
				System.out.println((position++)+". "+st.peek().getName()+" -$"+st.peek().getPrice());
				price+=st.peek().getPrice();
				temp.push(st.pop());
			}
			System.out.println((position++)+". Proceed to Purchase (Total: $"+String.format("%.2f", price)+")");
			while(!temp.isEmpty()) {
				st.push(temp.pop());
			}
		}
		System.out.println(position+". Back");
		return position;
	}
	//Pop
	public void delete(String name) {
		Stack<Game> temp = new Stack<>();
		while(!st.isEmpty() && !st.peek().getName().equalsIgnoreCase(name)) {
			temp.push(st.pop());
		}
			st.pop();
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
		System.out.println(">\n"+name+" is successfully removed from the cart.");
	}
	//Checks to avoid duplicates
	public boolean isAdded(String name) {
		Stack<Game> temp = new Stack<>();
		boolean isAdded = false;
		while(!st.isEmpty() && !st.peek().getName().equalsIgnoreCase(name)) {
			temp.push(st.pop());
		}
			if(!st.isEmpty()){
				isAdded = true;
			}
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
		return isAdded;
	}
	//Completes the purchasement 
	public void purchase() {
		Game temp=null;
		double paid=0;
		//Skips process if cart is empty.
		if(st.isEmpty()) 
			return;
		//Continues to the process until cart is empty.
		while(!st.isEmpty()) {
			temp=st.pop();
			if(!lib.isPurchased(temp.getName())) {
				if(wish.isAdded(temp.getName())) {
					wish.drop(temp.getName());
				}
				lib.add(temp);
				paid+=temp.getPrice();
			}
			else {
				System.out.println(">\n"+temp.getName()+" is already in the library.");
			}
		}
		System.out.println(">\n $"+String.format("%.2f", paid)+" has been paid.");
	}
	
	//Searches for matching positions in the shopping cart
	public Game findByCartPos(int pos) {
		Stack<Game> temp = new Stack<>();
	    Game tmp = null;
	    
	    while (!st.isEmpty()) {
	        Game top = st.peek();
	        if (top.getCartPos() == pos) {
	            tmp = top; 
	            break;
	        } else {
	            temp.push(st.pop());
	        }
	    }

	    while (!temp.isEmpty()) {
	        st.push(temp.pop());
	    }
	    return tmp;
	}
}
