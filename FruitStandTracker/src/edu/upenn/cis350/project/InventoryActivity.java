package edu.upenn.cis350.project;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
	int frozen = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inventory);

	}
	
	public void applePlus (View view) {
		EditText appleQty = (EditText) findViewById(R.id.appleQty);
		Editable qty_e = appleQty.getText();
		if (qty_e != null) {
			apples = Integer.parseInt(appleQty.getText().toString());
		} else {
			apples = 0;
		}
		apples++;
		appleQty.setText(apples);
	}
	
	public void appleMinus (View view) {
		EditText appleQty = (EditText) findViewById(R.id.appleQty);
		apples = Integer.parseInt(appleQty.getText().toString());
		appleQty.setText(apples--);
	}
	
	public void bananaPlus (View view) {
		EditText bananaQty = (EditText) findViewById(R.id.bananaQty);
		bananas = Integer.parseInt(bananaQty.getText().toString());
		bananaQty.setText(bananas++);
	}
	
	public void bananaMinus (View view) {
		EditText bananaQty = (EditText) findViewById(R.id.bananaQty);
		bananas = Integer.parseInt(bananaQty.getText().toString());
		bananaQty.setText(bananas--);
	}
	
	public void grapesPlus (View view) {
		EditText grapesQty = (EditText) findViewById(R.id.grapesQty);
		grapes = Integer.parseInt(grapesQty.getText().toString());
		grapesQty.setText(grapes++);
	}
	
	public void grapesMinus (View view) {
		EditText grapesQty = (EditText) findViewById(R.id.grapesQty);
		grapes = Integer.parseInt(grapesQty.getText().toString());
		grapesQty.setText(grapes--);
	}
	
	public void kiwiPlus (View view) {
		EditText kiwiQty = (EditText) findViewById(R.id.kiwiQty);
		kiwis = Integer.parseInt(kiwiQty.getText().toString());
		kiwiQty.setText(kiwis++);
	}
	
	public void kiwiMinus (View view) {
		EditText kiwiQty = (EditText) findViewById(R.id.kiwiQty);
		kiwis = Integer.parseInt(kiwiQty.getText().toString());
		kiwiQty.setText(kiwis--);
	}
	
	public void orangePlus (View view) {
		EditText orangeQty = (EditText) findViewById(R.id.orangeQty);
		oranges = Integer.parseInt(orangeQty.getText().toString());
		orangeQty.setText(oranges++);
	}
	
	public void orangeMinus (View view) {
		EditText orangeQty = (EditText) findViewById(R.id.orangeQty);
		oranges = Integer.parseInt(orangeQty.getText().toString());
		orangeQty.setText(oranges--);
	}
	
	public void pearPlus (View view) {
		EditText pearQty = (EditText) findViewById(R.id.pearQty);
		pears = Integer.parseInt(pearQty.getText().toString());
		pearQty.setText(pears++);
	}
	
	public void pearMinus (View view) {
		EditText pearQty = (EditText) findViewById(R.id.pearQty);
		pears = Integer.parseInt(pearQty.getText().toString());
		pearQty.setText(pears--);
	}
	
	public void granolaPlus (View view) {
		EditText granolaQty = (EditText) findViewById(R.id.granolaQty);
		granola = Integer.parseInt(granolaQty.getText().toString());
		granolaQty.setText(granola++);
	}
	
	public void granolaMinus (View view) {
		EditText granolaQty = (EditText) findViewById(R.id.granolaQty);
		granola = Integer.parseInt(granolaQty.getText().toString());
		granolaQty.setText(granola--);
	}
	
	public void frozenPlus (View view) {
		EditText frozenQty = (EditText) findViewById(R.id.frozenQty);
		frozen = Integer.parseInt(frozenQty.getText().toString());
		frozenQty.setText(frozen++);
	}
	
	public void frozenMinus (View view) {
		EditText frozenQty = (EditText) findViewById(R.id.frozenQty);
		frozen = Integer.parseInt(frozenQty.getText().toString());
		frozenQty.setText(frozen--);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inventory, menu);
		return true;
	}
	
	public void continueToInventory2(View v) {
    	//Launch to inventory2
    	Intent i = new Intent(this, Inventory2Activity.class);
    	//Save our info
    	//TODO Use savePreInventory() to save info
    	this.startActivity(i);
    }

}
