package edu.upenn.cis350.test;

import edu.upenn.cis350.project.TransactionBaseActivity;
import android.test.ActivityInstrumentationTestCase2;

public class TransactionBaseActivityTest extends ActivityInstrumentationTestCase2<TransactionBaseActivity> {

	public TransactionBaseActivityTest(){
		super("edu.upenn.cis350.project",TransactionBaseActivity.class);
	}
	
	protected void setup() throws Exception{
		super.setUp();
	}
	
	public void testSomething(){
		
	}
}
