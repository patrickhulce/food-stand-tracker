package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class PricingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pricing);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pricing, menu);
		return true;
	}
	
	public void continueToInventory(View v) {
    	//Launch to weather
    	Intent i = new Intent(this, InventoryActivity.class);
    	//Save our info
    	//TODO Use savePreInventory() to save info
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }

}
