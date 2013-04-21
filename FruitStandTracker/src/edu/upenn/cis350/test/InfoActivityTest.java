package edu.upenn.cis350.test;

import edu.upenn.cis350.project.InfoActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InfoActivityTest extends ActivityInstrumentationTestCase2<InfoActivity>{
	InfoActivity activity;
	Spinner mySpinner;
	EditText volunteer1;
	EditText volunteer2;
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
		volunteer2 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.volunteer2);
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
	
	public void testTwoVolunteers(){
		String name1 = "jerry seinfield";
		String name2 = "mickey mantel";
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						volunteer1.requestFocus();         
				    }
				} 
			);
		char [] jerry = name1.toCharArray();
		for(int i= 0; i< jerry.length; i++){
			this.sendKeys(fun_get_android_keycode(jerry[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						volunteer2.requestFocus();         
				    }
				} 
			);
		char [] mickey = name2.toCharArray();
		for(int i= 0; i< mickey.length; i++){
			this.sendKeys(fun_get_android_keycode(mickey[i]));
		}
		String[] volunteerArray = new String[8];
		volunteerArray[0] = name1;
		volunteerArray[1] = name2;
		for(int i = 2; i < volunteerArray.length; i++){
			volunteerArray[i] = null;
		}
		assertTrue(activity.verifyVolunteers(volunteerArray));
	}
	
	public void testEightVolunteers(){
		String name1 = "monica laskos";
		String name2 = "julie kozeracki";
		String name3 = "faryn pearl";
		String name4 = "mariam mahbob";
		String name5 = "boyang niu";
		String name6 = "daniel wei";
		String name7 = "patrick hulce";
		String name8 = "michael kraus";
		
		//0
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						volunteer1.requestFocus();         
				    }
				} 
			);
		char [] monica = name1.toCharArray();
		for(int i= 0; i< monica.length; i++){
			this.sendKeys(fun_get_android_keycode(monica[i]));
		}
		
		//1
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						volunteer2.requestFocus();         
				    }
				} 
			);
		char [] julie = name2.toCharArray();
		for(int i= 0; i< julie.length; i++){
			this.sendKeys(fun_get_android_keycode(julie[i]));
		}
		
		//2
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						EditText volunteer3 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.volunteer3);
						volunteer3.requestFocus();         
				    }
				} 
			);
		char [] faryn = name3.toCharArray();
		for(int i= 0; i< faryn.length; i++){
			this.sendKeys(fun_get_android_keycode(faryn[i]));
		}
		
		//3
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						EditText volunteer4 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.volunteer4);
						volunteer4.requestFocus();         
				    }
				} 
			);
		char [] mariam = name4.toCharArray();
		for(int i= 0; i< mariam.length; i++){
			this.sendKeys(fun_get_android_keycode(mariam[i]));
		}
		
		//4
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addVolunteer.requestFocus();
						addVolunteer.performClick();
						EditText volunteer5 = (EditText)activity.findViewById(4);
						volunteer5.requestFocus();         
				    }
				} 
			);
		char [] boyang = name5.toCharArray();
		for(int i= 0; i< boyang.length; i++){
			this.sendKeys(fun_get_android_keycode(boyang[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addVolunteer.requestFocus();
						addVolunteer.performClick();
						EditText volunteer6 = (EditText)activity.findViewById(5);
						volunteer6.requestFocus();         
				    }
				} 
			);
		char [] daniel = name6.toCharArray();
		for(int i= 0; i< daniel.length; i++){
			this.sendKeys(fun_get_android_keycode(daniel[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addVolunteer.requestFocus();
						addVolunteer.performClick();
						EditText volunteer7 = (EditText)activity.findViewById(6);
						volunteer7.requestFocus();         
				    }
				} 
			);
		char [] patrick = name7.toCharArray();
		for(int i= 0; i< patrick.length; i++){
			this.sendKeys(fun_get_android_keycode(patrick[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addVolunteer.requestFocus();
						addVolunteer.performClick();
						EditText volunteer8 = (EditText)activity.findViewById(7);
						volunteer8.requestFocus();         
				    }
				} 
			);
		char [] michael = name8.toCharArray();
		for(int i= 0; i< michael.length; i++){
			this.sendKeys(fun_get_android_keycode(michael[i]));
		}
		
		String[] volunteerArray = new String[8];
		volunteerArray[0] = name1;
		volunteerArray[1] = name2;
		volunteerArray[2] = name3;
		volunteerArray[3] = name4;
		volunteerArray[4] = name5;
		volunteerArray[5] = name6;
		volunteerArray[6] = name7;
		volunteerArray[7] = name8;
		
		assertTrue(activity.verifyVolunteers(volunteerArray));
	}
	
	public void testTwoStaff(){
		String name1 = "olive oil";
		String name2 = "pop eye";

		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						staff1.requestFocus();         
				    }
				} 
			);
		char [] olive = name1.toCharArray();
		for(int i= 0; i< olive.length; i++){
			this.sendKeys(fun_get_android_keycode(olive[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						EditText staff2 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.staff2);
						staff2.requestFocus();         
				    }
				} 
			);
		char [] pop = name2.toCharArray();
		for(int i= 0; i< pop.length; i++){
			this.sendKeys(fun_get_android_keycode(pop[i]));
		}
		
		String[] staffArray = new String[4];
		staffArray[0] = name1;
		staffArray[1] = name2;
		staffArray[2] = null;
		staffArray[3] = null;
		assertTrue(activity.verifyStaff(staffArray));
	}
	
	public void testFourStaff(){
		String name1 = "justin bieber";
		String name2 = "lady gaga";
		String name3 = "lady antebellum";
		String name4 = "school boy q";
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						staff1.requestFocus();         
				    }
				} 
			);
		char [] bieber = name1.toCharArray();
		for(int i= 0; i< bieber.length; i++){
			this.sendKeys(fun_get_android_keycode(bieber[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						EditText staff2 = (EditText)activity.findViewById(edu.upenn.cis350.project.R.id.staff2);
						staff2.requestFocus();         
				    }
				} 
			);
		char [] gaga = name2.toCharArray();
		for(int i= 0; i< gaga.length; i++){
			this.sendKeys(fun_get_android_keycode(gaga[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addStaff.requestFocus();
						addStaff.performClick();
						EditText staff3 = (EditText)activity.findViewById(12);
						staff3.requestFocus();         
				    }
				} 
			);
		char [] ant = name3.toCharArray();
		for(int i= 0; i< ant.length; i++){
			this.sendKeys(fun_get_android_keycode(ant[i]));
		}
		
		activity.runOnUiThread(
				new Runnable() {
					public void run() {
						addStaff.requestFocus();
						addStaff.performClick();
						EditText staff4 = (EditText)activity.findViewById(13);
						staff4.requestFocus();         
				    }
				} 
			);
		char [] boy = name4.toCharArray();
		for(int i= 0; i< boy.length; i++){
			this.sendKeys(fun_get_android_keycode(boy[i]));
		}
		
		String[] staffArray = new String[4];
		staffArray[0] = name1;
		staffArray[1] = name2;
		staffArray[2] = name3;
		staffArray[3] = name4;
		assertTrue(activity.verifyStaff(staffArray));
	}

	
}