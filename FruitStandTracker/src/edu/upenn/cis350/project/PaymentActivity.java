package edu.upenn.cis350.project;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivity extends Activity {

	Bundle data;
	HashMap<String, Integer> fruit;
	int total;
	int checked_out = 0;
	int cash;
	int coupons;
	int junk_food;
	
	Button submit_button;
	Button cash_button;	
	Button coupon_button;
	Button junk_food_button;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getExtras();
        fruit = (HashMap<String, Integer>) data.get("fruit");
        setContentView(R.layout.activity_sale_payment);
        TextView items = (TextView) findViewById(R.id.items);
        
        total = (Integer) data.get("total");
        cash_button = (Button)findViewById(R.id.cash);
        coupon_button = (Button)findViewById(R.id.coupon);
        junk_food_button = (Button)findViewById(R.id.junk_food);
        submit_button = (Button)findViewById(R.id.submit);        
        
        items.setText("Number of Items to Checkout:\n" + total);
    }
    
    public void updateItems(){
    	checked_out = cash+coupons+junk_food;
    	int total_left = total - checked_out;
    	TextView items = (TextView) findViewById(R.id.items);
        items.setText("Number of Items to Checkout:\n" + total_left);
        if(total_left == 0){
        	cash_button.setEnabled(false);
        	coupon_button.setEnabled(false);
        	junk_food_button.setEnabled(false);
        	submit_button.setEnabled(true);
        }
    }
    
    public void cash_button(View view){
    	cash += 1;
    	TextView text = (TextView) findViewById(R.id.cash_label);
    	text.setText("x"+cash);
    	updateItems();
    }
    
    public void coupon_button(View view){
    	coupons += 1;
    	TextView text = (TextView) findViewById(R.id.coupon_label);
    	text.setText("x"+coupons);
    	updateItems();
    }
    
    public void junk_food_button(View view){
    	junk_food += 1;
    	TextView text = (TextView) findViewById(R.id.junk_food_label);
    	text.setText("x"+junk_food);
    	updateItems();
    }
   
    public void submit_button(View view){
    	Intent transaction = new Intent(this, TransactionBaseActivity.class);
    	transaction.putExtras(data);
    	HashMap<String, Integer> payment = new HashMap<String, Integer>();
    	payment.put("cash", cash);
    	payment.put("coupon", coupons);
    	payment.put("junk", junk_food);
    	
    	int transactions_num = (Integer) data.get("transactions");
    	
    	transaction.putExtra("payment", payment);
    	transaction.putExtra("transactions", transactions_num+1);
    	this.startActivity(transaction);
    }
    
}
