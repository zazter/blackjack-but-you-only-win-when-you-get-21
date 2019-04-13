
public class Card {
	
	private String name;
	private int value;
	private String picvalue;
	
	public Card(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public Card(String name, String picvalue) {
		this.name = name;
		this.picvalue = picvalue;
		switch (picvalue) {
		case "Ace":
			value = 11;
			break;
		case "Jack": case "Queen": case "King":
			value = 10;
		}
	}
	
	public void printcard() {
		if (picvalue != null) {
			System.out.printf("%s of %s \n", picvalue, name);
		} else {
			System.out.printf("%d of %s \n", value, name);
		}
		
	}
	
	public int getValue() {
		return value;
	}
}
