import java.util.ArrayList;

public class Player {
	
	public ArrayList<Integer> cardindexes = new ArrayList<Integer>();
	int[] indexes = new int[2];
	
	public Player(int firstcard, int secondcard) {
		cardindexes.add(firstcard);
		cardindexes.add(secondcard);
	}
	
	public ArrayList<Integer> getIndex() {
		return cardindexes;
	}
	
	public void addCard(int newcard) {
		cardindexes.add(newcard);
	}
}
