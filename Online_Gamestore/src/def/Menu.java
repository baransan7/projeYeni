package def;
import java.util.Scanner;

public class Menu {
	Scanner sc;
	Store st;
	Library lib;
	Wishlist wish;
	ShoppingCart cart;
	
	public Menu(Scanner sc,Store st,Library lib,Wishlist wish,ShoppingCart cart) {
		this.sc=sc;
		this.st=st;
		this.lib=lib;
		this.wish=wish;
		this.cart=cart;
	}
	
	//MENU
	public String menuText() {
		return ">\n----------/ MENU \\----------\n1. View Market\n2. View Wishlist\n3. View Shopping Cart\n4. View Library\n5. Exit\nChoose an option: ";
	}
	public void menuSelection(Scanner sc) {
		int option = 0;
		System.out.println("---------------------------\nWelcome to the Online Gamestore!\n---------------------------");
		while(option!=5) {
			System.out.println(menuText());
			option =sc.nextInt();
			switch(option) {
			case 1:
				storeSelection(sc);
				break;
			case 2:
				wishlistSelection(sc);
				break;
			case 3:
				cartSelection(sc);
				break;
			case 4:
				librarySelection(sc);
				break;
			default:
				break;
			}
		}
	}
	//STORE
	public int storeText() {
		System.out.println(">\n----------/ STORE \\----------");
		return st.displayInOrder();
	}
	//STORE SELECTION
	public void storeSelection(Scanner sc) {
		int back,option=0;
		while(true) {
			back=storeText();
			option=sc.nextInt();
			if(option==back)
				return;
			else if(option==(back-1)) {
				storeFilterSelection(sc);
				return;
			}
			if(st.findByStorePos(option)==null)
				System.out.println("Invalid option.");
			else
				storeGameSelection(sc,st.findByStorePos(option));
		}
	}
	//STORE filtered display
	public int storeTextRange(int min,int max) {
		System.out.println(">\n----------/ STORE ("+min+"$ - "+max+"$) \\----------");
		return st.displayInRange(min,max);
	}
	public void storeFilterSelection(Scanner sc) {
		int back,option = 0;
		int filterOption=0;
		System.out.println(">\nFilter Options\n1. <10$\n2. 10$-20$\n3. 20$-35$\n4. 35$-50$\n5. >50$\n6. Back\nChoose an option:");
		filterOption=sc.nextInt();
		switch(filterOption) {
			case 1:
				while(true) {
					back=storeTextRange(0,10);
					option=sc.nextInt();
					if(option==back)
						break;
					if(st.findByFilteredStorePos(option)==null)
						System.out.println("Invalid option.");
					else
						storeGameSelection(sc,st.findByFilteredStorePos(option));
				}st.resetFilteredStorePositions();
				break;
			case 2:
				while(true) {
					back=storeTextRange(10,20);
					option=sc.nextInt();
					if(option==back)
						break;
					if(st.findByFilteredStorePos(option)==null)
						System.out.println("Invalid option.");
					else
						storeGameSelection(sc,st.findByFilteredStorePos(option));
				}st.resetFilteredStorePositions();
				break;
			case 3:
				while(true) {
					back=storeTextRange(20,35);
					option=sc.nextInt();
					if(option==back)
						break;
					if(st.findByFilteredStorePos(option)==null)
						System.out.println("Invalid option.");
					else
						storeGameSelection(sc,st.findByFilteredStorePos(option));
				}st.resetFilteredStorePositions();
				break;
			case 4:
				while(true) {
					back=storeTextRange(35,50);
					option=sc.nextInt();
					if(option==back)
						break;
					if(st.findByFilteredStorePos(option)==null)
						System.out.println("Invalid option.");
					else
						storeGameSelection(sc,st.findByFilteredStorePos(option));
				}st.resetFilteredStorePositions();
				break;
			case 5:
				while(true) {
					back=storeTextRange(50,100);
					option=sc.nextInt();
					if(option==back)
						break;
					if(st.findByFilteredStorePos(option)==null)
						System.out.println("Invalid option.");
					else
						storeGameSelection(sc,st.findByFilteredStorePos(option));
				}st.resetFilteredStorePositions();
				break;
			default:
				break;
				
		}
	}	
	//STORE GAME INFO
	public String storeGameInfo(Game game) {
		return ">\n------------------------------\n"+game.getName()+"            "+game.getPrice()+"$  \n\n 1. Add to Shopping Cart\n 2. Add to Wishlist\n 3. Back \n------------------------------\nChoose an option: ";
	}
	public void storeGameSelection(Scanner sc,Game game) {
		int option=0;
		System.out.println(storeGameInfo(game));
		option=sc.nextInt();
		switch(option) {
			case 1:
				cart.insert(game.getName(),game.getPrice());				
				break;
			case 2:
				wish.add(game.getName(),game.getPrice());
				break;
			default:
				break;
		}
		
	}
	
