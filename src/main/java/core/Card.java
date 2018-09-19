package core;

public class Card {
	
	private int value;
	private Suit suit;
	
	//Constructor 1
	public Card(Suit sIn, int valIn) {
		
		this.suit = sIn;
		if(valIn>=1 && valIn<=13) {
			this.value = valIn;
		}
		else {
			System.err.println(value+ " is not a valid card value");
			System.exit(1);
		}
	}
	
	public Card(Suit aSuit,String value){
			
			int val=0;
			switch(value) {
				case "2":
					val = 2;
					break;
				case "3":
					val = 3;
					break;
				case "4":
					val = 4;
					break;
				case "5":
					val = 5;
					break;
				case "6":
					val = 6;
					break;
				case "7":
					val = 7;
					break;
				case "8":
					val = 8;
					break;
				case "9":
					val = 9;
					break;
				case "10":
					val = 10;
					break;
				case "J":
					val = 11;
					break;
				case "Q":
					val = 12;
					break;
				case "K":
					val = 13;
					break;
				case "A":
					val = 1;
					break;
			}
			this.value = val;
			this.suit = aSuit;
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
