package edu.upenn.cis350.project;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class SaleActivity extends Activity {
	Bundle data;
	
	String gender = "";
	
	int apples = 0;
	int pears = 0;
	int bananas = 0;
	int kiwis = 0;
	int peaches = 0;
	int grapes = 0;
	int others = 0;
	int whole_fruit = 0;
	
	int smoothie = 0;
	int mixed_bag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        data = getIntent().getExtras();
        
        setContentView(R.layout.activity_sale_person);
        TextView wholefruittext = (TextView)findViewById(R.id.whole_fruit_label);
        TextView smoothietext = (TextView)findViewById(R.id.smoothie_label);
        TextView bagtext = (TextView)findViewById(R.id.mixed_bag_label);
        wholefruittext.setText("x" + whole_fruit);
        smoothietext.setText("x" + smoothie);
        bagtext.setText("x" + mixed_bag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
    public void whole_fruit_clicked(View view){
    	LinearLayout fruitview = (LinearLayout)findViewById(R.id.fruitchoice);
    	fruitview.setVisibility(1);
    }
    
    public void updateWholeFruit(){
    	TextView text = (TextView)findViewById(R.id.whole_fruit_label);
    	whole_fruit = apples+pears+bananas+kiwis+peaches+others+grapes;
    	text.setText("x" + whole_fruit);
    }
    
    public void smoothie_clicked(View view){
    	TextView text = (TextView)findViewById(R.id.smoothie_label);
    	smoothie += 1;
    	text.setText("x" + smoothie);
    }
    
    public void mixed_bag_clicked(View view){
    	TextView text = (TextView)findViewById(R.id.mixed_bag_label);
    	mixed_bag += 1;
    	text.setText("x" + mixed_bag);
    }

    public void apples_button(View view){
    	TextView text = (TextView)findViewById(R.id.apple_label);
    	apples += 1;
    	text.setText("x"+apples);
    	updateWholeFruit();
    }
    public void peaches_button(View view){
    	TextView text = (TextView)findViewById(R.id.peach_label);
    	peaches += 1;
    	text.setText("x"+peaches);
    	updateWholeFruit();
    }
    
    public void bananas_button(View view){
    	TextView text = (TextView)findViewById(R.id.banana_label);
    	bananas += 1;
    	text.setText("x"+bananas);
    	updateWholeFruit();
    }
    
    public void grapes_button(View view){
    	TextView text = (TextView)findViewById(R.id.grape_label);
    	grapes += 1;
    	text.setText("x"+grapes);
    	updateWholeFruit();
    }
    
    public void kiwis_button(View view){
    	TextView text = (TextView)findViewById(R.id.kiwi_label);
    	kiwis += 1;
    	text.setText("x"+kiwis);
    	updateWholeFruit();
    }
    
    public void pears_button(View view){
    	TextView text = (TextView)findViewById(R.id.pear_label);
    	pears += 1;
    	text.setText("x"+pears);
    	updateWholeFruit();
    }
    
    public void others_button(View view){
    	TextView text = (TextView)findViewById(R.id.other_label);
    	others += 1;
    	text.setText("x"+others);
    	updateWholeFruit();
    }
    
    public void gender_button(View view){
    	 // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        Button submit_button = (Button)findViewById(R.id.button_continue);
        
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.boys:
                if (checked)
                    gender = "M";
                break;
            case R.id.girls:
                if (checked)
                    gender = "F";
                break;
        }
    	submit_button.setEnabled(true);
    }
    
    public void go_to_checkout(View view){
    	Intent i = new Intent(this, PaymentActivity.class);
    	
    	Spinner age = (Spinner)findViewById(R.id.choosePerson);
    	String grade = (String)age.getSelectedItem();
    	
    	i.putExtras(data);
    	HashMap<String, Integer> fruit = new HashMap<String, Integer>();
    	fruit.put("apple", apples);
    	fruit.put("peach", peaches);
    	fruit.put("pear", pears);
    	fruit.put("banana", bananas);
    	fruit.put("kiwi", kiwis);
    	fruit.put("grape", grapes);
    	fruit.put("other", others);
    	i.putExtra("whole_fruit", whole_fruit);
    	i.putExtra("smoothies", smoothie);
    	i.putExtra("mixed_bags", mixed_bag);
    	i.putExtra("total", whole_fruit+smoothie+mixed_bag);
    	
    	i.putExtra("gender", gender);
    	i.putExtra("fruit", fruit);
    	i.putExtra("grade", grade);
    	this.startActivity(i);
    }
    
}
