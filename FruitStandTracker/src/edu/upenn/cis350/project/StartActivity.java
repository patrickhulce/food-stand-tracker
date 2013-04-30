package edu.upenn.cis350.project;

import com.parse.Parse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class StartActivity extends Activity {
	
	Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getExtras();
        setContentView(R.layout.activity_start);
        
        //for Parse
        Parse.initialize(this, 
        		getString(R.string.parseAPIkey), getString(R.string.parsesecretkey));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
    public void start_button(View view){
    	Intent i = new Intent(this, InfoActivity.class);
    	this.startActivity(i);
    }
    
    
}
