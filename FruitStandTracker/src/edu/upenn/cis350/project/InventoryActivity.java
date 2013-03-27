package edu.upenn.cis350.project;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryActivity extends Activity {
	
	int apples = 0;
	int pears = 0;
	int oranges = 0;
	int bananas = 0;
	int kiwis = 0;
	int grapes = 0;
	int granola = 0;
	int smoothie = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory);
		
//	    GridView gridview = (GridView) findViewById(R.id.InventoryGrid);
//	    gridview.setAdapter(new InventoryImageAdapter(this));
//
//	    gridview.setOnItemClickListener(new OnItemClickListener() {
//	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//	            switch(position) {
//	            case 0: apples++;
//	            		TextView apples_qty = (TextView) findViewById(R.id.apple_qty);
//	            		apples_qty.setText(Integer.toString(apples));
//	            		break;
//	            case 1: pears++;
//	            		TextView pears_qty = (TextView) findViewById(R.id.pear_qty);
//	            		pears_qty.setText(Integer.toString(pears));
//	            		break;
//	            case 2: oranges++;
//        				TextView oranges_qty = (TextView) findViewById(R.id.orange_qty);
//        				oranges_qty.setText(Integer.toString(oranges));	            
//	            		break;
//	            case 3: grapes++;
//						TextView grapes_qty = (TextView) findViewById(R.id.grapes_qty);
//						grapes_qty.setText(Integer.toString(grapes));	
//        				break;
//	            case 4: kiwis++;
//						TextView kiwis_qty = (TextView) findViewById(R.id.kiwi_qty);
//						kiwis_qty.setText(Integer.toString(kiwis));	
//						break;
//	            case 5: bananas++;
//						TextView bananas_qty = (TextView) findViewById(R.id.banana_qty);
//						bananas_qty.setText(Integer.toString(bananas));	
//						break;
//	            case 6: granola++;
//						TextView granolas_qty = (TextView) findViewById(R.id.granola_qty);
//						granolas_qty.setText(Integer.toString(granola));	
//	            		break;
//	            case 7: smoothie++;
//						TextView smoothies_qty = (TextView) findViewById(R.id.smoothie_qty);
//						smoothies_qty.setText(Integer.toString(smoothie));	
//	            		break;
//	            }
//	            
//	            
//	        }
//	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inventory, menu);
		return true;
	}
	
	public void continueToInventory2(View v) {
    	//Launch to weather
    	Intent i = new Intent(this, Inventory2Activity.class);
    	//Save our info
    	//TODO Use savePreInventory() to save info
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }

}
