package edu.upenn.cis350.project;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TransactionBaseActivity extends Activity {

	Bundle data;
	
	 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getExtras();
        setContentView(R.layout.transaction_base_activity);
        
        TextView wholefruit = (TextView)findViewById(R.id.wholefruit);
        TextView smoothies = (TextView)findViewById(R.id.smoothies);
        TextView mixedbags = (TextView)findViewById(R.id.mixedbags);
        TextView transactions = (TextView)findViewById(R.id.transactions);
        TextView totalsales = (TextView)findViewById(R.id.totalsales);
        
        wholefruit.setText(data.get("whole_fruit").toString());
        smoothies.setText(data.get("smoothies").toString());
        mixedbags.setText(data.get("mixed_bags").toString());
        totalsales.setText("$"+(Integer)data.get("total")*0.5 );
        transactions.setText((Integer)data.get("transactions") + "");
      //for Parse
        Parse.initialize(this, 
        		"vKGeILnmz4ajn4OtZQoentkFSvcg9gBKch4oTavc", "qSdO1zCvQfzFrJgvcljwylR4DVO7vse31lbn8TrE"); 
        //ParseObject testObject = new ParseObject("TestObject");
        //testObject.put("foo", "bar");
        //testObject.saveInBackground();
    }

	public void newTransaction(View view){
		Intent i = new Intent(this, SaleActivity.class);
		i.putExtras(data);
		Object transactions = data.get("transactions");
		if(transactions == null){
			i.putExtra("transactions", 0);
		}
		this.startActivity(i);
	}
	 
	public void finishSession(View view){
		//saves the data to Parse
		ParseObject allTransactions = new ParseObject("totalTransactionInfo");
		for(String s: data.keySet()){
			allTransactions.put(s, data.get(s));
		}
		allTransactions.saveInBackground();
	}
}
