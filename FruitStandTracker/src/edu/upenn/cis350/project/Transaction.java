package edu.upenn.cis350.project;

import java.util.HashMap;

public class Transaction {
	HashMap<String, Integer> purchases;
	HashMap<String, Integer> payments;
	String gender;
	String age;

	public Transaction(HashMap<String,Integer> purch, HashMap<String,Integer> pays, String g, String a) {
		purchases = purch;
		payments = pays;
		gender = g;
		age = a;
	}
}
