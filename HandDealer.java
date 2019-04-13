import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class HandDealer {
	
	
	static ArrayList<Integer> numbers = new ArrayList<Integer>();
	static Card[] deck = new Card[52];
	static int cardsDealt = 0;
	
	public static void main(String[] args) {
		
		makeDeck();
		shuffleDeck();
		Player player = new Player(numbers.get(0), numbers.get(1));
		System.out.println("You are dealt the cards: ");
		dealCards();
		
		while (getSum(player.getIndex()) < 22) {
			if (getSum(player.getIndex()) == 21) {
				System.out.println("Epic victory royale!");
				System.exit(0);
			}
			String miss = whatNext();
			if(miss.equals("stand"))
				break;
			if(miss.equals("hit")) {
				player.addCard(numbers.get(cardsDealt));
				deck[numbers.get(cardsDealt)].printcard();
				cardsDealt++;
			}

		}
		System.out.println("The sum is: " + getSum(player.getIndex()));
			
	}
	
	
	public static void makeDeck() {

		String[] suits = new String[] {"Spades", "Clubs", "Hearts", "Diamonds"};
		String[] piccards = new String[] {"Ace", "Jack", "Queen", "King"};
		int[] cards = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int counter = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 9; j++) {
				deck[counter] = new Card(suits[i], cards[j]);
				counter++;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				deck[counter] = new Card(suits[i], piccards[j]);
				counter++;
			}
		}
	}
	
	public static void shuffleDeck() {
		
		Random random = new Random();
		
		while (numbers.size() < 52) {
		    int randoms = random.nextInt(52);
		    if (!numbers.contains(randoms)) {
		        numbers.add(randoms);
		    }
		}
	}
	
	public static void dealCards() {
		for (int i = 0; i < 2; i++) {
			int index = numbers.get(i);
			deck[index].printcard();
			cardsDealt++;
		}
	}
	
	public static int getSum(ArrayList<Integer> indexes) {
	    int sum = 0;
	    for(int i = 0; i < indexes.size(); i++)
	    {
	        sum += deck[indexes.get(i)].getValue();
	    }
		return sum;
	}
	
	public static String whatNext() {
		String nextMove;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hit or Stand?");
		
		nextMove = input.next();
		nextMove = nextMove.toLowerCase();
		return nextMove;
	}
}
