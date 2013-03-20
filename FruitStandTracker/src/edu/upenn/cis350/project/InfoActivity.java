package edu.upenn.cis350.project;

import java.util.Calendar;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class InfoActivity extends Activity {
	
	private TextView saleDisplayDate;
	private Button changeDate;
	
	private int year;
	private int month;
	private int day;
	
	static final int DATE_DIALOG_ID = 999;
	
	private Button addVol;
	private LinearLayout volLayout;
	private int id;
	
	private Button addStaff;
	private LinearLayout staffLayout;
	private int sId;
	
	private LinearLayout schoolLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        
        Spinner spinner = (Spinner) findViewById(R.id.school);
        
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
             R.array.school_list, android.R.layout.simple_spinner_item);
     
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            	//20 is the id of the Add a School option
            	if(id == 20){
            		Log.i("adding", "This is indeed the add a school option");
            		schoolLayout = (LinearLayout) findViewById(R.id.additional_school);
            		EditText school = new EditText(InfoActivity.this);
            		school.setId(100);//completely arbitrary, still don't know what to do with ids
            		school.setWidth(LayoutParams.MATCH_PARENT);
        			school.setHeight(LayoutParams.WRAP_CONTENT);
        			school.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
        			school.setHint(R.string.school_hint);
        			schoolLayout.addView(school);
            	}
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        //for the date picker
        setCurrentDateOnView();
		addListenerOnButton();
		
		//for the volunteer adder
		addListenerAddVol();
		volLayout = (LinearLayout) findViewById(R.id.volunteer_list);  
        id = 5;
        
        //for the staff adder
        addListenerAddStaff();
        staffLayout = (LinearLayout) findViewById(R.id.staff_list);
        id = -3;
        
        //for Parse
        //Parse.initialize(this, 
        		//"vKGeILnmz4ajn4OtZQoentkFSvcg9gBKch4oTavc", "qSdO1zCvQfzFrJgvcljwylR4DVO7vse31lbn8TrE"); 
        
        Parse.initialize(this, "FgYhuudv6NX7eFOfZwoBzFzROzOPDAPRANtjfFWS", "b8Ph2auqSi5iwJ4I298nKk1iM1mfTCFCo2ttRrWA");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
     
    
 // display current date
	public void setCurrentDateOnView() {
 
		saleDisplayDate = (TextView) findViewById(R.id.saleDate);
 
	    //auto populating the date
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
 
		// set current date into textview
		saleDisplayDate.setText(new StringBuilder()
			// Month is 0 based, just add 1
			.append(month + 1).append("-").append(day).append("-")
			.append(year).append(" "));
 
	}
 
	public void addListenerOnButton() {
		 
		changeDate = (Button) findViewById(R.id.change_date);
 
		changeDate.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
 
			}
 
		});
 
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
		   // set date picker as current date
		   return new DatePickerDialog(this, datePickerListener, 
                         year, month,day);
		}
		return null;
	}
	
 
	private DatePickerDialog.OnDateSetListener datePickerListener 
    		= new DatePickerDialog.OnDateSetListener() {

			// when dialog box is closed, below method will be called.
			public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
				year = selectedYear;
				month = selectedMonth;
				day = selectedDay;

				// set selected date into textview
				saleDisplayDate.setText(new StringBuilder().append(month + 1)
						.append("-").append(day).append("-").append(year)
						.append(" "));
			}
		};
	
		//listener for button that should add an edittext for another volunteer
		public void addListenerAddVol(){
			addVol = (Button) findViewById(R.id.add_volunteer);
			
			addVol.setOnClickListener(new View.OnClickListener() {
				 
				@Override
				public void onClick(View v) {
					moreVolunteers();
	 
				}
	 
			});
		}
		
		//method that actually adds another edittext for another volunteer
		private void moreVolunteers(){
			EditText newVol = new EditText(this);
			newVol.setId(id);
			id++;
			newVol.setWidth(LayoutParams.MATCH_PARENT);
			newVol.setHeight(LayoutParams.WRAP_CONTENT);
			newVol.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
			newVol.setHint(R.string.names);
			volLayout.addView(newVol);
		}
	
		//listener for button that should add an edittext for another staff member
		public void addListenerAddStaff(){
			addStaff = (Button) findViewById(R.id.add_staff);
			
			addStaff.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					moreStaff();
					
				}
			});
			
		}
		
		//method that actually adds another edittext for another staff member
		private void moreStaff(){
			EditText newStaff = new EditText(this);
			newStaff.setId(sId);
			sId--;
			newStaff.setWidth(LayoutParams.MATCH_PARENT);
			newStaff.setHeight(LayoutParams.WRAP_CONTENT);
			newStaff.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
			newStaff.setHint(R.string.names);
			staffLayout.addView(newStaff);	
		}
    
    public void continueToWeather(View v) {
    	//save school
    	//save date
    	//save volunteers
    	//save staff
    	
    	//Launch to weather
    	Intent i = new Intent(this, WeatherActivity.class);
    	//Save our info
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }
}