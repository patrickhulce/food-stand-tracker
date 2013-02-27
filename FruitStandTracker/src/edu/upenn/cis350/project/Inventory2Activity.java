package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Inventory2Activity extends Activity {

	Bundle data;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory2);
		data = getIntent().getExtras();
	    GridView gridview = (GridView) findViewById(R.id.InventoryGrid);
	    gridview.setAdapter(new InventoryImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(Inventory2Activity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inventory2, menu);
		return true;
	}

    public void continueToSales(View v) {
    	//Launch to weather
    	Intent i = new Intent(this, SaleActivity.class);
    	//Save our info
    	i.putExtra("whole_fruit", 0);
    	i.putExtra("smoothies", 0);
    	i.putExtra("mixed_bags", 0);
    	i.putExtra("transactions", 0);
    	i.putExtra("total", 0);
    	
    	i.putExtras(data);
    	
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }
}
