package ex6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ozsoft.texasholdem.Deck;

/***
 * Test for the shuffle() method from Deck.java. Test Lines: [66-72].
 * 
 * @author Victor Chen (~vsyc)
 * 
 */
public class DeckShuffleTest {
	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	/**
	 * Covered lines: 66-72
	 */
	@Test
	public void testShuffle() {
		String d1 = deck.toString();
		deck.shuffle();
		String d2 = deck.toString();
		Assert.assertNotEquals(d1, d2);
	}
}