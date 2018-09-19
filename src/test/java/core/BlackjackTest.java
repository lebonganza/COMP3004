package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	Card fiveofClubs = new Card(Suit.C,5);
	Card kingofClubs = new Card(Suit.C,10);
	Card queenofDiamonds = new Card(Suit.D,10);
	Card aceofHearts = new Card(Suit.H,1);
	Card jackofSpades = new Card(Suit.S,10);
	Card aceofSpades = new Card(Suit.S,1);
	
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
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		deck1.shuffle();
		assertFalse(deck1.equals(deck2));
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
		Player player1 = new Player("Player1");
		player1.addCard(aceofHearts);
		player1.addCard(queenofDiamonds);
		
		Player player2 = new Player("Player2");
		player2.addCard(aceofHearts);
		player2.addCard(queenofDiamonds);
		player2.addCard(fiveofClubs);
		
		assertEquals(21,player1.getHandTotal());
		assertEquals(16,player2.getHandTotal());
		
		player1.addCard(aceofSpades);
		assertEquals(12,player1.getHandTotal());
		
		Player player3 = new Player("Player3");
		player3.addCard(aceofSpades);
		player3.addCard(aceofHearts);
		
		assertEquals(12,player3.getHandTotal());
		
		
	}
	
	
	public void testNumVisibleCards() {
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Game game = new Game(player,dealer);
		game.initialize(1);		
		game.start(1);
		assertEquals(2,player.printHand(true));
		assertEquals(1,dealer.printHand(false));
		
	}
	public void testPlayerHit() {
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Deck deck = new Deck();
		
		//test if a player can hit
		int totalbeforeHit = player.getHandTotal();
		player.hit(deck);
		int totalafterHit = player.getHandTotal();
		assertFalse(totalafterHit==totalbeforeHit);
		
		//test if a dealer can hit
		int totalbeforeHit2 = dealer.getHandTotal();
		dealer.hit(deck);
		int totalafterHit2 = dealer.getHandTotal();
		assertFalse(totalafterHit2==totalbeforeHit2);
	}
	
	public void testPlayerStand() {
		Player player = new Player("Player");
		player.stand();
		assertEquals(0, player.getHandTotal());
	}
	public void testWinner() {
		Player player = new Player("Player");
		Player dealer = new Player("Dealer");
		Game game = new Game(player,dealer);
		player.addCard(aceofHearts);
		player.addCard(queenofDiamonds);
		
		dealer.addCard(aceofHearts);
		dealer.addCard(queenofDiamonds);
		dealer.addCard(fiveofClubs);
		//returns 1 if the player won and 0 otherwise
		int winner = game.checkWinner(player,dealer);
		assertEquals(1,winner);
	}
}
