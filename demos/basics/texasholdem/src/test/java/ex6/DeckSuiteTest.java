package ex6;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({ DeckSmokeTest.class, DeckToStringTest.class, DeckShuffleTest.class, DeckDealTest.class })

@RunWith(Suite.class)
public class DeckSuiteTest {
}