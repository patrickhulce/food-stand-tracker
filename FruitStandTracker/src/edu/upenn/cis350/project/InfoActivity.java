package edu.upenn.cis350.project;

import java.util.Calendar;

import com.parse.Parse;

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
	private DataBaser dataBaser;
	
	private String school; 
	
	private TextView saleDisplayDate;
	private Button changeDate;
	
	//variables for the date
	private int year;
	private int month;
	private int day;
	
	static final int DATE_DIALOG_ID = 999;
	
	//variables for adding volunteers
	private Button addVol;
	private LinearLayout volLayout;
	private int id;
	
	//variables for adding staff members
	private Button addStaff;
	private LinearLayout staffLayout;
	private int sId;
	
	private LinearLayout schoolLayout;
	private EditText addedSchool;

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
            	int i = (int) id;
            	determineSchool(i);
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
        
        //for databasing
        dataBaser = DataBaser.getInstance();
        
        //for Parse
        Parse.initialize(this, 
        		"vKGeILnmz4ajn4OtZQoentkFSvcg9gBKch4oTavc", "qSdO1zCvQfzFrJgvcljwylR4DVO7vse31lbn8TrE"); 
    }

    //based on the id chosen by the school spinner
    private void determineSchool(int i){
    	switch(i){
    	case 0:
    	{
    		school = "Auden Reid High School";
    		break;
    	}
    	case 1:
    	{
    		school = "Bartram High School";
    		break;
    	}
    	case 2:
    	{
    		school = "Bryant Elementary School";
    		break;
    	}
    	case 3:
    	{
    		school = "Comegys Elementary School";
    		break;
    	}
    	case 4:
    	{
    		school = "Communications Technology High School";
    		break;
    	}
    	case 5:
    	{
    		school = "Freire Charter School";
    		break;
    	}
    	case 6:
    	{
    		school = "Gideon Elementary School";
    		break;
    	}
    	case 7: 
    	{
    		school = "Hardy Williams Middle School";
    		break;
    	}
    	case 8:
    	{
    		school = "High School of the Future";
    		break;
    	}
    	case 9:
    	{
    		school = "Huey Elementary School";
    		break;
    	}
    	case 10:
    	{
    		school = "Lea Elementary School";
    		break;
    	}
    	case 11:
    	{
    		school = "Locke Elementary School";
    		break;
    	}
    	case 12:
    	{
    		school = "Pepper Middle School";
    		break;
    	}
    	case 13:
    	{
    		school = "Robeson High School";
    		break;
    	}
    	case 14:
    	{
    		school = "Sayre High School";
    		break;
    	}
    	case 15:
    	{
    		school = "Shaw Anna H Middle School";
    		break;
    	}
    	case 16:
    	{
    		school = "Strawberry Mansion High School";
    		break;
    	}
    	case 17:
    	{
    		school = "University City High School";
    		break;
    	}
    	case 18:
    	{
    		school = "West Philadelphia High School";
    		break;
    	}
    	case 19:
    	{
    		school = "Woodrow Wilson Middle School";
    		break;
    	}
    	case 20:
    	{
    		Log.i("adding", "This is indeed the add a school option");
    		schoolLayout = (LinearLayout) findViewById(R.id.additional_school);
    		addedSchool = new EditText(InfoActivity.this);
    		addedSchool.setId(100);//completely arbitrary, still don't know what to do with ids
    		addedSchool.setWidth(LayoutParams.MATCH_PARENT);
    		addedSchool.setHeight(LayoutParams.WRAP_CONTENT);
    		addedSchool.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
    		addedSchool.setHint(R.string.school_hint);
    		schoolLayout.addView(addedSchool);	
    		break;
    	}
    	}
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
    
		
		public void getSchool(){
			if(school == null)
	    		school = addedSchool.getText().toString();
		}
		
		public int getYear(){
			return year;
		}
		
		public int getMonth(){
			return month;
		}
		
		public int getDay(){
			return day;
		}
	
    public void continueToWeather(View v){
    	//save school information for later use
    	getSchool();
    	dataBaser.addInfo("school", school);    	
    	//Launch to weather
    	Intent i = new Intent(this, WeatherActivity.class);
    	//Save our info
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }
}







