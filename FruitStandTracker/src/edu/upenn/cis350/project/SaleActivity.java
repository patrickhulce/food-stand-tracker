package edu.upenn.cis350.project;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
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
	int temp_whole_fruit = 0;
	
	int temp_smoothie = 0;
	int temp_mixed_bag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        data = getIntent().getExtras();
        
        setContentView(R.layout.activity_sale_person);
        TextView wholefruittext = (TextView)findViewById(R.id.whole_fruit_label);
        TextView smoothietext = (TextView)findViewById(R.id.smoothie_label);
        TextView bagtext = (TextView)findViewById(R.id.mixed_bag_label);
        wholefruittext.setText("x" + temp_whole_fruit);
        smoothietext.setText("x" + temp_smoothie);
        bagtext.setText("x" + temp_mixed_bag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
    public void whole_fruit_clicked(View view){
    	LinearLayout fruitview = (LinearLayout)findViewById(R.id.fruitchoice);
    	if(fruitview.getVisibility() == View.VISIBLE){
    		fruitview.setVisibility(View.GONE);
    	} else { fruitview.setVisibility(View.VISIBLE); }
    }
    
    public void updateWholeFruit(){
    	TextView text = (TextView)findViewById(R.id.whole_fruit_label);
    	temp_whole_fruit = apples+pears+bananas+kiwis+peaches+others+grapes;
    	text.setText("x" + temp_whole_fruit);
        Button submit_button = (Button)findViewById(R.id.button_continue);
    	if(gender != ""){
    		submit_button.setEnabled(true);
    	}
    }
    
    public void smoothie_clicked(View view){
    	TextView text = (TextView)findViewById(R.id.smoothie_label);
    	temp_smoothie += 1;
    	text.setText("x" + temp_smoothie);
        Button submit_button = (Button)findViewById(R.id.button_continue);
    	if(gender != ""){
    		submit_button.setEnabled(true);
    	}
    }
    
    public void mixed_bag_clicked(View view){
    	TextView text = (TextView)findViewById(R.id.mixed_bag_label);
    	temp_mixed_bag += 1;
    	text.setText("x" + temp_mixed_bag);
        Button submit_button = (Button)findViewById(R.id.button_continue);
    	if(gender != ""){
    		submit_button.setEnabled(true);
    	}
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
    	if(temp_whole_fruit+temp_smoothie+temp_mixed_bag > 0){
    		submit_button.setEnabled(true);
    	}
    }
    
    public void clear_entries(View view){
    	apples = 0;
    	pears = 0;
    	bananas = 0;
    	kiwis = 0;
    	peaches = 0;
    	grapes = 0;
    	others = 0;
    	temp_whole_fruit = 0;
       	temp_smoothie = 0;
    	temp_mixed_bag = 0;
    
    	int[] texts = {R.id.whole_fruit_label, R.id.apple_label,
    			R.id.peach_label, R.id.pear_label, R.id.kiwi_label,
    			R.id.banana_label, R.id.smoothie_label, R.id.mixed_bag_label,
    			R.id.other_label
    	};
    	for(int i: texts){
    		TextView text = (TextView)findViewById(i);
    		text.setText("x0");
    	}
    }
    
    public void go_to_checkout(View view){
    	Intent i = new Intent(this, PaymentActivity.class);
    	
    	Spinner age = (Spinner)findViewById(R.id.choosePerson);
    	String grade = (String)age.getSelectedItem();
    	
    	i.putExtras(data);
    	int tempapple = 0, temppeach = 0, temppear = 0, 
    			tempbanana = 0, tempkiwi = 0, tempgrape = 0, tempother = 0;
		HashMap<String, Integer> fruit = new HashMap<String, Integer>();
    	if(data.get("fruit") == null){
    		fruit = new HashMap<String, Integer>();	
    	} else {
    		fruit = (HashMap<String, Integer>) data.get("fruit");
    		tempapple = fruit.get("apple");
    		temppeach = fruit.get("peach");
    		temppear = fruit.get("pear");
    		tempbanana = fruit.get("banana");
    		tempkiwi = fruit.get("kiwi");
    		tempgrape = fruit.get("grape");
    		tempother = fruit.get("other");
    		
    	}
    	fruit.put("apple", apples+tempapple);
    	fruit.put("peach", peaches+temppeach);
    	fruit.put("pear", pears+temppear);
    	fruit.put("banana", bananas+tempbanana);
    	fruit.put("kiwi", kiwis+tempkiwi);
    	fruit.put("grape", grapes+tempgrape);
    	fruit.put("other", others+tempother);
    	
    	i.putExtra("whole_fruit", data.getInt("whole_fruit") + temp_whole_fruit);
    	i.putExtra("smoothies", data.getInt("smoothie") + temp_smoothie);
    	i.putExtra("mixed_bags", data.getInt("mixed_bag") + temp_mixed_bag);
    	i.putExtra("total", temp_whole_fruit+temp_smoothie+temp_mixed_bag);
    	i.putExtra("temp_whole_fruit", temp_whole_fruit);
    	i.putExtra("temp_smoothie", temp_smoothie);
    	i.putExtra("temp_mixed_bag", temp_mixed_bag);
    	
    	i.putExtra("gender", gender);
    	i.putExtra("fruit", fruit);
    	i.putExtra("grade", grade);
    	this.startActivity(i);
    }
    
}
