package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
	
	private double getPrice (int cid){
		EditText qtyEdit = (EditText) findViewById(cid);
		Editable qtyE = qtyEdit.getText();
		
		try {
			return Double.parseDouble(qtyE.toString());
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void continueToInventory(View v) {
    	//Launch to weather
    	Intent i = new Intent(this, InventoryActivity.class);
    	//Save our info
    	
    	double wholePrice = getPrice(R.id.wholePrice);
    	double granolaPrice = getPrice(R.id.granolaPrice);
    	double mixedPrice = getPrice(R.id.mixedPrice);
    	double smoothiePrice = getPrice(R.id.smoothiePrice);
    	
    	i.putExtra("whole_fruit_price", wholePrice);
    	i.putExtra("granola_bars_price", granolaPrice);
    	i.putExtra("mixed_bags_price", mixedPrice);
    	i.putExtra("smoothie_price", smoothiePrice);
    	
    	this.startActivity(i);
    }

}
