package edu.upenn.cis350.project;

import java.util.ArrayList;
import java.util.Collections;
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
		cash_button = (Button) findViewById(R.id.cash);
		coupon_button = (Button) findViewById(R.id.coupon);
		junk_food_button = (Button) findViewById(R.id.junk_food);
		submit_button = (Button) findViewById(R.id.submit);

		items.setText("Number of Items to Checkout:\n" + total);
	}

	public void updateItems() {
		checked_out = cash + coupons + junk_food;
		int total_left = total - checked_out;
		TextView items = (TextView) findViewById(R.id.items);
		items.setText("Number of Items to Checkout:\n" + total_left);
		if (total_left == 0) {
			cash_button.setEnabled(false);
			coupon_button.setEnabled(false);
			junk_food_button.setEnabled(false);
			submit_button.setEnabled(true);
		} else {
			cash_button.setEnabled(true);
			coupon_button.setEnabled(true);
			junk_food_button.setEnabled(true);
			submit_button.setEnabled(false);
		}
	}

	public void cash_button(View view) {
		cash += 1;
		TextView text = (TextView) findViewById(R.id.cash_label);
		text.setText("x" + cash);
		updateItems();
	}

	public void coupon_button(View view) {
		coupons += 1;
		TextView text = (TextView) findViewById(R.id.coupon_label);
		text.setText("x" + coupons);
		updateItems();
	}

	public void junk_food_button(View view) {
		junk_food += 1;
		TextView text = (TextView) findViewById(R.id.junk_food_label);
		text.setText("x" + junk_food);
		updateItems();
	}

	public void clear_button(View view){
		checked_out = 0;
		cash = 0;
		coupons = 0;
		junk_food = 0;
		updateItems();
		int[] buttons = {R.id.cash_label, R.id.coupon_label, R.id.junk_food_label};
		for(int i: buttons){
			TextView text = (TextView)findViewById(i);
			text.setText("x0");
		}
	}
	
	public void submit_button(View view) {
		Intent transaction = new Intent(this, TransactionBaseActivity.class);
		
		HashMap<String, Integer> payment = new HashMap<String, Integer>();
		ArrayList<Double> prices = new ArrayList<Double>();
		
		for(int i = 0; i < data.getInt("whole_fruit"); i++){
			prices.add(data.getDouble("whole_fruit_price"));
		}
		for(int i = 0; i < data.getInt("granolabars"); i++){
			prices.add(data.getDouble("granolabars_price"));
		}
		for(int i = 0; i < data.getInt("mixed_bags"); i++){
			prices.add(data.getDouble("mixed_bags_price"));
		}
		for(int i = 0; i < data.getInt("smoothies"); i++){
			prices.add(data.getDouble("smoothies_price"));
		}
		Collections.sort(prices);
		int counter = 0;
		double coupons_value = 0, junk_food_value = 0, cash_value = 0;
		for(int i = 0; i < coupons; i++){
			coupons_value += prices.get(counter);
			counter++;
		}
		for(int i = 0; i < junk_food; i++){
			junk_food_value += prices.get(counter);
			counter++;
		}
		for(int i = 0; i < cash; i++){
			cash_value += prices.get(counter);
			counter++;
		}
		
		payment.put("cash", cash);
		payment.put("coupon", coupons);
		payment.put("junk", junk_food);
		
		data.putDouble("coupons_value", data.getDouble("coupons_value")+coupons_value);
		data.putDouble("junk_food_value", data.getDouble("junk_food_value")+junk_food_value);
		data.putDouble("total_cash", data.getDouble("total_cash")+cash_value);
		
		transaction.putExtras(data);
		
		// Added piece to save information about individual transaction to database.
		fruit.put("mixed_bags", data.getInt("mixed_bags"));
		fruit.put("smoothies", data.getInt("smoothies"));
		DataBaser db = DataBaser.getInstance();
		db.addTransaction(fruit, payment, data.getString("gender"),
				data.getString("grade"));

		int transactions_num = (Integer) data.get("transactions");

		transaction.putExtra("payment", payment);
		transaction.putExtra("transactions", transactions_num + 1);
		this.startActivity(transaction);
	}

}
