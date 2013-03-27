package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateRevenueActivity extends Activity {
	
	Bundle data;	
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
		
		wholefruitlabel.setText(data.getInt("whole_fruit") + "x 0.50 =");
		smoothielabel.setText(data.getInt("smoothie") + "x 0.50 = ");
		mixedbaglabel.setText(data.getInt("mixed_bag") + "x 0.50 = " );
		granolalabel.setText(data.getInt("granolabars") + "x 0.50 = ");
		couponlabel.setText(data.getInt("coupons") + "x 0.50 = ");
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
		EditText total = (EditText)findViewById(R.id.totalRevenue);
		EditText coupon = (EditText)findViewById(R.id.couponRevenue);
		
		double usertotal = Double.parseDouble(total.getText().toString());
		double realtotal = data.getDouble("totalcash");
		if(realtotal == usertotal){
			Intent i = new Intent(this, CalculateProfitActivity.class);
			i.putExtras(data);
			//TODO Change to real value of revenue later
			i.putExtra("final_revenue", 10.00);
			this.startActivity(i);
		}
	
	}

}
