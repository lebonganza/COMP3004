package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	public void testCard() {
		Card card = new Card(Suit.values()[0],5);
		assertEquals(5,card.getValue());
	}
	
	public void testDeck() {
		Deck deck = new Deck();
		
		assertEquals(52, deck.getNumCards());
	}
}
