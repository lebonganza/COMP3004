package core;

import junit.framework.TestCase;
import java.io.*;

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
		assertTrue(player.getHandTotal() !=0);
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
	
	public void testGameInitialisation() {
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Game game = new Game(player,dealer);		
		String res = null;
	    PrintStream originalOut = System.out;
	    try {
	        ByteArrayOutputStream os = new ByteArrayOutputStream(100);
	        PrintStream capture = new PrintStream(os);
	        
	        System.setOut(capture);
	        game.initialize();
	        capture.flush();
	        res = os.toString();
	    } finally {
	        System.setOut(originalOut);
	    }
	    assertTrue(res != null);
	}
	
	public void testNumVisibleCards() {
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Game game = new Game(player,dealer);
		game.initialize();
		game.start();
		assertEquals(2,player.printHand(true));
		assertEquals(1,dealer.printHand(false));
		
	}
	
}
