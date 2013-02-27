package edu.upenn.cis350.project;

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
import android.widget.Toast;

public class InventoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory);
		
	    GridView gridview = (GridView) findViewById(R.id.InventoryGrid);
	    gridview.setAdapter(new InventoryImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(InventoryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
	        }
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inventory, menu);
		return true;
	}
	
//	@Override
//	public void onCreateContextMenu(ContextMenu menu, View v,
//	                                ContextMenuInfo menuInfo) {
//	    super.onCreateContextMenu(menu, v, menuInfo);
//	    MenuInflater inflater = getMenuInflater();
//	    inflater.inflate(R.menu.context_menu, menu);
//	}
//	
//	@Override
//	public boolean onContextItemSelected(MenuItem item) {
//	    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
//	    switch (item.getItemId()) {
//	        case R.id.edit:
//	            editNote(info.id);
//	            return true;
//	        case R.id.delete:
//	            deleteNote(info.id);
//	            return true;
//	        default:
//	            return super.onContextItemSelected(item);
//	    }
//	}
	
	public void continueToInventory2(View v) {
    	//Launch to weather
    	Intent i = new Intent(this, Inventory2Activity.class);
    	//Save our info
    	i.putExtra("herma", "derp");
    	this.startActivity(i);
    }

}
