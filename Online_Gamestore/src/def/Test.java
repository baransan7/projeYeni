package def;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Store st = new Store();
		st.insert("Elden Ring", 39.99);
        st.insert("Cyberpunk 2077", 29.99);
        st.insert("Sekiro", 59.99);
        st.insert("CS2", 15.99);
        st.insert("Valheim", 9.99);
        st.insert("Lethal Company", 5.79);
        st.insert("Ark", 24.99);
		Library lib = new Library();
		Wishlist wish = new Wishlist(lib);
		ShoppingCart cart = new ShoppingCart(lib,wish);
		Menu menu = new Menu(sc,st,lib,wish,cart);
		menu.menuSelection(sc);
		sc.close();
	}
}
