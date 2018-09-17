package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	public void TestCard() {
		Card card = new Card(Suit.values()[0],5);
		assertEquals(5,card.getValue());
	}
}
