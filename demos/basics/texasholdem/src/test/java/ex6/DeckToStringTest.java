package ex6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ozsoft.texasholdem.Deck;

/***
 * Test for the toString() method from Deck.java. Test Lines: [162-167].
 * 
 * @author Victor Chen (~vsyc)
 * 
 */
public class DeckToStringTest {
	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	/**
	 * Covered lines: 162-167
	 */
	@Test
	public void testToString() {
		String s = deck.toString();
		String[] d = s.split(" ");
		Assert.assertEquals(52, d.length);
	}
}