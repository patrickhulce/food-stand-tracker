package edu.upenn.cis350.test;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import edu.upenn.cis350.project.WeatherActivity;

public class WeatherActivityTest extends ActivityInstrumentationTestCase2<WeatherActivity> {

	WeatherActivity activity;
	SeekBar tempBar;
	RadioButton snowy;
	RadioGroup weather;
	Instrumentation myIns;
	
	public WeatherActivityTest(){
		super("edu.upenn.cis350.project", WeatherActivity.class);
	}
	
	protected void setup() throws Exception{
		super.setUp();
		activity = getActivity();
		tempBar = (SeekBar)activity.findViewById(edu.upenn.cis350.project.R.id.temp_bar);
		myIns = getInstrumentation();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testTempNoChange(){
		final int degreesRight = 0;
		String myTemp = "Temperature: 50F";
		activity = getActivity();
		myIns = getInstrumentation();
		tempBar = (SeekBar)activity.findViewById(edu.upenn.cis350.project.R.id.temp_bar);
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						tempBar.incrementProgressBy(degreesRight);
					}
				}
		); 
		myIns.waitForIdleSync();
	    assertEquals(myTemp, activity.getTemp());
	}
	
	public void testTemp20(){
		//if the original temperature is 50, plus 30 degrees 
		//should b 80 degrees
		activity = getActivity();
		tempBar = (SeekBar)activity.findViewById(edu.upenn.cis350.project.R.id.temp_bar);
		myIns = getInstrumentation();
		final int degreesRight = 20;
		String myTemp = "Temperature: 70F";
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						tempBar.incrementProgressBy(degreesRight);
					}
				}
		); 
		myIns.waitForIdleSync();
		Log.i("expected outcome", myTemp);
		Log.i("outcome", activity.getTemp());
	    assertEquals(myTemp, activity.getTemp());
	}
	
	public void testSnowy(){
		activity = this.getActivity();
		weather = (RadioGroup)activity.findViewById(edu.upenn.cis350.project.R.id.weatherRadio);
		snowy = (RadioButton)activity.findViewById(edu.upenn.cis350.project.R.id.snowy);
		myIns = getInstrumentation();
		int snowId = edu.upenn.cis350.project.R.id.snowy;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						weather.requestFocus();
						weather.check(edu.upenn.cis350.project.R.id.snowy);
					}
				}
		); 
		myIns.waitForIdleSync();
		assertEquals(snowId, weather.getCheckedRadioButtonId());
	}
}
