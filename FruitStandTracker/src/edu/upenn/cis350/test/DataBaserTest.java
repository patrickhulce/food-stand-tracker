package edu.upenn.cis350.test;

import java.util.ArrayList;
import java.util.HashMap;

import edu.upenn.cis350.project.DataBaser;

import junit.framework.TestCase;

public class DataBaserTest extends TestCase {
	DataBaser db = DataBaser.getInstance();
	protected void setUp() throws Exception {
		super.setUp();
		/*
		db.info = new HashMap<String,String>();
		db.transactions = new ArrayList<Transaction>();
		db.inventory1 = new HashMap<String,Integer>();
		db.inventory2 = new HashMap<String,Integer>();
		*/
	}
	/*
	public void testAddTransactionBasic() {
		db.addTransaction(null, null, null, null);
		assertEquals(1,db.transactions.size());
	}
	
	public void testAddTransactionAdvance() {
		db.addTransaction(null, null, null, null);
		db.addTransaction(null, null, "male", "old_person");
		assertEquals(2,db.transactions.size());
		assertEquals("male",db.transactions.get(1).gender);
		assertEquals("old_person",db.transactions.get(1).age);
	}
	
	public void testAddInfo() {
		db.addInfo("my_key", "my_val");
		assertTrue(db.info.containsKey("my_key"));
		assertEquals("my_val",db.info.get("my_key"));
	}
	
	public void testAddPreInventory() {
		HashMap<String,Integer> inv = new HashMap<String,Integer>();
		db.savePreInventory(inv);
		assertTrue(inv == db.inventory1);
	}
	
	public void testAddPostInventory() {
		HashMap<String,Integer> inv = new HashMap<String,Integer>();
		db.savePostInventory(inv);
		assertTrue(inv == db.inventory2);
	}
*/
}
