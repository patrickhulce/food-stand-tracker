package edu.upenn.cis350.project.test;

import android.test.ActivityInstrumentationTestCase2;
import edu.upenn.cis350.project.SaleActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SaleActivityTest extends ActivityInstrumentationTestCase2<SaleActivity>{
	
	SaleActivity act;
	
	public SaleActivityTest() {
		super("edu.upenn.cis350.project",SaleActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		act = getActivity();
		act.data = new Bundle();
	}
	
	public void testUpdateWholeFruitSimple() {
		act.apples = 10;
		act.bananas = 5;
		act.grapes = 2;
		act.updateWholeFruit();
		assertEquals(17,act.temp_whole_fruit);
	}
	
	public void testUpdateWholeFruitAdvanced() {
		act.apples = 10;
		act.bananas = 5;
		act.grapes = 2;
		act.updateWholeFruit();
		assertEquals(17,act.temp_whole_fruit);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x17",text.getText());
	}
	
	public void testUpdateWholeFruitAdvancedFinished() {
		act.apples = 10;
		act.bananas = 5;
		act.grapes = 2;
		act.kiwis = 1;
		act.temp_mixed_bag = 100;
		act.kiwis = 3;
		act.gender = "M";
		act.updateWholeFruit();
		assertEquals(21,act.temp_whole_fruit);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.whole_fruit_label);
    	assertEquals("x21",text.getText());
        Button submit_button = (Button) act.findViewById(edu.upenn.cis350.project.R.id.button_continue);
        assertTrue(submit_button.isEnabled());
	}
	
	public void testSmoothieClicked() {
		act.temp_smoothie = 0;
		act.smoothie_clicked(null);
		act.smoothie_clicked(null);
		act.smoothie_clicked(null);
		assertEquals(3,act.temp_smoothie);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.smoothie_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testMixedBagClicked() {
		act.temp_mixed_bag = 0;
		act.mixed_bag_clicked(null);
		act.mixed_bag_clicked(null);
		act.mixed_bag_clicked(null);
		assertEquals(3,act.temp_mixed_bag);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.mixed_bag_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testApplesButton() {
		act.apples = 0;
		act.apples_button(null);
		act.apples_button(null);
		act.apples_button(null);
		assertEquals(3,act.apples);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.apple_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testPeachesButton() {
		act.peaches = 0;
		act.peaches_button(null);
		act.peaches_button(null);
		act.peaches_button(null);
		assertEquals(3,act.peaches);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.peach_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testBananasButton() {
		act.bananas = 0;
		act.bananas_button(null);
		act.bananas_button(null);
		act.bananas_button(null);
		assertEquals(3,act.bananas);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.banana_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testGrapesButton() {
		act.grapes = 0;
		act.grapes_button(null);
		act.grapes_button(null);
		act.grapes_button(null);
		assertEquals(3,act.grapes);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.grape_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testKiwisButton() {
		act.kiwis = 0;
		act.kiwis_button(null);
		act.kiwis_button(null);
		act.kiwis_button(null);
		assertEquals(3,act.kiwis);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.kiwi_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testPearsButton() {
		act.pears = 0;
		act.pears_button(null);
		act.pears_button(null);
		act.pears_button(null);
		assertEquals(3,act.pears);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.pear_label);
    	assertEquals("x3",text.getText());
	}
	
	public void testOthersButton() {
		act.others = 0;
		act.others_button(null);
		act.others_button(null);
		act.others_button(null);
		assertEquals(3,act.others);
    	TextView text = (TextView) act.findViewById(edu.upenn.cis350.project.R.id.other_label);
    	assertEquals("x3",text.getText());
	}
	
}
