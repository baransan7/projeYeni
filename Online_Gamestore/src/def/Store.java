package def;

public class Store {
	private Game root;
	
	//Game insertion 
	public void insert(String title, double price) {
        root = insertRec(root, new Game(title, price));
    }

    private Game insertRec(Game current, Game newGame) {
        if (current == null) return newGame;

        if (newGame.getName().compareToIgnoreCase(current.getName()) < 0)
            current.left = insertRec(current.left, newGame);
        else if (newGame.getName().compareToIgnoreCase(current.getName()) > 0)
            current.right = insertRec(current.right, newGame);

        return current;
    }
    //Game Display NORMAL
    public int displayInOrder() {
    	int[] position = {1};
    	displayInOrderRec(root, position);
    	System.out.println(position[0]+". Filter Price");
    	position[0]++;
    	System.out.println(position[0]+". Back");
    	return position[0];
    }

    private void displayInOrderRec(Game current, int[] position) {
    	if (current != null) {
            displayInOrderRec(current.left,position);
            System.out.println(position[0]+ ". " +current.toString());
            current.setStorePos(position[0]);
            position[0]++;
            displayInOrderRec(current.right,position);
        }
    }
    //Game Display FILTERED
    public int displayInRange(double minPrice, double maxPrice) {
        int[] position = {1};
        displayInRangeRec(root, minPrice, maxPrice, position);
        System.out.println(position[0]+". Back");
    	return position[0];
    }

    private void displayInRangeRec(Game current, double min, double max, int[] position) {
        if (current == null) return;

        displayInRangeRec(current.left, min, max, position);

        if (current.getPrice() >= min && current.getPrice() <= max) {
            System.out.println(position[0] + ". " + current.toString());
            current.setFilteredStorePos(position[0]);
            position[0]++;
        }

        displayInRangeRec(current.right, min, max, position);
    }
    
    //Searches for matching positions in the store--NORMAL
    public Game findByStorePos(int pos) {
        return findByStorePos(root, pos);
    }

    private Game findByStorePos(Game node, int pos) {
        if (node == null) return null;

        Game result = findByStorePos(node.left, pos);
        if (result != null) return result;

        if (node.getStorePos() == pos) {
            return node;
        }

        return findByStorePos(node.right, pos);
    }
    //Searches for matching positions in the store--FILTERED
    public Game findByFilteredStorePos(int pos) {
        return findByFilteredStorePos(root, pos);
    }

    private Game findByFilteredStorePos(Game node, int pos) {
        if (node == null) return null;

        Game result = findByFilteredStorePos(node.left, pos);
        if (result != null) return result;

        if (node.getFilteredStorePos() == pos) {
            return node;
        }

        return findByFilteredStorePos(node.right, pos);
    }
    //Resets positions for recursive filtering
    public void resetFilteredStorePositions() {
        resetFilteredStorePositionsRec(root);
    }

    private void resetFilteredStorePositionsRec(Game node) {
        if (node == null) return;
        node.setFilteredStorePos(-1);
        
        resetFilteredStorePositionsRec(node.left);
        
        resetFilteredStorePositionsRec(node.right);
    }
}
