package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class PreCalculationsPepActivity extends Activity {
	Bundle data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pre_calculations_pep);
		data = getIntent().getExtras();
	}

	public void startCalculating(View v) {
    	Intent i = new Intent(this, CalculateRevenueActivity.class);
    	i.putExtras(data);
    	this.startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
