package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	public void testCard() {
		Card fiveofClubs = new Card(Suit.C,5);
		Card kingofClubs = new Card(Suit.C,10);
		Card queenofDiamonds = new Card(Suit.D,10);
		Card aceofHearts = new Card(Suit.H,1);
		Card jackofSpades = new Card(Suit.S,10);
		
		assertEquals(5,fiveofClubs.getValue());
		assertEquals(10,kingofClubs.getValue());
		assertEquals(10,queenofDiamonds.getValue());
		assertEquals(1,aceofHearts.getValue());
		assertEquals(10,jackofSpades.getValue());
	}
	
	public void testDeck() {
		Deck deck = new Deck();
		
		assertEquals(52, deck.getNumCards());
	}
}
