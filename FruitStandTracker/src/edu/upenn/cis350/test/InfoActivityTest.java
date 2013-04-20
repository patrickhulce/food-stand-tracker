package edu.upenn.cis350.test;

import edu.upenn.cis350.project.InfoActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
	/*
	public void testDate(){
		act.year = 1999;
		act.month = 1;
		act.day = 1;
		String myYear = "1999";
		String myMonth = "1";
		String myDay = "1";
		assertEquals(myYear, act.getYear());
		assertEquals(myMonth, act.getMonth());
		assertEquals(myDay, act.getDay());
	}
	
	
	public void testDateTwo(){
		act.year = 2013;
		act.month = 3;
		act.day = 26;
		String myYear = "2013";
		String myMonth = "3";
		String myDay = "26";
		assertEquals(myYear, act.getYear());
		assertEquals(myMonth, act.getMonth());
		assertEquals(myDay, act.getDay());
	}
	
	
	public void testSchoolAuden(){
		act.school = null;
		mySpinner.setSpinnerPosition(0);
		act.getSchool();
		String mySchool = "Auden Reid High School";
		assertEquals(mySchool, act.school);
	}
	
	public void testSchoolCommunications(){
		act.school = null;
		mySpinner.setSpinnerPosition(4);
		act.getSchool();
		String mySchool = "Communications Technology High School";
		assertEquals(mySchool, act.school);
	}
	
	public void testAddSchool(){
		act.school = null;
		mySpinner.setSpinnerPosition(20);
		String mySchool = "Here is a school";
		act.addedSchool.enterText(mySchool);
		act.getSchool();
		assertEquals(mySchool, act.school);
	}
	
	public void testFillVolunteer(){
		act.vol1 = null;
		String myVol = "Jerry";
		volunteer1.enterText(myVol);
		act.fillVolunteers();
		assertEquals(myVol, act.vol1);
	}
	
	public void testFillStaff(){
		act.staff1 = null;
		String myStaff = "Jerry";
		staff1.enterText(myStaff);
		act.fillStaff();
		assertEquals(myStaff, act.staff1);
	}
	
	public void testAddVolunteer(){
		act.vol1 = null;
		act.vol2 = null;
		act.vol3 = null;
		act.vol4 = null;
		act.vol5 = null;
		
		String vol1 = "Mary";
		volunteer1.enterText(vol1);
		
		String vol2 = "Lary";
		EditText vol2Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.volunteer2);
		vol2Text.enterText(vol2);
		
		String vol3 = "Gary";
		EditText vol3Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.volunteer3);
		vol2Text.enterText(vol3);
		
		String vol4 = "Bary";
		EditText vol2Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.volunteer4);
		vol2Text.enterText(vol4);
		
		addVolunteer.performClick();
		String myVol = "Jerry";
		EditText vol5Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.5);
		vol5Text.enterText(myVol);
		act.fillVolunteers();
		
		assertEquals(vol1, act.vol1);
		assertEquals(vol2, act.vol2);
		assertEquals(vol3, act.vol3);
		assertEquals(vol4, act.vol4);
		assertEquals(vol5, act.vol5);
	}
	
	public void testAddStaff(){
		act.staff1 = null;
		act.staff2 = null;
		act.staff3 = null;
		
		String staff1 = "Mary";
		EditText staff1Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.staff1);
		staff1Text.enterText(staff1);
		
		String staff2 = "Miss";
		EditText staff2Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.staff2);
		staff2Text.enterText(staff2);
		
		addStaff.performClick();
		String staff3 = "Mack";
		EditText staff3Text = (EditText) act.findViewById(edu.upenn.cis350.project.R.id.-3);
		staff3Text.enterText(staff3);
		act.fillStaff();
		
		assertEquals(staff1, act.staff1);
		assertEquals(staff2, act.staff2);
		assertEquals(staff3, act.staff3);
	}
	*/
}