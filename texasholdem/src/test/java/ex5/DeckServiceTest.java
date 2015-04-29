package ex5;

import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.ozsoft.texasholdem.Card;
import org.ozsoft.texasholdem.Deck;

public class DeckServiceTest {

	public static Deck getShuffledDeckInAVeryExpensiveWay() {
		Deck deck = new Deck();
		deck.shuffle();
		return deck;
	}
	
	public static void logDeckStateToFile(Deck deck, BufferedWriter output) throws IOException {
		output.append(deck.getNextCardIndex() + " " + deck.toString() + "\n");
	}
	
    @Test(timeout=6000)
    public void testCardsInAShuffledDeckAreNotEqual() throws InterruptedException {
    	Deck d = getShuffledDeckInAVeryExpensiveWay();
    	Card c = d.deal();
    	
    	for (int i = 0; i < 50; i++) {
    		Assert.assertNotEquals(c, d.deal());
    		Thread.sleep(100);
    	}
    }
    
    @Test(timeout=100)
    public void testDrawingFiveCards() {
    	Deck d = getShuffledDeckInAVeryExpensiveWay();
    	
    	for (int i = 0; i < 5; i++) {
    		d.deal();
    	}
    	
    	Assert.assertEquals(5,d.getNextCardIndex());
    }    
}
