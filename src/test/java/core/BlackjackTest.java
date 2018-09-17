package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	Card fiveofClubs = new Card(Suit.C,5);
	Card kingofClubs = new Card(Suit.C,10);
	Card queenofDiamonds = new Card(Suit.D,10);
	Card aceofHearts = new Card(Suit.H,1);
	Card jackofSpades = new Card(Suit.S,10);
	
	public void testCard() {
		
		assertEquals(5,fiveofClubs.getValue());
		assertEquals(10,kingofClubs.getValue());
		assertEquals(10,queenofDiamonds.getValue());
		assertEquals(1,aceofHearts.getValue());
		assertEquals(10,jackofSpades.getValue());
	}
	
	public void testToString() {
		assertEquals("C5", fiveofClubs.toString());
		assertEquals("HA", aceofHearts.toString());
	}
	public void testDeck() {
		Deck deck = new Deck();
		
		assertEquals(52, deck.getNumCards());
	}
}
