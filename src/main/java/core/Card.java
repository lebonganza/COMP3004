package core;

public class Card {
	
	private int value;
	private Suit suit;
	
	//Constructor
	public Card(Suit sIn, int valIn) {
		this.value = valIn;
		this.suit = sIn;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public String toString() {
		
		String valueStr ="NULL";
		
		switch(this.value) {
			case 2:
				valueStr = "2";
				break;
			case 3:
				valueStr = "3";
				break;
			case 4:
				valueStr = "4";
				break;
			case 5:
				valueStr = "5";
				break;
			case 6:
				valueStr = "6";
				break;
			case 7:
				valueStr = "7";
				break;
			case 8:
				valueStr = "8";
				break;
			case 9:
				valueStr = "9";
				break;
			case 10:
				valueStr = "10";
				break;
			case 11:
				valueStr = "J";
				break;
			case 12:
				valueStr = "Q";
				break;
			case 13:
				valueStr = "K";
				break;
			case 1:
				valueStr = "A";
				break;			
		}
		return suit.toString() + valueStr;
	}
}
