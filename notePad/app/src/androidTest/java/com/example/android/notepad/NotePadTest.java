/*
 * This is an example test project created in Eclipse to test NotePad which is a sample 
 * project located in AndroidSDK/samples/android-11/NotePad
 * 
 * 
 * You can run these test cases either on the emulator or on device. Right click
 * the test project and select Run As --> Run As Android JUnit Test
 * 
 * @author Renas Reda, renas.reda@robotium.com
 * 
 */

package com.example.android.notepad;

import com.robotium.solo.Solo;
import com.example.android.notepad.NotesList;
import android.test.ActivityInstrumentationTestCase2;



public class NotePadTest extends ActivityInstrumentationTestCase2<NotesList>{

	private Solo solo;

	public NotePadTest() {
		super(NotesList.class);

	}

	@Override
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	public void testVerificarActivity() throws Exception {
		solo.unlockScreen();
		solo.clickOnMenuItem("Add note");
		solo.assertCurrentActivity("Expected NoteEditor activity", "NoteEditor");
	}

	public void testAdicionarNota() throws Exception {
		solo.unlockScreen();
		solo.clickOnMenuItem("Add note");
		solo.enterText(0, "CIn-UFPE Nota 1");
		solo.goBack();
		solo.takeScreenshot();

		boolean notesFound = solo.searchText("CIn-UFPE Nota 1");
		assertTrue("CIn-UFPE Nota 1 is not found", notesFound); 

	}

	public void testAdicionarNota2() throws Exception {
		solo.unlockScreen();	
		solo.clickOnMenuItem("Add note");
		solo.typeText(0, "CIn-UFPE Nota 2");
		solo.goBack(); 
		solo.takeScreenshot();

		boolean notesFound = solo.searchText("CIn-UFPE Nota 2");
		assertTrue("CIn-UFPE Nota 2 is not found", notesFound); 

	}
	
	public void testEditarNota() throws Exception {
		solo.clickInList(2); 
		solo.hideSoftKeyboard();
		solo.setActivityOrientation(Solo.LANDSCAPE);
		solo.clickOnMenuItem("Edit title");
		solo.enterText(0, " teste");  
		solo.goBack();
		
		solo.setActivityOrientation(Solo.PORTRAIT);
		boolean noteFound = solo.waitForText("(?i).*?CIn-UFPE nota 1 teste"); 
		assertTrue("CIn-UFPE Nota 1 teste is not found", noteFound); 

	}
	
	public void testRemoverNota() throws Exception {
		solo.clickOnText("(?i).*?teste.*");
		solo.clickOnMenuItem("Delete");
		boolean noteFound = solo.searchText("CIn-UFPE Nota 1 teste");
		assertFalse("CIn-UFPE Nota 1 Teste is found", noteFound);   
	}

	public void testRemoverNota2() throws Exception {		
		solo.clickLongOnText("CIn-UFPE Nota 2");
		solo.clickOnText("Delete");  
		boolean noteFound = solo.waitForText("CIn-UFPE Nota 2", 1, 100);
		assertFalse("CIn-UFPE Nota 2 is found", noteFound);  
	}
}