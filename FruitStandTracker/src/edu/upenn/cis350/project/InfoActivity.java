package edu.upenn.cis350.project;

import java.util.Calendar;
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

	//variables for school information
	private LinearLayout schoolLayout;
	private EditText addedSchool;
	private String school;
	
	//variables for the date
	private TextView saleDisplayDate;
	private Button changeDate;
	static final int DATE_DIALOG_ID = 999;
	private int year;
	private int month;
	private int day;
	
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
	public Button addStaff;
	private LinearLayout staffLayout;
	private int sId;
	public String staff1;
	public String staff2;
	public String staff3;
	public String staff4;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        
        final Spinner spinner = (Spinner) findViewById(R.id.school);
        
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
            	//creates a new EditText if the user would like to input their school
            	//20 is the id of the Add a School option of the School Spinner (school_list)
            	if(i == 20){
            		school = "check";//variable value that will alert an update method to act
            		Log.i("adding", "This is indeed the add a school option");
            		schoolLayout = (LinearLayout) findViewById(R.id.additional_school);
            		addedSchool = new EditText(InfoActivity.this);
            		addedSchool.setId(100);//completely arbitrary id
            		addedSchool.setWidth(LayoutParams.MATCH_PARENT);
            		addedSchool.setHeight(LayoutParams.WRAP_CONTENT);
            		addedSchool.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
            		addedSchool.setHint(R.string.school_hint);
            		schoolLayout.addView(addedSchool);	
            	}
            	else{
            		school = (String)spinner.getSelectedItem();
            	}
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        
        //for the date picker
        setCurrentDateOnView();
		addListenerDate();
		
		//for the volunteer adder
		addListenerAddVol();
		volLayout = (LinearLayout) findViewById(R.id.volunteer_list);  
        
        //for the staff adder
        addListenerAddStaff();
        staffLayout = (LinearLayout) findViewById(R.id.staff_list);

    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
     
    
    // display current date
	private void setCurrentDateOnView() {
 
		saleDisplayDate = (TextView) findViewById(R.id.saleDate);
 
	    //auto populating the date
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
 
		// set current date into textview
		saleDisplayDate.setText(
				Integer.toString(month + 1) + "-" + 
				Integer.toString(day) + "-" + 
				Integer.toString(year) + " ");
	}
 
	private void addListenerDate() {
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
				saleDisplayDate.setText(
						Integer.toString(month + 1) + "-" + 
						Integer.toString(day) + "-" + 
						Integer.toString(year) + " ");
			}
		};
		
		private void addListenerAddVol(){
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
		
		//method that adds a volunteer edittext
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
	
		private void addListenerAddStaff(){
			sId = -2;
			addStaff = (Button) findViewById(R.id.add_staff);
			
			addStaff.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					//I'm only going to allow for 4 staff members at this time
					//two original staff members, plus 2 staff members that may be
					//added in addition
					if(sId > -5){
						moreStaff();
					}					
				}
			});
			
		}
		
		//method that adds a staff edittext
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
    
		//if a request has been made to add a school, change the
		//value of school to the value in the text box
		//this can be determined by the current value of school -> "check"
		//else, do nothing
		public void updateSchool(){
			if(!school.equals("check")){
				return;
			}
			if(addedSchool.getText() != null)
	    		school = addedSchool.getText().toString();
		}
		
		//fills the volunteer string variables for later usage
		private void fillVolunteers(){
			if(((EditText) findViewById(R.id.volunteer1)).getText() != null)
				vol1 = ((EditText) findViewById(R.id.volunteer1)).getText().toString();
			if(((EditText) findViewById(R.id.volunteer2)).getText() != null)
				vol2 = ((EditText) findViewById(R.id.volunteer2)).getText().toString();
			if(((EditText) findViewById(R.id.volunteer3)).getText() != null)
				vol3 = ((EditText) findViewById(R.id.volunteer3)).getText().toString();
			if(((EditText) findViewById(R.id.volunteer4)).getText() != null)
				vol4 = ((EditText) findViewById(R.id.volunteer4)).getText().toString();
			if(id > 5 && ((EditText) findViewById(5)).getText() != null)
				vol5 = ((EditText) findViewById(5)).getText().toString();
			if(id > 6 && ((EditText) findViewById(6)).getText() != null)
				vol6 = ((EditText) findViewById(6)).getText().toString();
			if(id > 7 && ((EditText) findViewById(7)).getText() != null)
				vol7 = ((EditText) findViewById(7)).getText().toString();
			if(id > 8 && ((EditText) findViewById(8)).getText() != null)
				vol8 = ((EditText) findViewById(8)).getText().toString();
		}
		
		//getter method for number of volunteer edittexts exist
		public int getVolunteers(){
			return id;
		}
		
		//fills the staff string variables for later usage
		private void fillStaff(){
			if(((EditText) findViewById(R.id.staff1)).getText() != null)
				staff1 = ((EditText) findViewById(R.id.staff1)).getText().toString();
			if(((EditText) findViewById(R.id.staff2)).getText() != null)
				staff2 = ((EditText) findViewById(R.id.staff2)).getText().toString();
			if(sId < -3 && ((EditText) findViewById(-3)).getText() != null)
				staff3 = ((EditText) findViewById(-3)).getText().toString();
			if(sId < -4 && ((EditText) findViewById(-4)).getText() != null)
				staff4 = ((EditText) findViewById(-4)).getText().toString();
		}
		
		//getter method for number of staff edittexts exist
		public int getStaff(){
			return 0 - sId;
		}
		
		public String getYear(){
			return Integer.toString(year);
		}
		
		public String getMonth(){
			return Integer.toString(month + 1) ;
		}
		
		public String getDay(){
			return Integer.toString(day);
		}
		
		public String getSchool(){
			return school;
		}
	
    public void continueToWeather(View v){
    	Intent i = new Intent(this, WeatherActivity.class);
    	
    	//save school information for later use
    	fillVolunteers();
    	fillStaff();
    	updateSchool();
    	//only want to move on if a volunteer and a staff member have received input
    	if(vol1 != null && vol1.length() > 1 && 
    			staff1 != null && staff1.length() > 1
    			&& school != null && school.length() > 1){
    		DataBaser dataBaser = DataBaser.getInstance();
    		dataBaser.addInfo("school", getSchool());  
    		dataBaser.addInfo("year", getYear());
    		dataBaser.addInfo("month", getMonth());
    		dataBaser.addInfo("day", getDay());
    	
    		dataBaser.addInfo("vol1", vol1);
    		dataBaser.addInfo("vol2", vol2);
    		dataBaser.addInfo("vol3", vol3);
    		dataBaser.addInfo("vol4", vol4);
    		if(id > 5)
    			dataBaser.addInfo("vol5", vol5);
    		if(id > 6)
    			dataBaser.addInfo("vol6", vol6);
    		if(id > 7)
    			dataBaser.addInfo("vol7", vol7);
    		if(id > 8)
    			dataBaser.addInfo("vol8", vol8);
		
    		dataBaser.addInfo("staff1", staff1);
    		dataBaser.addInfo("staff2", staff2);
    		if(sId < -3)
    			dataBaser.addInfo("staff3", staff3);
    		if(sId < -4)
    			dataBaser.addInfo("staff4", staff4);
    	
    		this.startActivity(i);
    	}
    }
}







