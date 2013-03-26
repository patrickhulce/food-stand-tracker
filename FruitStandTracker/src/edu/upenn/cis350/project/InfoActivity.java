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
	private String vol1;
	private String vol2;
	private String vol3;
	private String vol4;
	private String vol5;
	private String vol6;
	private String vol7;
	private String vol8;
	
	//variables for adding staff members
	private Button addStaff;
	private LinearLayout staffLayout;
	private int sId;
	private String staff1;
	private String staff2;
	private String staff3;
	private String staff4;
	
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
        
        //for the staff adder
        addListenerAddStaff();
        staffLayout = (LinearLayout) findViewById(R.id.staff_list);
        
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
    		school = "check";
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
			id = 4;
			addVol = (Button) findViewById(R.id.add_volunteer);
			
			addVol.setOnClickListener(new View.OnClickListener() {
				 
				@Override
				public void onClick(View v) {
					//I'm only going to allow for 8 volunteers at this time
					//four original volunteers, plus 4 volunteers that may be added
					//in addition
					if(id < 9){
						moreVolunteers();
					}
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
			sId = -2;
			addStaff = (Button) findViewById(R.id.add_staff);
			
			addStaff.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					//I'm only going to allow for 4 staff members at this time
					//two original staff members, plus 2 staff members that may be
					//added in addition
					if(sId > -5){
						Log.i("sID is ", "" + sId);
						moreStaff();
					}					
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
    
		
		private void getSchool(){
			if(!school.equals("check")){
				return;
			}
	    		school = addedSchool.getText().toString();
		}
		
		private void fillVolunteers(){
			vol1 = ((EditText) findViewById(R.id.volunteer1)).getText().toString();
			vol2 = ((EditText) findViewById(R.id.volunteer2)).getText().toString();
			vol3 = ((EditText) findViewById(R.id.volunteer3)).getText().toString();
			vol4 = ((EditText) findViewById(R.id.volunteer4)).getText().toString();
			if(id > 5)
				vol5 = ((EditText) findViewById(5)).getText().toString();
			if(id >= 6)
				vol6 = ((EditText) findViewById(6)).getText().toString();
			if(id >= 7)
				vol7 = ((EditText) findViewById(7)).getText().toString();
			if(id >= 8)
				vol8 = ((EditText) findViewById(8)).getText().toString();
		}
		
		private void fillStaff(){
			staff1 = ((EditText) findViewById(R.id.staff1)).getText().toString();
			staff2 = ((EditText) findViewById(R.id.staff2)).getText().toString();
			if(sId < -3)
				staff3 = ((EditText) findViewById(-3)).getText().toString();
			if(sId <= -4)
				staff4 = ((EditText) findViewById(-4)).getText().toString();
		}
		
		private String getYear(){
			return Integer.toString(year);
		}
		
		private String getMonth(){
			return Integer.toString(month);
		}
		
		private String getDay(){
			return Integer.toString(day);
		}
	
    public void continueToWeather(View v){
    	//Launch to weather
    	Intent i = new Intent(this, WeatherActivity.class);
    	//Save our info
    	i.putExtra("herma", "derp");
    	
    	//save school information for later use
    	//only want to move on if a volunteer and a staff member have been inputed
    	fillVolunteers();
    	fillStaff();
    	if(vol1 != null && vol1.length() > 1 && 
    			staff1 != null && staff1.length() > 1){
    	DataBaser dataBaser = DataBaser.getInstance();
    	getSchool();
    	dataBaser.addInfo("school", school);  
    	
    	dataBaser.addInfo("year", getYear());
    	dataBaser.addInfo("month", getMonth());
    	dataBaser.addInfo("day", getDay());
    	
    	dataBaser.addInfo("vol1", vol1);
    	dataBaser.addInfo("vol2", vol2);
    	dataBaser.addInfo("vol3", vol3);
    	dataBaser.addInfo("vol4", vol4);
    	if(id > 5)
			dataBaser.addInfo("vol5", vol5);
		if(id >= 6)
			dataBaser.addInfo("vol6", vol6);
		if(id >= 7)
			dataBaser.addInfo("vol7", vol7);
		if(id >= 8)
			dataBaser.addInfo("vol8", vol8);
		
		dataBaser.addInfo("staff1", staff1);
		dataBaser.addInfo("staff2", staff2);
		if(sId < -3)
			dataBaser.addInfo("staff3", staff3);
		if(sId <= -4)
			dataBaser.addInfo("staff4", staff4);
    	
    	this.startActivity(i);
    	}
    }
}







