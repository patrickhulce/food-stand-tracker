package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_info);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
    Spinner spinner = (Spinner) findViewById(R.id.spinnerInfo1);
    
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
         R.array.school_list, android.R.layout.simple_spinner_item);
 
    // Specify the layout to use when the list of choices appears
    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    
    // Apply the adapter to the spinner
   // spinner.setAdapter(adapter);
    
}
