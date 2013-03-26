package edu.upenn.cis350.project;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Inventory2Activity extends Activity {

	Bundle data;
	
	int mixed = 0;
	int apples = 0;
	int pears = 0;
	int oranges = 0;
	int bananas = 0;
	int kiwis = 0;
	int grapes = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory2);
		data = getIntent().getExtras();
	    GridView gridview = (GridView) findViewById(R.id.Inventory2Grid);
	    gridview.setAdapter(new Inventory2ImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	switch(position) {
	        	case 0: mixed++;
        				TextView mixed_qty = (TextView) findViewById(R.id.mixed_qty);
        				mixed_qty.setText(Integer.toString(mixed));
        				break;	
	            case 1: apples++;
	            		TextView apples2_qty = (TextView) findViewById(R.id.apple2_qty);
	            		apples2_qty.setText(Integer.toString(apples));
	            		break;
	            case 2: pears++;
	            		TextView pears2_qty = (TextView) findViewById(R.id.pear2_qty);
	            		pears2_qty.setText(Integer.toString(pears));
	            		break;
	            case 3: oranges++;
        				TextView oranges2_qty = (TextView) findViewById(R.id.orange2_qty);
        				oranges2_qty.setText(Integer.toString(oranges));	            
	            		break;
	            case 4: grapes++;
						TextView grapes2_qty = (TextView) findViewById(R.id.grapes2_qty);
						grapes2_qty.setText(Integer.toString(grapes));	
        				break;
	            case 5: kiwis++;
						TextView kiwis2_qty = (TextView) findViewById(R.id.kiwi2_qty);
						kiwis2_qty.setText(Integer.toString(kiwis));	
						break;
	            case 6: bananas++;
						TextView bananas2_qty = (TextView) findViewById(R.id.banana2_qty);
						bananas2_qty.setText(Integer.toString(bananas));	
						break;
	            }
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
    	//TODO Use savePostInventory to save info
    	i.putExtras(data);
    	
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }
}
