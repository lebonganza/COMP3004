package core;

import java.util.Random;

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
	
	public Deck(Card[] arr) {
		int i=0;
		while(arr[i]!=null){
			i++;
		}
		this.cards = arr;
		numCards = i;
	}
	
	public int getNumCards() {
		return this.numCards;
	}
	
	public Card dealNextCard() {
		Card top = this.cards[0];
		//Shift all cards to the left because the front card was removed
		for(int i=1;i<cards.length;i++) {
			cards[i-1] = cards[i];
		}
		//set  the last duplicate card to null
		this.cards[this.numCards-1] = null;
		this.numCards--;
		return top;
	}
	
	public void shuffle() {
		Random rand = new Random();
		Card temp;
		int j;
		for(int i=0;i<this.numCards;i++) {
			
			j = rand.nextInt(this.numCards);
			temp = this.cards[i];
			this.cards[j] = temp;
		}
	}
	
	public Card getTop() {
		return cards[0];
	}
	
	
}
