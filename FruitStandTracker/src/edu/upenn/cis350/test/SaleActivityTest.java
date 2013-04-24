package edu.upenn.cis350.test;

import edu.upenn.cis350.project.SaleActivity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;


public class SaleActivityTest extends ActivityInstrumentationTestCase2<SaleActivity> {
	
	private SaleActivity activity;
	Instrumentation myIns;

	
	public SaleActivityTest() {
		super("edu.upenn.cis350.project",SaleActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		myIns = getInstrumentation();
	}
	
	protected void tearDown() throws Exception{
		super.tearDown();
		activity = null;
	}
	
	public void testUpdateWholeFruitSimple() {
		final int appleClicks = 10;
		final int bananaClicks = 5;
		final int grapeClicks = 2;
		final int totalFruit = 17;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	activity.whole_fruit_clicked(null);
			        	for(int i = 0; i < appleClicks; i++){
			        		activity.apples_button(null);
			        	}
			        	for(int i = 0; i < bananaClicks; i++){
			        		activity.bananas_button(null);
			        	}
			        	for(int i = 0; i < grapeClicks; i++){
			        		activity.grapes_button(null);
			        	}
			        } 
			      } 
			    );
		myIns.waitForIdleSync();
		
		assertEquals(grapeClicks, activity.getGrapes());
    	assertEquals(bananaClicks, activity.getBananas());
		assertEquals(totalFruit, activity.getWholeFruit());
		assertEquals(appleClicks, activity.getApples());
		TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x" + "" + Integer.toString(totalFruit),text.getText());
	}
	

	
	public void testUpdateWholeFruitAdvancedFinished() {
		final int appleClicks = 10;
		final int bananaClicks = 5;
		final int grapeClicks = 2;
		final int kiwiClicks = 1;
		final int mixedBagClicks = 100;
		final int kiwiClicksTwo = 3;
		int totalFruit = appleClicks + bananaClicks + grapeClicks + kiwiClicks + kiwiClicksTwo;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	activity.whole_fruit_clicked(null);
			        	for(int i = 0; i < appleClicks; i++){
			        		activity.apples_button(null);
			        	}
			        	for(int i = 0; i < bananaClicks; i++){
			        		activity.bananas_button(null);
			        	}
			        	for(int i = 0; i < grapeClicks; i++){
			        		activity.grapes_button(null);
			        	}
			    		for(int i = 0; i < kiwiClicks; i++){
			    			activity.kiwis_button(null);
			    		}
			    		for(int i = 0; i < mixedBagClicks; i++){
			    			activity.mixed_bag_clicked(null);
			    		}
			    		for(int i = 0; i < kiwiClicksTwo; i++){
			    			activity.kiwis_button(null);
			    		}
			    		Button gender = (Button)activity.findViewById(edu.upenn.cis350.project.R.id.girls);
			    		gender.requestFocus();
			    		gender.performClick();
			        }
			      }
		);
		myIns.waitForIdleSync();
		assertEquals(21,activity.getWholeFruit());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x" + "" + Integer.toString(totalFruit),text.getText());
    	assertEquals("F", activity.getGender());
        Button submit_button = (Button) activity.findViewById(edu.upenn.cis350.project.R.id.button_continue);       
        assertTrue(submit_button.isEnabled());
	}
	
	public void testSmoothieClicked() {
		final int smoothieClicks = 3;
		activity.runOnUiThread(
			      new Runnable() {
			        public void run() {
			        	for(int i = 0; i < smoothieClicks; i++){
			        		activity.smoothie_clicked(null);
			        	}
			        }
			      }
		);
		myIns.waitForIdleSync();
		assertEquals(3,activity.getSmoothies());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.smoothie_label);
    	assertEquals("x" + "" + Integer.toString(smoothieClicks),text.getText());
	}
	
	public void testMixedBagClicked() {
		final int bagClicks = 3;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < bagClicks; i++){
							activity.mixed_bag_clicked(null);
						}
					}
				}
		);
		myIns.waitForIdleSync();
		assertEquals(3,activity.getMixedBags());
		TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.mixed_bag_label);
		assertEquals("x" + "" + Integer.toString(bagClicks),text.getText());
	}
	
	public void testApplesButton() {
		final int appleClicks = 3;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < appleClicks; i++){
							activity.apples_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(appleClicks,activity.getApples());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.apple_label);
    	assertEquals("x" + "" + Integer.toString(appleClicks),text.getText());
	}
	
	public void testOrangesButton() {
		final int orangeClicks = 3;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < orangeClicks; i++){
							activity.oranges_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(orangeClicks,activity.getOranges());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.orange_label);
    	assertEquals("x" + "" + Integer.toString(orangeClicks),text.getText());
	}
	
	public void testBananasButton() {
		final int bananaClicks = 5;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < bananaClicks; i++){
							activity.bananas_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(bananaClicks,activity.getBananas());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.banana_label);
    	assertEquals("x" + "" + Integer.toString(bananaClicks),text.getText());
	}
	
	public void testGrapesButton() {
		final int grapeClicks = 27;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < grapeClicks; i++){
							activity.grapes_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(grapeClicks,activity.getGrapes());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.grape_label);
    	assertEquals("x" + "" + Integer.toString(grapeClicks),text.getText());
	}
	
	public void testKiwisButton() {
		final int kiwiClicks = 8;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < kiwiClicks; i++){
							activity.kiwis_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(kiwiClicks,activity.getKiwis());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.kiwi_label);
    	assertEquals("x" + "" + Integer.toString(kiwiClicks),text.getText());
	}
	
	public void testPearsButton() {
		final int pearClicks = 21;
		activity.runOnUiThread(
				new Runnable(){
					public void run(){
						for(int i = 0; i < pearClicks; i++){
							activity.pears_button(null);
						}
					}
				}
			);
		myIns.waitForIdleSync();
		assertEquals(pearClicks,activity.getPears());
    	TextView text = (TextView) activity.findViewById(edu.upenn.cis350.project.R.id.pear_label);
    	assertEquals("x" + "" + Integer.toString(pearClicks),text.getText());
	}

}
