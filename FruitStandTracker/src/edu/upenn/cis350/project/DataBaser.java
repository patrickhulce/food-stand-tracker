package edu.upenn.cis350.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.parse.ParseObject;

public class DataBaser {
	private static final DataBaser instance = new DataBaser();
	private HashMap<String,String> info;
	private ArrayList<Transaction> transactions;

	private DataBaser() {
		// Apparently we can't actually do any state here
		// singleton isn't really necessary...oh well. DESIGN PATTERNS FTW
		info = new HashMap<String,String>();
		transactions = new ArrayList<Transaction>();
	}

	public static DataBaser getInstance() {
		return instance;
	}

	public void databaseItThoroughly() {
		//Save the generic information
		ParseObject obj = new ParseObject("fruitStandInfo");
		for(String k : info.keySet()) {
			obj.add(k, info.get(k));
		}
		obj.saveInBackground();
		String school = info.get("school");
		//Save each transaction
		for(Transaction t : transactions) {
			ParseObject obj_t = new ParseObject("fruitStandTransactions");
			obj_t.add("school", school);
			obj_t.add("age", t.age);
			obj_t.add("gender", t.gender);
			obj_t.add("purchases", t.purchases);
			obj_t.add("payments", t.payments);
			obj.saveInBackground();
		}
	}

	public void addInfo(String key, String value) {
		
	}
	
	public void addTransaction(HashMap<String, Integer> purchases,
			HashMap<String, Integer> payments, String gender, String age) {
		Transaction t = new Transaction(purchases, payments, gender, age);
		transactions.add(t);
	}
}
