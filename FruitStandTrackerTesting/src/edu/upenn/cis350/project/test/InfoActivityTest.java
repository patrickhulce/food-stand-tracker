package edu.upenn.cis350.project.test;

import edu.upenn.cis350.project.InfoActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class InfoActivityTest extends ActivityInstrumentationTestCase2<InfoActivity>{
	InfoActivity activity;
	Spinner mySpinner;
	EditText volunteer1;
	EditText staff1;
	Button addVolunteer;
	Button addStaff;
	
	public InfoActivityTest() {
    	super("edu.upenn.cis350.project",InfoActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		mySpinner = (Spinner)activity.findViewById(edu.upenn.cis350.project.R.id.school);
		volunteer1 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.volunteer1);
		staff1 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.staff1);
		addVolunteer = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.add_volunteer);
		addStaff = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.add_staff);
	}
	
	public void testDate(){
		activity.year = 1999;
		activity.month = 1;
		activity.day = 1;
		String myYear = "1999";
		String myMonth = "1";
		String myDay = "1";
		assertEquals(myYear, activity.getYear());
		assertEquals(myMonth, activity.getMonth());
		assertEquals(myDay, activity.getDay());
	}
	
	
	public void testDateTwo(){
		activity.year = 2013;
		activity.month = 3;
		activity.day = 26;
		String myYear = "2013";
		String myMonth = "3";
		String myDay = "26";
		assertEquals(myYear, activity.getYear());
		assertEquals(myMonth, activity.getMonth());
		assertEquals(myDay, activity.getDay());
	}
	
	
	/*public void testSchoolAuden(){
		activity.school = null;
		activity.setSpinnerPosition(0);
		activity.getSchool();
		String mySchool = "Auden Reid High School";
		assertEquals(mySchool, activity.school);
	}
	*/
	
	/*
	public void testSchoolCommunications(){
		activity.school = null;
		mySpinner.setSpinnerPosition(4);
		activity.getSchool();
		String mySchool = "Communications Technology High School";
		assertEquals(mySchool, activity.school);
	}
	*/
	
	/*
	public void testAddSchool(){
		activity.school = null;
		mySpinner.setSpinnerPosition(20);
		String mySchool = "Here is a school";
		activity.addedSchool.enterText(mySchool);
		activity.getSchool();
		assertEquals(mySchool, activity.school);
	}
	*/
	
	public void testFillVolunteer(){
		activity.vol1 = null;
		String myVol = "Jerry";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				volunteer1.requestFocus();
				sendKeys("Jerry");
		}
		});
		getInstrumentation().waitForIdleSync();
		activity.fillVolunteers();
		assertEquals(myVol, activity.vol1);
	}
	
	public void testFillStaff(){
		activity.staff1 = null;
		String myStaff = "Jerry";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				staff1.requestFocus();
				sendKeys("Jerry");
		}
		});
		getInstrumentation().waitForIdleSync();
		activity.fillStaff();
		assertEquals(myStaff, activity.staff1);
	}
	
	public void testAddVolunteer(){
		activity.vol1 = null;
		activity.vol2 = null;
		activity.vol3 = null;
		activity.vol4 = null;
		activity.vol5 = null;
		
		String vol1 = "Mary";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				volunteer1.requestFocus();
				sendKeys("Mary");
		}
		});
		getInstrumentation().waitForIdleSync();
		
		String vol2 = "Lary";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText vol2Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.volunteer2);
				vol2Text.requestFocus();
				sendKeys("Lary");
		}
		});
		getInstrumentation().waitForIdleSync();
		
		String vol3 = "Gary";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText vol3Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.volunteer3);
				vol3Text.requestFocus();
				sendKeys("Gary");
		}
		});
		getInstrumentation().waitForIdleSync();
		
		String vol4 = "Bary";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText vol4Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.volunteer4);
				vol4Text.requestFocus();
				sendKeys("Bary");
		}
		});
		getInstrumentation().waitForIdleSync();
/*
		addVolunteer.performClick();
		String myVol = "Jerry";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText vol5Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id."5");
				vol5Text.requestFocus();
				sendKeys("Jerry");
		}
		});
		getInstrumentation().waitForIdleSync();
		*/
		activity.fillVolunteers();
		
		assertEquals(vol1, activity.vol1);
		assertEquals(vol2, activity.vol2);
		assertEquals(vol3, activity.vol3);
		assertEquals(vol4, activity.vol4);
		//assertEquals(vol5, activity.vol5);
	}
	
	public void testAddStaff(){
		activity.staff1 = null;
		activity.staff2 = null;
		activity.staff3 = null;
		
		String staff1 = "Mary";
		String staff2 = "Miss";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText staff1Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.staff1);
				staff1Text.requestFocus();
				sendKeys("Mary");
				EditText staff2Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.staff2);
				staff2Text.requestFocus();
				sendKeys("Miss");
		}
		});
		getInstrumentation().waitForIdleSync();

		/*addStaff.performClick();
		String staff3 = "Mack";
		activity.runOnUiThread(new Runnable() { 
			public void run() {
				EditText staff3Text = (EditText) activity.findViewById(edu.upenn.cis350.project.R.id.-3);
				staff3Text.requestFocus();
				sendKeys("Miss");
		}
		});
		getInstrumentation().waitForIdleSync();*/
		activity.fillStaff();
		
		assertEquals(staff1, activity.staff1);
		assertEquals(staff2, activity.staff2);
		//assertEquals(staff3, activity.staff3);
	}
}