	//WISHLIST
	public int wishlistText() {
		System.out.println(">\n----------/ WISHLIST \\----------");
		return wish.display();
	}
	public void wishlistSelection(Scanner sc) {
		int back,option=0;
		while(true) {
			back=wishlistText();
			option=sc.nextInt();
			if(option==back)
				return;
			if(wish.findByWishPos(option)==null)
				System.out.println("Invalid option.");
			else
				wishlistGameSelection(sc,wish.findByWishPos(option));
		}
	}
	//WISHLIST GAME INFO
	public String wishlistGameInfo(Game game) {
		return ">\n------------------------------\n"+game.getName()+"            "+game.getPrice()+"$  \n\n 1. Add to Shopping Cart\n 2. Remove from Wishlist\n 3. Back \n------------------------------\nChoose an option: ";
	}
	public void wishlistGameSelection(Scanner sc,Game game) {
		int option=0;
		System.out.println(wishlistGameInfo(game));
		option=sc.nextInt();
		switch(option) {
			case 1:
				cart.insert(game.getName(),game.getPrice());				
				break;
			case 2:
				wish.drop(game.getName());
				break;
			default:
				break;
		}
	}
	//SHOPPING CART
	public int cartText() {
		System.out.println(">\n----------/ SHOPPING CART \\----------");
		return cart.display();
	}
	public void cartSelection(Scanner sc) {
		int back,option=0;
		while(true) {
			back=cartText();
			option=sc.nextInt();
			if(option==back)
				return;
			else if(option==(back-1)) {
				cart.purchase();
				return;
			}
			if(cart.findByCartPos(option)==null)
				System.out.println("Invalid option.");
			else
				cartGameSelection(sc,cart.findByCartPos(option));
		}
	}
	//SHOPPING CART GAME INFO
	public String cartGameInfo(Game game) {
		return ">\n------------------------------\n"+game.getName()+"            "+game.getPrice()+"$  \n\n 1. Remove from Shopping Cart\n 2.Back \n------------------------------\nChoose an option: ";
	}
	public void cartGameSelection(Scanner sc,Game game) {
		int option=0;
		System.out.println(cartGameInfo(game));
		option=sc.nextInt();
		switch(option) {
			case 1:
				cart.delete(game.getName());
				break;
			default:
				break;
		}
	}
	//LIBRARY
	public int libraryText() {
		System.out.println(">\n----------/ LIBRARY \\----------");
		return lib.display();
	}
	public void librarySelection(Scanner sc) {
		int back,option=0;
		while(true) {
			back=libraryText();
			option=sc.nextInt();
			if(option==back)
				return;
			if(lib.findByLibPos(option)==null)
				System.out.println("Invalid option.");
			else
				libraryGameSelection(sc,lib.findByLibPos(option));
		}
	}
	//LIBRARY GAME INFO
	public String libraryGameInfo(Game game) {
		return ">\n------------------------------\n"+game.getName()+"\n\n 1. Refund the game\n 2. Back \n------------------------------\nChoose an option: ";
	}
	public void libraryGameSelection(Scanner sc,Game game) {
		int option=0;
		System.out.println(libraryGameInfo(game));
		option=sc.nextInt();
		switch(option) {
			case 1:
				lib.refund(game.getName());
				break;
			default:
				break;
		}
	}
}
