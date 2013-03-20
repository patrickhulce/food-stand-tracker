package edu.upenn.cis350.project;

import java.util.Map;

import com.parse.ParseObject;

public class DataBaser {
	private static final DataBaser instance = new DataBaser();
	
	private DataBaser() {
		//Apparently we can't actually do any state here so single isn't really necessary...oh well. DESIGN PATTERNS FTW
	}
	
	public static DataBaser getInstance() {
		return instance;
	}
	
	public void databaseItThoroughly(String table, Map<String,Object> attrs) {
		ParseObject obj = new ParseObject(table);
		for(String k : attrs.keySet()) {
			obj.add(k, attrs.get(k));
		}
		obj.saveInBackground();
		System.out.println("I did it! :D");
	}
}
