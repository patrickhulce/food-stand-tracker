package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class WeatherActivity extends Activity {
	Bundle data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		data = i.getExtras();
		setContentView(R.layout.activity_weather);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_weather, menu);
		return true;
	}

	public void continueToInventory(View v) {
    	//Launch to inventory
    	Intent i = new Intent(this, InventoryActivity.class);
    	//Save our info
    	i.putExtras(data);
    	i.putExtra("weather", "sunny");
    	this.startActivity(i);
	}
}
