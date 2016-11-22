package ex2;

import org.junit.runner.RunWith;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CardTest.class,
	ex1.CardTest.class
})
public class TestSuite {
	
}
