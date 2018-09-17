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
}
