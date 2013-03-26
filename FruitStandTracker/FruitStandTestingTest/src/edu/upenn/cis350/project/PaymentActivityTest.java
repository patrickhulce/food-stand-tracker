package edu.upenn.cis350.project;

import edu.upenn.cis350.project.PaymentActivity;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.TextView;

public class PaymentActivityTest extends
		ActivityInstrumentationTestCase2<PaymentActivity> {
	PaymentActivity act;

	public PaymentActivityTest() {
		super("edu.upenn.cis350.project",PaymentActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		act = getActivity();
		act.data = new Bundle();
	}
	
	public void testUpdateItemsSimple() {
		act.cash = 3;
		act.junk_food = 2;
		act.coupons = 0;
		act.updateItems();
		assertEquals(5,act.checked_out);
	}
	
	public void testUpdateItemsAdvanced() {
		act.cash = 5;
		act.junk_food = 1;
		act.coupons = 3;
		act.updateItems();
		assertEquals(9,act.checked_out);
		Button submit = (Button) act.findViewById(R.id.submit);
		assertTrue(submit.isEnabled());
    	TextView items = (TextView) act.findViewById(R.id.items);
        assertEquals("Number of Items to Checkout:\n0",items.getText());
	}
	
	public void testCashButtonSimple() {
		act.total = 3;
		act.cash_button(null);
		assertEquals(1,act.cash);
	}
	
	public void testCashButtonSimple2() {
		act.total = 3;
		act.cash_button(null);
		act.cash_button(null);
		assertEquals(2,act.cash);
	}
	
	public void testCashButtonEdge() {
		act.total = 3;
		act.cash_button(null);
		act.cash_button(null);
		act.cash_button(null);
		assertEquals(3,act.cash);
	}
	
	public void testCouponButtonSimple() {
		act.total = 3;
		act.coupon_button(null);
		assertEquals(1,act.coupons);
	}
	
	public void testCouponButtonSimple2() {
		act.total = 3;
		act.coupon_button(null);
		act.coupon_button(null);
		assertEquals(2,act.coupons);
	}
	
	public void testCouponButtonEdge() {
		act.total = 3;
		act.coupon_button(null);
		act.coupon_button(null);
		act.coupon_button(null);
		assertEquals(3,act.coupons);
	}
	
	public void testJunkFoodButtonSimple() {
		act.total = 3;
		act.junk_food_button(null);
		assertEquals(1,act.junk_food);
	}
	
	public void testJunkFoodButtonSimple2() {
		act.total = 3;
		act.junk_food_button(null);
		act.junk_food_button(null);
		assertEquals(2,act.junk_food);
	}
	
	public void testJunkFoodButtonEdge() {
		act.total = 3;
		act.junk_food_button(null);
		act.junk_food_button(null);
		act.junk_food_button(null);
		assertEquals(3,act.junk_food);
	}
	

}
