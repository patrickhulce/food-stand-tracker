package edu.upenn.cis350.test;

import edu.upenn.cis350.project.InfoActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
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
	Button changeDate;
	
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
		changeDate = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.change_date);
	}
	
	
	public void testSchoolBartram() {
		//item 3 on the list is Bartram High School
		int mySelection = 2;
	    activity.runOnUiThread(
	      new Runnable() {
	        public void run() {
	          mySpinner.requestFocus();
	          mySpinner.setSelection(0);          
	        } 
	      } 
	    ); 
	    this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
	    for (int i = 0; i < mySelection; i++) {
	      this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
	    } 
	    this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
	    activity.updateSchool();
	    String mySchool = "Bartram High School";
	    assertEquals(mySchool, activity.getSchool());
	}
	
	public void testSchoolStrawberry(){
		int mySelection = 17;
		activity.runOnUiThread(
			new Runnable() {
				public void run() {
					mySpinner.requestFocus();
			        mySpinner.setSelection(0);          
			    } 
			} 
		);
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		for (int i = 0; i < mySelection; i++) {
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		} 
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		activity.updateSchool();
		String mySchool = "Strawberry Mansion High School";
		assertEquals(mySchool, activity.getSchool());
	}
	
	
	//CODE FOR THIS METHOD FROM 
	//http://stackoverflow.com/questions/11684346/how-to-type-chars-from-android-keyboardvirtual-in-robotium
	 public int fun_get_android_keycode(char ch)
	  {  
	       int keycode = ch;//String.valueOf(ch).codePointAt(0);
	       //Log.v(TAG,"in fun : "+ch+" : "+keycode + "");

	       if(keycode>=97 && keycode <=122)
	       {
	           //Log.v(TAG,"atoz : "+ch+" : "+keycode + " : " + (keycode-68));
	           return keycode-68;   
	       }
	       else if(keycode>=65 && keycode <=90)
	       {
	           //Log.v(TAG,"atoz : "+ch+" : "+keycode + " : " + (keycode-36));
	           return keycode-36;   
	       }
	       else if(keycode>=48 && keycode <=57)
	       {
	           //Log.v(TAG,"0to9"+ch+" : "+keycode + " : " + (keycode-41));
	           return keycode-41;   
	       }
	       else if(keycode==64)
	       {
	           //Log.v(TAG,"@"+ch+" : "+keycode + " : " + "77");
	           return KeyEvent.KEYCODE_AT;
	       }
	       else if(ch=='.')
	       {
	           //Log.v(TAG,"DOT "+ch+" : "+keycode + " : " + "158");
	           return KeyEvent.KEYCODE_PERIOD;
	       }
	       else if(ch==',')
	       {
	           //Log.v(TAG,"comma "+ch+" : "+keycode + " : " + "55");
	           return KeyEvent.KEYCODE_COMMA;
	       }
	       return 62;
	}
	
	 /****only testing lowercase examples****/
	 
	public void testAddSchool(){
		int mySelection = 20;
		activity.runOnUiThread(
			new Runnable() {
				public void run() {
					mySpinner.requestFocus();
			        mySpinner.setSelection(0);          
			    }
			} 
		);
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		for (int i = 0; i < mySelection; i++) {
			this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
		} 
		this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
		String mySchool = "check";
		assertEquals(mySchool, activity.getSchool());
		//enter text and check that it works
		mySchool = "lauralton hall";
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						EditText schoolText = (EditText)activity.findViewById(100);
						schoolText.requestFocus();          
				    }
				} 
			);
			char [] lauralton = mySchool.toCharArray();
			for (int i = 0; i < lauralton.length; i++) {
				this.sendKeys(fun_get_android_keycode(lauralton[i]));
			} 	
		activity.updateSchool();
		assertEquals(mySchool, activity.getSchool());
	}
	/*
	public void testDate(){
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						changeDate.requestFocus();         
				    }
				} 
			);
			this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
			for (int i = 0; i < mySelection; i++) {
				this.sendKeys(KeyEvent.KEYCODE_DPAD_DOWN);
			} 
			this.sendKeys(KeyEvent.KEYCODE_DPAD_CENTER);
	}
	*/
	
}