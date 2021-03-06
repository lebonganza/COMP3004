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
	
	public boolean addCard(Card card) {
		if(this.numCards ==10) {
			System.err.printf("%s 's hand already has 10 cards; "+ "cannot add another\n", this.name);
			System.exit(1);
		}
		this.hand[numCards] = card;
		numCards++;
		return (this.getHandTotal()<=21);
	}
	
	public int getHandTotal() {
		int total = 0;
		int cardValue;
		//Number of aces in a hand
		int numAces=0;
		
		for(int i=0;i<this.numCards;i++) {
			cardValue = this.hand[i].getValue();
			if(cardValue==1) {
				numAces++;
				total+=11;
			}else if(cardValue>10) {
				total+=10;
			}else {
				total +=cardValue;
			}
			
			/*while the player has one or more aces and the total of his hand is greater than 21
			 * the value of an ace becomes 1
			 */
			while(numAces>0 && total>21) {
				total-=10;
				numAces--;
			}
		}
		
		return total;
		
	}
	
	public int printHand(boolean showFirstCard) {
		int numVisibleCards = 0;
		System.out.println(this.name+ "'s cards:\n");
		for(int i=0;i<this.numCards;i++) {
			if(i==0 && !showFirstCard) {
				System.out.println("[Hidden]");
			}
			else {
				System.out.println(" "+this.hand[i].toString()+ "\n");
				numVisibleCards++;
			}
		}
		return numVisibleCards;
	}
	
	public boolean hit(Deck d) {
		System.out.printf("[%s Hits]\n",this.getName());
		return this.addCard(d.dealNextCard());
	}
	public void stand() {
		System.out.printf("[%s stands]\n",this.getName());
	}
}
