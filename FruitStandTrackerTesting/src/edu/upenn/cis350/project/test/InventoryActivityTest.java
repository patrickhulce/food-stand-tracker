package edu.upenn.cis350.project.test;

import org.junit.Test;

import edu.upenn.cis350.project.R;
import android.os.Bundle;
import edu.upenn.cis350.project.InventoryActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class InventoryActivityTest extends ActivityInstrumentationTestCase2<InventoryActivity>{
	protected InventoryActivity act;
	private Button applePlus;
	private Button appleMinus;
	protected EditText appleQty;
    
	public InventoryActivityTest() {
		super("edu.upenn.cis350.project",InventoryActivity.class);
	}
    
	protected void setUp() throws Exception {
		super.setUp();
		act = getActivity();
		applePlus = (Button) act.findViewById(R.id.applePlus);
		appleMinus = (Button) act.findViewById(R.id.appleMinus);
		appleQty = (EditText) act.findViewById(R.id.appleQty);
	}
    
	public void testPlus() {
		act.runOnUiThread(new Runnable() {
			public void run() {
				applePlus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(1,act.getQty(R.id.appleQty));
	}
	
	public void testMinus() {
		act.runOnUiThread(new Runnable() {
			public void run() {
				appleMinus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(0,act.getQty(R.id.appleQty));
	}
	
	public void testTypeMinus() {
		assertNotNull(appleQty);
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				appleQty.requestFocus();
				sendKeys("5");
				appleMinus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(4,act.getQty(R.id.appleQty));
	}
	
	public void testTypePlus() {
		assertNotNull(appleQty);
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				appleQty.requestFocus();
				sendKeys("9 9");
				applePlus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(99,act.getQty(R.id.appleQty));
	}
	
	public void testBlank() {
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				appleMinus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(0,act.getQty(R.id.appleQty));
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				applePlus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(1,act.getQty(R.id.appleQty));
	}
	
	
	
}
