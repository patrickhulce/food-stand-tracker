package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class StartActivity extends Activity {
	
	Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getExtras();
        setContentView(R.layout.activity_start);
        Button resume = (Button)findViewById(R.id.buttonResume);
        resume.setEnabled(data != null);
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
    
    public void resume_button(View view){
    	Intent i = new Intent(this, InfoActivity.class);
    	i.putExtras(data);
    	this.startActivity(i);
    }
    
}
