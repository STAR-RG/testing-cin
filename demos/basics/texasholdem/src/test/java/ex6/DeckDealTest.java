package ex6;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.ozsoft.texasholdem.Card;
import org.ozsoft.texasholdem.Deck;

/***
 * Test for the deal() methods from Deck.java. Test Lines: [90-93], [110-120],
 * [137-156].
 * 
 * @author Victor Chen (~vsyc)
 * 
 */
public class DeckDealTest {
	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	/**
	 * Covered line: 93
	 */
	@Test
	public void testDeal01() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		String cards = deck.toString();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < Card.NO_OF_RANKS * Card.NO_OF_SUITS; i++) {
			sb.append(deck.deal().toString());
			sb.append(" ");
		}

		Assert.assertEquals(cards, sb.toString().trim());
	}

	/**
	 * Covered lines: 90-92
	 */
	@Test(expected = IllegalStateException.class)
	public void testDeal02() {
		for (int i = 0; i <= Card.NO_OF_RANKS * Card.NO_OF_SUITS; i++) {
			deck.deal();
		}
	}

	/**
	 * Covered lines: 110-112
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDeal03() {
		deck.deal(0);
	}

	/**
	 * Covered lines: 113-115
	 */
	@Test(expected = IllegalStateException.class)
	public void testDeal04() {
		deck.deal(60);
	}

	/**
	 * Covered lines: 116-120
	 */
	@Test
	public void testDeal05() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		int quantidade = 52;
		deck.deal(quantidade);
		Assert.assertEquals(quantidade, deck.getNextCardIndex());
	}

	/**
	 * Covered lines: 137-139
	 */
	@Test(expected = IllegalStateException.class)
	public void testDeal06() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		for (int i = 0; i < Card.NO_OF_RANKS * Card.NO_OF_SUITS; i++) {
			deck.deal();
		}
		deck.deal(1, 1);
	}

	/**
	 * deal(4,1) enter
	 * "if ((cards[i].getRank() == rank) && (cards[i].getSuit() == suit))",
	 * "if (index != -1)" and "if (index != nextCardIndex)".
	 * 
	 * Covered lines: 140-156
	 */
	@Test
	public void testDeal07() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		// In Card.java: RANK_SYMBOLS[4] = "6", SUIT_SYMBOLS[1] = "c"
		Assert.assertEquals("6c", deck.deal(4, 1).toString());
	}

	/**
	 * Second deal(4,1) enter do not enter in any if's.
	 * 
	 * Covered lines: 140-143, 148, 156
	 */
	@Test
	public void testDeal08() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		// In Card.java: RANK_SYMBOLS[4] = "6", SUIT_SYMBOLS[1] = "c"
		Assert.assertEquals("6c", deck.deal(4, 1).toString());
		Assert.assertEquals(null, deck.deal(4, 1));
	}

	/**
	 * deal(11,3) enter
	 * "if ((cards[i].getRank() == rank) && (cards[i].getSuit() == suit))" and
	 * "if (index != -1)".
	 * 
	 * Covered lines: 140-149, 154-156
	 */
	@Test
	public void testDeal09() {
		Assume.assumeTrue(deck.getNextCardIndex() == 0);
		Assert.assertEquals("Ks", deck.deal(11, 3).toString());
	}
}