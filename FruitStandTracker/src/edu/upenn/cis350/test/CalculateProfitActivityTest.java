package edu.upenn.cis350.test;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import edu.upenn.cis350.project.CalculateProfitActivity;

public class CalculateProfitActivityTest extends ActivityInstrumentationTestCase2<CalculateProfitActivity> {

	private CalculateProfitActivity activity;
	private Intent i;
	private Bundle data;
	
	public CalculateProfitActivityTest(){
		super("edu.upenn.cis350.project", CalculateProfitActivity.class);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		//callActivityOnCreate(CalculateProfitActivity.class, data);
		activity = getActivity();
		i = activity.getIntent();
		i.putExtra("total_cash", 92);
		data = activity.getIntent().getExtras();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
	}
	
	public void testTotalCash(){
		Log.i("total_cash", "" + data.get("total_cash"));
	}
}
