package ex3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.ozsoft.texasholdem.Card;
import org.ozsoft.texasholdem.Deck;

public class DeckServiceTest {
	
	public static Deck getShuffledDeckInAVeryExpensiveWay() {
		Deck deck = new Deck();
		deck.shuffle();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Shouldn't happen, but...");
		}
		return deck;
	}
	
	public static void logDeckStateToFile(Deck deck, BufferedWriter output) throws IOException {
		output.append(deck.getNextCardIndex() + " " + deck.toString() + "\n");
	}
	
    @Test
    public void testCardsInAShuffledDeckAreNotEqual() {
    	Deck d = getShuffledDeckInAVeryExpensiveWay();
    	Card c = d.deal();
    	
    	for (int i = 0; i < 50; i++) {
    		Assert.assertNotEquals(c, d.deal());
    	}
    	
    	try {
    		File file = new File("test-ex3.txt");
    		BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
    		logDeckStateToFile(d, output);
    		output.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    		Assert.fail("Error while writing file");
    	}
    }
    
    @Test
    public void testDrawingFiveCards() {
    	Deck d = getShuffledDeckInAVeryExpensiveWay();
    	
    	for (int i = 0; i < 5; i++) {
    		d.deal();
    	}
    	
    	Assert.assertEquals(5,d.getNextCardIndex());
    	
    	try {
    		File file = new File("test-ex3.txt");
    		BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
    		logDeckStateToFile(d, output);
    		output.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    		Assert.fail("Error while writing file");
    	}
    }    
}
