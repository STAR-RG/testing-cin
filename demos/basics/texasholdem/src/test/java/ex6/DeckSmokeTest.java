package ex6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ozsoft.texasholdem.Card;
import org.ozsoft.texasholdem.Deck;

/***
 * Test for the getNextCardIndex() and reset() methods from Deck.java. Test
 * Lines: [81], [171].
 * 
 * @author Victor Chen (~vsyc)
 * 
 */
public class DeckSmokeTest {
	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	/**
	 * Covered line: 171
	 */
	@Test
	public void testGetNextCardIndex() {
		Assert.assertEquals(0, deck.getNextCardIndex());
		int number_cards = Card.NO_OF_RANKS * Card.NO_OF_SUITS;
		for (int i = 0; i < number_cards; i++) {
			deck.deal();
			Assert.assertEquals(i + 1, deck.getNextCardIndex());
		}
	}

	/**
	 * Covered line: 81
	 */
	@Test
	public void testReset() {
		deck.deal();
		deck.reset();
		Assert.assertEquals(0, deck.getNextCardIndex());
	}
}