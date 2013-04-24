package edu.upenn.cis350.project;

import edu.upenn.cis350.project.CalculateProfitActivity.ErrorDialog;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateRevenueActivity extends FragmentActivity {
	
	Bundle data;
	int tries;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate_revenue);
		data = this.getIntent().getExtras();
		TextView wholefruitlabel = (TextView)findViewById(R.id.wholeFruitTotalLabel);
		TextView smoothielabel = (TextView)findViewById(R.id.smoothieTotalLabel);
		TextView mixedbaglabel = (TextView)findViewById(R.id.mixedBagTotalLabel);
		TextView granolalabel = (TextView)findViewById(R.id.granolaTotalLabel);
		TextView couponlabel = (TextView)findViewById(R.id.couponLabel);
		TextView junkfoodlabel = (TextView)findViewById(R.id.junkfoodLabel);
		
		wholefruitlabel.setText("Whole Fruit: "+ data.getInt("whole_fruit") + "x"+ data.getDouble("whole_fruit_price")+" =");
		smoothielabel.setText("Smoothies: "+data.getInt("smoothies") + "x"+ data.getDouble("smoothies_price")+" =");
		mixedbaglabel.setText("Mixed Bags: "+data.getInt("mixed_bags") + "x"+ data.getDouble("mixed_bags_price")+" =");
		granolalabel.setText("Granola Bars: "+data.getInt("granolabars") + "x"+ data.getDouble("granola_bars_price")+" =");
		couponlabel.setText("Coupon Total Value =           $"+ data.getDouble("coupons_value"));
		junkfoodlabel.setText("Junk Food Total Value =        $"+ data.getDouble("junk_food_value"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculate_profit, menu);
		return true;
	}
	
	public void submit_calculations(View view){
		EditText wholefruit = (EditText)findViewById(R.id.wholeFruitRevenue);
		EditText smoothie = (EditText)findViewById(R.id.smoothieRevenue);
		EditText mixedbag = (EditText)findViewById(R.id.mixedBagRevenue);
		EditText granola = (EditText)findViewById(R.id.granolaRevenue);
		EditText total = (EditText)findViewById(R.id.totalRevenue);
		
		try{
			double usertotal = Double.parseDouble(total.getText().toString());
			double realtotal = data.getDouble("total_cash");
			if(realtotal == usertotal || tries > 2){
				Intent i = new Intent(this, CalculateProfitActivity.class);
				i.putExtras(data);
				this.startActivity(i);
			} else {
				double real_smoothie = data.getInt("smoothies") * data.getDouble("smoothies_price");
				double real_bags = data.getInt("mixed_bags") * data.getDouble("mixed_bags_price");
				double real_gran = data.getInt("granolabars") * data.getDouble("granola_bars_price");
				total.setBackgroundColor(Color.YELLOW);
				boolean smoothie_wrong = Math.abs(real_smoothie - Double.parseDouble(smoothie.getText().toString())) > .01;
				boolean bags_wrong = Math.abs(real_bags - Double.parseDouble(mixedbag.getText().toString())) > .01;
				boolean gran_wrong = Math.abs(real_gran) - Double.parseDouble(granola.getText().toString()) > .01;
				smoothie.setBackgroundColor(smoothie_wrong ? Color.YELLOW : Color.WHITE);
				mixedbag.setBackgroundColor(bags_wrong ? Color.YELLOW : Color.WHITE);
				granola.setBackgroundColor(gran_wrong ? Color.YELLOW : Color.WHITE);
				
				String toastText = "Looks like you made a mistake in your math...\n check that the total is equal to \n" +
						"total fruit sold - coupons - junk food";
				//Toast.makeText(getApplicationContext(), toastText.toString(), Toast.LENGTH_LONG).show();
				ErrorDialog errs = new ErrorDialog(toastText.toString());
				errs.show(getSupportFragmentManager(), "Error");
				tries += 1;
				return;
			}
		}
		catch(Exception e){
			String toastText = "Looks like you left the total blank...the total has to be filled in before submitting.";
			Toast.makeText(getApplicationContext(), toastText.toString(), Toast.LENGTH_LONG).show();
		}
	}

}
