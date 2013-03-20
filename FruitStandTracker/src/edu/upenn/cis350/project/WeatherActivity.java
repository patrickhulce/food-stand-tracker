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
import android.widget.SeekBar;
import android.widget.TextView;

public class WeatherActivity extends Activity {
	Bundle data;
	SeekBar seekBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent i = getIntent();
		data = i.getExtras();
		setContentView(R.layout.activity_weather);
		
		seekBar = (SeekBar) findViewById(R.id.temp_bar);
		seekBar.setProgress(50);
		seekBar.incrementProgressBy(1);
		seekBar.setMax(100);
		final TextView seekBarValue = (TextView) findViewById(R.id.temp_reading);
		seekBarValue.setText("Temperature: 50");

		seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

		    @Override
		    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		        seekBarValue.setText("Temperature: " + String.valueOf(progress));
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
        DataBaser db = DataBaser.getInstance();
        Map<String,Object> record = new HashMap<String,Object>();
        record.put("shizzle", "coolio");
        record.put("key", "val");
        db.databaseItThoroughly("foo",record);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_weather, menu);
		return true;
	}

	public void continueToInventory(View v) {
    	//Launch to inventory
    	Intent i = new Intent(this, InventoryActivity.class);
    	//Save our info
    	i.putExtra("data", data);
    	this.startActivity(i);
	}
}
