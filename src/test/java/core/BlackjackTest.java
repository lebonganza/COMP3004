package core;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase{
	
	public void TestCard() {
		Card card = new Card(5);
		assertEquals(5,card.getValue());
	}
}
