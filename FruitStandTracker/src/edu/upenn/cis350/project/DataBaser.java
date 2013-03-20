package edu.upenn.cis350.project;

import com.parse.ParseObject;

public class DataBaser {
	private static final DataBaser instance = new DataBaser();
	
	private DataBaser() {
		
	}
	
	public static DataBaser getInstance() {
		return instance;
	}
	
	public void databaseItThoroughly(String name, String s, Object o) {
		ParseObject obj = new ParseObject(name);
		obj.put(s,o);
		obj.saveInBackground();
		System.out.println("I did it! :D");
	}
}
