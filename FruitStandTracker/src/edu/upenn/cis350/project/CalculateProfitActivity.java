package edu.upenn.cis350.project;

import com.parse.ParseObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateProfitActivity extends Activity {
	Bundle data;
	boolean errors = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data = getIntent().getExtras();
		setContentView(R.layout.activity_calculate_profit);
		TextView revenuevalue = (TextView)findViewById(R.id.revenueValue);
		revenuevalue.setText("$"+data.getDouble("total_cash"));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculate_profit, menu);
		return true;
	}

	private double getDoubleFromEditText(int id) {
		EditText et = (EditText) findViewById(id);
		return Double.valueOf(et.getText().toString());
	}

	public void checkCalculations(View v) {
		DataBaser db = DataBaser.getInstance();

		// Get all the doubles from the user input
		double revenue = data.getDouble("total_cash");
		double fruitCosts = getDoubleFromEditText(R.id.fruitStandCost);
		double smoothieCosts = getDoubleFromEditText(R.id.smoothieCost);
		double otherCosts = getDoubleFromEditText(R.id.otherCosts);
		double totalComputed = getDoubleFromEditText(R.id.totalCosts);
		double donations = getDoubleFromEditText(R.id.donationsAmount);
		double profitComputed = getDoubleFromEditText(R.id.profit);
		double endingCashbox = getDoubleFromEditText(R.id.endingCashbox);

		String[] errorMsgs = {
				"Looks like there were some errors with your input!\n", "", "",
				"", "Try again!\n" };

		// Only prevent them from moving on the first time.
		boolean preventCompletion = !errors;
		double totalReal = fruitCosts + smoothieCosts + otherCosts;
		if (Math.abs(totalReal - totalComputed) > .05) {
			errorMsgs[1] = "Total costs should be equal to fruit costs + smoothie costs + other costs.\n";
			errors = true;
		}
		double profitReal = revenue + donations - totalReal;
		if (Math.abs(profitReal - profitComputed) > .05) {
			errorMsgs[2] = "Profit should equal revenue + donations - total costs\n";
			errors = true;
		}
		double realEndingCash = revenue + donations
				+ db.getStartingCashboxAmount();
		if (Math.abs(endingCashbox - realEndingCash) > .50) {
			errorMsgs[3] = "Ending cash should equal starting cash + revenue + donations\n"
					+ "Are you sure you counted all of the cash?\n";
			errors = true;
		}
		if(preventCompletion) {
			StringBuffer toastText = new StringBuffer();
			for(int i=0; i< errorMsgs.length;i++) {
				toastText.append(errorMsgs[i]);
			}
			Toast.makeText(getApplicationContext(), toastText.toString(), Toast.LENGTH_LONG).show();
			return;
		}
		db.addInfo("revenue", String.valueOf(revenue));
		db.addInfo("total_costs", String.valueOf(totalReal));
		db.addInfo("donations", String.valueOf(donations));
		db.addInfo("profit", String.valueOf(profitReal));
		db.addInfo("ending_cashbox_amount", String.valueOf(endingCashbox));
		//saves the data to Parse
		for(String s: data.keySet()){
			db.addInfo(s, data.get(s).toString());
		}
		DataBaser.getInstance().databaseItThoroughly();
		db.databaseItThoroughly();
		
		this.startActivity(new Intent(this, StartActivity.class));
	}

}
