package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PricingActivity extends Activity {
	private Bundle data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pricing);
		data = getIntent().getExtras();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pricing, menu);
		return true;
	}
	
	public void highlightEditTextById(int id, boolean on) {
		EditText et = (EditText) findViewById(id);
		et.setBackgroundColor(on ? Color.YELLOW : Color.WHITE);
	}
	
	public double getPrice (int cid){
		EditText qtyEdit = (EditText) findViewById(cid);
		Editable qtyE = qtyEdit.getText();
		
		try {
			highlightEditTextById(cid, false);
			return Double.parseDouble(qtyE.toString());
		} catch (Exception e) {
			e.printStackTrace();
			highlightEditTextById(cid, true);
			String toastText = "Incorrectly entered prices have been adjusted to $0.50.";
			Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
			return 0.50;
		}
	}
	
	public void continueToInventory(View v) {
    	//Launch to inventory
    	Intent i = new Intent(this, InventoryActivity.class);
    	//Save our info
    	
    	double applePrice = getPrice(R.id.applePrice);
    	double bananaPrice = getPrice(R.id.bananaPrice);
    	double grapesPrice = getPrice(R.id.grapesPrice);
    	double kiwiPrice = getPrice(R.id.kiwiPrice);
    	double orangePrice = getPrice(R.id.orangePrice);
    	double pearPrice = getPrice(R.id.pearPrice);
    	double granolaPrice = getPrice(R.id.granolaPrice);
    	double mixedPrice = getPrice(R.id.mixedPrice);
    	double smoothiePrice = getPrice(R.id.smoothiePrice);
    	
    	i.putExtra("apple_price", applePrice);
    	i.putExtra("banana_price", bananaPrice);
    	i.putExtra("grapes_price", grapesPrice);
    	i.putExtra("kiwi_price", kiwiPrice);
    	i.putExtra("orange_price", orangePrice);
    	i.putExtra("pear_price", pearPrice);
    	i.putExtra("granola_bars_price", granolaPrice);
    	i.putExtra("mixed_bags_price", mixedPrice);
    	i.putExtra("smoothies_price", smoothiePrice);
    	
    	this.startActivity(i);
    }

}
