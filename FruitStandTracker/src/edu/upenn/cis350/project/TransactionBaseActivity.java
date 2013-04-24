package edu.upenn.cis350.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TransactionBaseActivity extends Activity {

	Bundle data;
	
	 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getExtras();
        
        String _wholefruit = "0", _smoothies = "0", _mixedbags = "0", _transactions = "0", _totalsales = "0", _granolabars = "0";
        
        if(data.get("whole_fruit") != null){
        	_wholefruit = data.get("whole_fruit").toString();
        	_smoothies = data.get("smoothies").toString();
        	_mixedbags = data.get("mixed_bags").toString();
        	_totalsales = "$"+data.getDouble("total_cash");
        	_transactions = data.get("transactions").toString();
        	_granolabars = data.get("granolabars").toString();
        } else {
        	data.putInt("whole_fruit", 0);
        	data.putInt("smoothies", 0);
        	data.putInt("mixed_bags", 0);
        	data.putDouble("total_cash", 0);
        	data.putInt("transactions", 0);
        	data.putInt("granolabars", 0);
        	data.putDouble("coupons_value", 0);
        	data.putDouble("junk_food_value", 0);
        }
        
        setContentView(R.layout.transaction_base_activity);
        
        TextView wholefruit = (TextView)findViewById(R.id.wholefruit);
        TextView smoothies = (TextView)findViewById(R.id.smoothies);
        TextView mixedbags = (TextView)findViewById(R.id.mixedbags);
        TextView transactions = (TextView)findViewById(R.id.transactions);
        TextView granolabars = (TextView)findViewById(R.id.granolabars);
        TextView totalsales = (TextView)findViewById(R.id.totalsales);
        
        wholefruit.setText(_wholefruit);
        smoothies.setText(_smoothies);
        mixedbags.setText(_mixedbags);
        totalsales.setText(_totalsales);
        transactions.setText(_transactions); 
        granolabars.setText(_granolabars);
    }

	public void newTransaction(View view){
		Intent i = new Intent(this, SaleActivity.class);
		i.putExtras(data);
		Object transactions = data.get("transactions");
		if(transactions == null){
			i.putExtra("transactions", 0);
		}
		this.startActivity(i);
	}
	 
	public void finishSession(View view){
		DataBaser.getInstance().databaseItThoroughly();
		//Continue on to calculations
		Intent i = new Intent(this,PreCalculationsPepActivity.class);
		i.putExtras(data);
		this.startActivity(i);
	}
}
