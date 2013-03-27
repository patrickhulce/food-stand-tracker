package edu.upenn.cis350.project;

import edu.upenn.cis350.project.InfoActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivityTest extends ActivityInstrumentationTestCase2<SaleActivity>{
	InfoActivity activity;
	Spinner mySpinner;
	EditText volunteer1;
	EditText staff1;
	
	public InfoActivityTest() {
		super("edu.upenn.cis350.project",InfoActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		act = getActivity();
		mySpinner = (Spinner)act.findViewById(edu.upenn.cis350.project.R.id.school);
		volunteer1 = (EditText)act.findViewById(edu.upenn.cis350.project.R.id.volunteer1);
		staff1 = (EditText)act.findViewById(edu.upenn.cis350.project.R.id.staff1);
	}
	
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
}