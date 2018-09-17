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
	
	//To test if a card is removed after dealing it to a player
	public void testDeckChanges() {
		Deck deck = new Deck();
		deck.dealNextCard();
		assertEquals(51, deck.getNumCards());
	}
	
	public void testShuffle() {
		Deck deck = new Deck();
		Card preshuffle = deck.getTop();
		deck.shuffle();
		assertEquals(preshuffle,deck.getTop());
	}
	
	
	public void testAddCardToPlayer() {
		Deck deck = new Deck();
		Card  top = deck.dealNextCard();
		Player player = new Player("Player1");
		player.addCard(top);
		assertEquals(player.getHandTotal(), top.getValue());
	}
	
	public void testPlayer() {
		Player player = new Player("Player1");
		assertEquals("Player1",player.getName());
	}
	
	public void testPlayersHand() {
		Player player1 = new Player("Player2");
		player1.addCard(aceofHearts);
		player1.addCard(fiveofClubs);
		player1.addCard(jackofSpades);
		assertEquals(16,player1.getHandTotal());
	}
	
	public void testAcesValue() {
		Player player1 = new Player("Player2");
		player1.addCard(aceofHearts);
		player1.addCard(queenofDiamonds);
		assertEquals(21,player1.getHandTotal());
	}
	
	
	
}
