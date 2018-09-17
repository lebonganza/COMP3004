package core;

public class Player {
	
	private String name;
	
	//Cards that are
	private Card hand[] = new Card[10];
	
	//number of cards in a players hand
	private int numCards=0;
	
	public Player(String nameIn) {
		this.name = nameIn;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addCard(Card card) {
		this.hand[numCards] = card;
		numCards++;
	}
	
	public int getHandTotal() {
		int total = 0;
		int cardValue;
		//Number of aces in a hand
		int numAces=0;
		
		for(int i=0;i<this.numCards;i++) {
			cardValue = this.hand[i].getValue();
			total+=cardValue;
		}
		
		return total;
		
	}
}
