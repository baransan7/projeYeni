package def;
//import java.util.*;

public class Dummy {

	public static void main(String[] args) {
		Store st = new Store();
        st.insert("Elden Ring", 39.99);
        st.insert("Cyberpunk 2077", 29.99);
        st.insert("Sekiro", 59.99);
        st.insert("CS2", 15.99);
        st.insert("Valheim", 9.99);
        st.insert("Ark", 24.99);
        System.out.println(st.displayInOrder());
        //System.out.println(st.displayInRange(0, 25));
		/*Wishlist wish = new Wishlist();
		Library lib = new Library();
		ShoppingCart cart = new ShoppingCart(lib,wish);	
		//cart.insert("Elden Ring", 39.99,1);
		System.out.println("sepet");
		cart.insert("Elden Ring", 39.99);
		cart.insert("Cyberpunk 2077", 29.99);
		cart.insert("Sekiro", 59.99);
        cart.insert("CS2", 15.99);
        cart.insert("Valheim", 9.99);
        cart.insert("Ark", 24.99);
        cart.display();
        /*cart.delete("Sekiro");
        cart.display();
        wish.add("Elden Ring", 39.99);
        wish.add("Cyberpunk 2077", 29.99);
        wish.add("Mass Effect 3", 19.99);
        wish.add("Astroneer", 17.99);
        System.out.println("istek listesi");
        wish.display();
        //Game g = new Game("Elden Ring", 39.99,1);
        //lib.add(g);
        System.out.println("kütüphane");
        lib.display();
        cart.purchase();
        //wish.drop("Elden Ring");
        //System.out.println(wish.isAdded("Ark"));
        System.out.println("istek listesi");
        wish.display();
        //lib.display();
        /*lib.refund(g.getName());
        lib.display();
        wish.drop(g.getName());
        wish.display();
        System.out.println("sepet");
        cart.display(); 
        System.out.println("kütüphane");
        lib.display();
        //System.out.println(lib.isPurchased("Elden Ring"));*/
        
	}

}
