package calculator;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.image.ScreenshotTaker;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;

import java.io.File;
import java.io.IOException;

public class CalculatorGUITests_Alternative extends AssertJSwingJUnitTestCase {

    private FrameFixture window;
    private Calculator calc;

//     @BeforeClass
//     public static void setUpOnce() {
// 	FailOnThreadViolationRepaintManager.install();
//     }

    @Before
    public void onSetUp() {
	Calculator frame = GuiActionRunner.execute(new GuiQuery<Calculator>() {
		protected Calculator executeInEDT() {
		    return new Calculator();
		}
	    });
	window = new FrameFixture(robot(), frame);
	window.show(); // shows the frame to test
	robot().settings().delayBetweenEvents(200);
    }

    @After
    public void teardown() {
	window.cleanUp();
    }
	
    @Test
    public void testAdd() throws IOException {
	try {
	    window.button("2").click();
	    window.button("+").click();
	    window.button("2").click();
	    window.button("=").click();
	    window.textBox("lcd").requireText("4.0");
	} catch (Throwable e) {
	    snapshot("testAdd.png");
	    throw e;
	}
    }

    @Test
    public void testTimes() throws IOException {
	try {
	    window.button("3").click();
	    window.button("*").click();
	    window.button("3").click();
	    window.button("=").click();
	    window.textBox("lcd").requireText("9.0" /*FAILS if 9*/);
	} catch (Throwable e) {
	    snapshot("testTimes.png");
	    throw e;
	}
    }

    @Test
    public void testDivZero() throws IOException {
	try {
	    window.button("3").click();
	    window.button("/").click();
	    window.button("0").click();
	    window.button("=").click();
	    window.textBox("lcd").requireText("Inf");
	} catch (Throwable e) {
	    snapshot("testDivZero.png");
	    throw e;
	}
    }

    private void snapshot(String fileName) throws IOException {
	(new File(fileName)).delete();
	(new ScreenshotTaker()).saveDesktopAsPng(fileName);
    }

}