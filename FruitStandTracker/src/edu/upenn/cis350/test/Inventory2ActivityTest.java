package edu.upenn.cis350.test;

import edu.upenn.cis350.project.R;
import android.os.Bundle;
import edu.upenn.cis350.project.Inventory2Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class Inventory2ActivityTest extends ActivityInstrumentationTestCase2<Inventory2Activity>{
	protected Inventory2Activity act;
	private Button apple2Plus;
	private Button apple2Minus;
	protected EditText apple2Qty;
    
	public Inventory2ActivityTest() {
		super("edu.upenn.cis350.project",Inventory2Activity.class);
	}
    
	protected void setUp() throws Exception {
		super.setUp();
		act = getActivity();
		apple2Plus = (Button) act.findViewById(R.id.apple2Plus);
		apple2Minus = (Button) act.findViewById(R.id.apple2Minus);
		apple2Qty = (EditText) act.findViewById(R.id.apple2Qty);
	}
    
	public void testPlus() {
		act.runOnUiThread(new Runnable() {
			public void run() {
				apple2Plus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(1,act.getQty(R.id.apple2Qty));
	}
	
	public void testMinus() {
		act.runOnUiThread(new Runnable() {
			public void run() {
				apple2Minus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(0,act.getQty(R.id.apple2Qty));
	}
	
	public void testTypeMinus() {
		assertNotNull(apple2Qty);
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				apple2Qty.requestFocus();
				sendKeys("5");
				apple2Minus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(4,act.getQty(R.id.apple2Qty));
	}
	
	public void testTypePlus() {
		assertNotNull(apple2Qty);
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				apple2Qty.requestFocus();
				sendKeys("9");
				apple2Plus.performClick();
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(10,act.getQty(R.id.apple2Qty));
	}
	
}
