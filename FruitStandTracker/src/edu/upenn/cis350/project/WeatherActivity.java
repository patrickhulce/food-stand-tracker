package edu.upenn.cis350.project;

import java.util.HashMap;
import java.util.Map;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class WeatherActivity extends Activity {
	SeekBar seekBar;
	String w = "sunny";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);
		
		seekBar = (SeekBar) findViewById(R.id.temp_bar);
		seekBar.setProgress(50);
		seekBar.incrementProgressBy(1);
		seekBar.setMax(100);
		final TextView seekBarValue = (TextView) findViewById(R.id.temp_reading);
		seekBarValue.setText("Temperature: 50°F");

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

		    @Override
		    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		        seekBarValue.setText("Temperature: " + String.valueOf(progress) + "F");
		    }

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Don't do anything
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Don't do anything
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_weather, menu);
		return true;
	}
	
	public void setWeather(View v) {
		switch(v.getId()) {
		case R.id.sunny:
			w = "sunny";
			break;
		case R.id.rainy:
			w = "rainy";
			break;
		case R.id.partly_cloudy:
			w = "partly cloudy";
			break;
		case R.id.snowy:
			w = "snowy";
			break;
		}
	}

	public void continueToPricing(View v) {
    	//Launch to inventory
    	Intent i = new Intent(this, PricingActivity.class);
    	
    	//Cashbox amount
    	EditText cshbx = (EditText) findViewById(R.id.cashbox_starting);
    	String amt = cshbx.getText().toString();
    	
    	//Save our info
    	if(w != null && amt != null && amt.length() > 1) {
            DataBaser db = DataBaser.getInstance();
            db.addInfo("weather", w);
            db.addInfo("temperature", String.valueOf(seekBar.getProgress()));
            db.addInfo("cashbox_amount", amt);
        	this.startActivity(i);
    	}
	}
}
