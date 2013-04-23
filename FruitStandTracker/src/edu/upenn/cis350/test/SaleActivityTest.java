package edu.upenn.cis350.test;

import edu.upenn.cis350.project.SaleActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


public class SaleActivityTest extends ActivityInstrumentationTestCase2<SaleActivity> {
	
	private SaleActivity activity;
	private Button appleButton;
	private Button wholeFruit;
	private Button bananaButton;
	private Button grapeButton;
	private Button kiwiButton;
	private Button mixedButton;
	private Button smoothieButton;
	
	public SaleActivityTest() {
		super("edu.upenn.cis350.project",SaleActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		wholeFruit = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_button);
		appleButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.apples);
		bananaButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.bananas);
		grapeButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.grapes);
		kiwiButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.kiwis);
		mixedButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.mixed_bag_button);
		smoothieButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.smoothie_button);
		//act.data = new Bundle();
	}
	
	public void testUpdateWholeFruitSimple() {
		final int appleClicks = 10;
		final int bananaClicks = 5;
		final int grapeClicks = 2;
		int totalFruit = 17;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	wholeFruit.requestFocus();
			        	wholeFruit.performClick();
			        	appleButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.apples);
			        	appleButton.requestFocus();
			        	Log.i("got into", "apple");
			        	for(int i = 0; i < appleClicks; i++){
			    			appleButton.performClick();
			    		}
			    		bananaButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.bananas);
			        	bananaButton.requestFocus();
			        	Log.i("got into", "banana");
			        	for(int i = 0; i < bananaClicks; i++){
			        		bananaButton.performClick();
			        	}
			    		grapeButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.grapes);
			        	grapeButton.requestFocus();
			        	Log.i("got into", "grape");
			        	for(int i = 0; i < grapeClicks; i++){
			        		grapeButton.performClick();
			        	}
			        	activity.updateWholeFruit();
			        } 
			      } 
			    );
		assertEquals(appleClicks, activity.getApples());
		assertEquals(bananaClicks, activity.getBananas());
		assertEquals(grapeClicks, activity.getGrapes());
		assertEquals(totalFruit, activity.getWholeFruit());
		TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x17",text.getText());
	}
	

	
	public void testUpdateWholeFruitAdvancedFinished() {
		final int appleClicks = 10;
		final int bananaClicks = 5;
		final int grapeClicks = 2;
		final int kiwiClicks = 1;
		final int mixedBagClicks = 100;
		final int kiwiClicksTwo = 3;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	wholeFruit.requestFocus();
			        	wholeFruit.performClick();
			        	appleButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.apples);
			        	appleButton.requestFocus();
			        	for(int i = 0; i < appleClicks; i++){
			        		appleButton.performClick();
			        	}
			    		bananaButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.bananas);
			        	bananaButton.requestFocus();
			        	for(int i = 0; i < bananaClicks; i++){
			        		bananaButton.performClick();
			        	}
			    		grapeButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.grapes);
			        	grapeButton.requestFocus();
			        	for(int i = 0; i < grapeClicks; i++){
			        		grapeButton.performClick();
			        	}
			    		kiwiButton = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.kiwis);
			    		kiwiButton.requestFocus();
			    		for(int i = 0; i < kiwiClicks; i++){
			    			kiwiButton.performClick();
			    		}
			    		mixedButton.requestFocus();
			    		for(int i = 0; i < mixedBagClicks; i++){
			    			mixedButton.performClick();
			    		}
			    		kiwiButton.requestFocus();
			    		for(int i = 0; i < kiwiClicksTwo; i++){
			    			kiwiButton.performClick();
			    		}
			    		activity.updateWholeFruit();
			        }
			      }
		);
		assertEquals(21,activity.getWholeFruit());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x21",text.getText());
        Button submit_button = (Button) activity.findViewById(edu.upenn.cis350.project.R.id.button_continue);
        assertTrue(submit_button.isEnabled());
	}
	
	public void testSmoothieClicked() {
		final int smoothieClicks = 3;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	smoothieButton.requestFocus();
			        	Log.i("got to", "smoothies");
			        	for(int i = 0; i < smoothieClicks; i++){
			        		smoothieButton.performClick();
			        		Log.i("clicked a", "smoothie");
			        	}
			        }
			      }
		);
		assertEquals(3,activity.getSmoothies());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.smoothie_label);
    	assertEquals("x3",text.getText());
	}
	/*
	public void testMixedBagClicked() {
		act.temp_mixed_bag = 0;
		act.mixed_bag_clicked(null);
		act.mixed_bag_clicked(null);
		act.mixed_bag_clicked(null);
		assertEquals(3,act.temp_mixed_bag);
    	TextView text = (TextView) act.findViewById(R.id.mixed_bag_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testApplesButton() {
		act.apples = 0;
		act.apples_button(null);
		act.apples_button(null);
		act.apples_button(null);
		assertEquals(3,act.apples);
    	TextView text = (TextView) act.findViewById(R.id.apple_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testPeachesButton() {
		act.peaches = 0;
		act.peaches_button(null);
		act.peaches_button(null);
		act.peaches_button(null);
		assertEquals(3,act.peaches);
    	TextView text = (TextView) act.findViewById(R.id.peach_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testBananasButton() {
		act.bananas = 0;
		act.bananas_button(null);
		act.bananas_button(null);
		act.bananas_button(null);
		assertEquals(3,act.bananas);
    	TextView text = (TextView) act.findViewById(R.id.banana_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testGrapesButton() {
		act.grapes = 0;
		act.grapes_button(null);
		act.grapes_button(null);
		act.grapes_button(null);
		assertEquals(3,act.grapes);
    	TextView text = (TextView) act.findViewById(R.id.grape_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testKiwisButton() {
		act.kiwis = 0;
		act.kiwis_button(null);
		act.kiwis_button(null);
		act.kiwis_button(null);
		assertEquals(3,act.kiwis);
    	TextView text = (TextView) act.findViewById(R.id.kiwi_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testPearsButton() {
		act.pears = 0;
		act.pears_button(null);
		act.pears_button(null);
		act.pears_button(null);
		assertEquals(3,act.pears);
    	TextView text = (TextView) act.findViewById(R.id.pear_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testOthersButton() {
		act.others = 0;
		act.others_button(null);
		act.others_button(null);
		act.others_button(null);
		assertEquals(3,act.others);
    	TextView text = (TextView) act.findViewById(R.id.other_label);
    	assertEquals("x3",text.getText());
	}
*/
}
