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
 
	private Bundle data;
	
	private String gender = "";
	
	private int apples = 0;
	private int pears = 0;
	private int bananas = 0;
	private int kiwis = 0;
	private int oranges = 0;
	private int grapes = 0;
	private int temp_whole_fruit = 0;
	private int temp_granola = 0;
	private int temp_smoothie = 0;
	private int temp_mixed_bag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        data = getIntent().getExtras();
        
        setContentView(R.layout.activity_sale_person);
        TextView wholefruittext = (TextView)findViewById(R.id.whole_fruit_label);
        TextView smoothietext = (TextView)findViewById(R.id.smoothie_label);
        TextView bagtext = (TextView)findViewById(R.id.mixed_bag_label);
        TextView granolatext = (TextView)findViewById(R.id.granola_label);
        
        Button apple_button = (Button)findViewById(R.id.apples);
        Button orange_button = (Button)findViewById(R.id.oranges);
        Button pear_button = (Button)findViewById(R.id.pears);
        Button kiwi_button = (Button)findViewById(R.id.kiwis);
        Button grape_button = (Button)findViewById(R.id.grapes);
        Button banana_button = (Button)findViewById(R.id.bananas);
        Button smoothie_button = (Button)findViewById(R.id.smoothie_button);
        Button mixed_bag_button = (Button)findViewById(R.id.mixed_bag_button);
        Button granola_button = (Button)findViewById(R.id.granola_button);
    	TextView apple_text = (TextView)findViewById(R.id.apple_label);
    	TextView orange_text = (TextView)findViewById(R.id.orange_label);
    	TextView pear_text = (TextView)findViewById(R.id.pear_label);
    	TextView kiwi_text = (TextView)findViewById(R.id.kiwi_label);
    	TextView grape_text = (TextView)findViewById(R.id.grape_label);
    	TextView banana_text = (TextView)findViewById(R.id.banana_label);
    	TextView smoothie_text = (TextView)findViewById(R.id.smoothie_label);
    	TextView mixed_bag_text = (TextView)findViewById(R.id.mixed_bag_label);
    	TextView granola_text = (TextView)findViewById(R.id.granola_label);
        
    	HashMap<String, Integer> inv = DataBaser.getInstance().inventory2;
    	if(inv.get("apples") == 0){
    		apple_button.setVisibility(8);
    		apple_text.setVisibility(8);
    	}
    	if(inv.get("oranges") == 0){
    		orange_button.setVisibility(8);
    		orange_text.setVisibility(8);
    	}
    	if(inv.get("pears") == 0){
    		pear_button.setVisibility(8);
    		pear_text.setVisibility(8);
    	}
    	if(inv.get("kiwis") == 0){
    		kiwi_button.setVisibility(8);
    		kiwi_text.setVisibility(8);
    	}
    	if(inv.get("grapes") == 0){
    		grape_button.setVisibility(8);
    		grape_text.setVisibility(8);
    	}
    	if(inv.get("bananas") == 0){
    		banana_button.setVisibility(8);
    		banana_text.setVisibility(8);
    	}
    	if(inv.get("smoothie") == 0){
    		smoothie_button.setVisibility(8);
    		smoothie_text.setVisibility(8);
    	}
    	if(inv.get("mixed") == 0){
    		mixed_bag_button.setVisibility(8);
    		mixed_bag_text.setVisibility(8);
    	}
    	if(inv.get("granolas") == 0){
    		granola_button.setVisibility(8);
    		granola_text.setVisibility(8);
    	}
        
        wholefruittext.setText("x" + temp_whole_fruit);
        smoothietext.setText("x" + temp_smoothie);
        bagtext.setText("x" + temp_mixed_bag);
        granolatext.setText("x" + temp_granola);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
    //method to expand button menu of the app -> show the fruit
    public void whole_fruit_clicked(View view){
    	LinearLayout fruitview = (LinearLayout)findViewById(R.id.fruitchoice);
    	if(fruitview.getVisibility() == View.VISIBLE){
    		fruitview.setVisibility(View.GONE);
    	} else { fruitview.setVisibility(View.VISIBLE); }
    }
    
    //called by other methods in this class
    private void updateWholeFruit(){
    	TextView text = (TextView)findViewById(R.id.whole_fruit_label);
    	temp_whole_fruit = apples+pears+bananas+kiwis+oranges+grapes;
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

    public void granola_clicked(View view){
    	TextView text = (TextView)findViewById(R.id.granola_label);
    	temp_granola += 1;
    	text.setText("x" + temp_granola);
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
    public void oranges_button(View view){
    	TextView text = (TextView)findViewById(R.id.orange_label);
    	oranges += 1;
    	text.setText("x"+oranges);
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
    	oranges = 0;
    	grapes = 0;
    	temp_whole_fruit = 0;
    	temp_granola = 0;
       	temp_smoothie = 0;
    	temp_mixed_bag = 0;
    	
    
    	int[] texts = {R.id.whole_fruit_label, R.id.apple_label,
    			R.id.orange_label, R.id.pear_label, R.id.kiwi_label,
    			R.id.banana_label, R.id.smoothie_label, R.id.mixed_bag_label,R.id.granola_label,
    	};
    	for(int i: texts){
    		TextView text = (TextView)findViewById(i);
    		text.setText("x0");
    	}
    }
    
    
    /******Getter Methods for Testing********/
    public int getApples(){
    	return apples;
    }
    
    public int getPears(){
    	return pears;
    }
    
    public int getBananas(){
    	return bananas;
    }
    
    public int getKiwis(){
    	return kiwis;
    }
    
    public int getOranges(){
    	return oranges;
    }
    
    public int getGrapes(){
    	return grapes;
    }
    
    public int getWholeFruit(){
    	return temp_whole_fruit;
    }
    
    public int getGranola(){
    	return temp_granola;
    }
    
    public int getSmoothies(){
    	return temp_smoothie;
    }
    
    public int getMixedBags(){
    	return temp_mixed_bag;
    }
    
    public String getGender(){
    	return gender;
    }
    
    
    
    
    
    public void go_to_checkout(View view){
    	Intent i = new Intent(this, PaymentActivity.class);
    	
    	Spinner age = (Spinner)findViewById(R.id.choosePerson);
    	String grade = (String)age.getSelectedItem();
    	
    	i.putExtras(data);
    	int tempapple = 0, temporange = 0, temppear = 0, 
    			tempbanana = 0, tempkiwi = 0, tempgrape = 0;
		HashMap<String, Integer> fruit = new HashMap<String, Integer>();
    	if(data.get("fruit") == null){
    		fruit = new HashMap<String, Integer>();	
    	} else {
    		fruit = (HashMap<String, Integer>) data.get("fruit");
    		tempapple = fruit.get("apple");
    		temporange = fruit.get("orange");
    		temppear = fruit.get("pear");
    		tempbanana = fruit.get("banana");
    		tempkiwi = fruit.get("kiwi");
    		tempgrape = fruit.get("grape");
    	}
    	fruit.put("apple", apples+tempapple);
    	fruit.put("orange", oranges+temporange);
    	fruit.put("pear", pears+temppear);
    	fruit.put("banana", bananas+tempbanana);
    	fruit.put("kiwi", kiwis+tempkiwi);
    	fruit.put("grape", grapes+tempgrape);
    	
    	i.putExtra("whole_fruit", data.getInt("whole_fruit") + temp_whole_fruit);
    	i.putExtra("smoothies", data.getInt("smoothies") + temp_smoothie);
    	i.putExtra("mixed_bags", data.getInt("mixed_bag") + temp_mixed_bag);
    	i.putExtra("granolabars", data.getInt("granola") + temp_granola);
    	i.putExtra("total", temp_whole_fruit+temp_smoothie+temp_mixed_bag+temp_granola);
    	i.putExtra("temp_whole_fruit", temp_whole_fruit);
    	i.putExtra("temp_apples", apples);
    	i.putExtra("temp_oranges", oranges);
    	i.putExtra("temp_pears", pears);
    	i.putExtra("temp_kiwis", kiwis);
    	i.putExtra("temp_grapes", grapes);
    	i.putExtra("temp_bananas", bananas);
    	i.putExtra("temp_smoothie", temp_smoothie);
    	i.putExtra("temp_mixed_bag", temp_mixed_bag);
    	i.putExtra("temp_granola", temp_granola);
    	
    	i.putExtra("gender", gender);
    	i.putExtra("fruit", fruit);
    	i.putExtra("grade", grade);
    	this.startActivity(i);
    }
    
}
