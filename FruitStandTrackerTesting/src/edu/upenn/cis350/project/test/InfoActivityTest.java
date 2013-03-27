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
}
