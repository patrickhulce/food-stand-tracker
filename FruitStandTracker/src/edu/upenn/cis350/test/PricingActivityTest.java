package edu.upenn.cis350.test;

import edu.upenn.cis350.project.R;
import android.os.Bundle;
import edu.upenn.cis350.project.PricingActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class PricingActivityTest extends ActivityInstrumentationTestCase2<PricingActivity>{
	PricingActivity act;
	EditText granolaPrice;
	
	public PricingActivityTest() {
		super("edu.upenn.cis350.project", PricingActivity.class);
	}
    
	protected void setUp() throws Exception {
		super.setUp();
	
		granolaPrice = (EditText) act.findViewById(R.id.granolaPrice);
	}
	
	public void testPrice() {
		assertNotNull(granolaPrice);
		
		act.runOnUiThread(new Runnable() {
			public void run() {
				granolaPrice.requestFocus();
				
				// clear default price with four backspaces
				for (int i=0; i<4; i++){
					sendKeys(10);
				}
				
				// new price = 1.00
				sendKeys(61);
				sendKeys(56);
				sendKeys(60);
				sendKeys(60);
			}
		});
		getInstrumentation().waitForIdleSync();
		
		assertEquals(1.00,act.getPrice(R.id.apple2Qty));
	}

}
