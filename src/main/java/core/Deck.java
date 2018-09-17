package core;

public class Deck {
	
	private Card[] cards;
	
	private int numCards;
	
	public Deck() {
		this.numCards = 52;
		this.cards = new Card[this.numCards];
		int count=0;
		//loop for suits
		for(int s=0;s<4;s++) {
			
			//loop for card values
			for(int i=1;i<=13;i++ ) {
				this.cards[count] = new Card(Suit.values()[s],i);
				count++;
			}
		}
	}
	
	public int getNumCards() {
		return this.numCards;
	}
}
