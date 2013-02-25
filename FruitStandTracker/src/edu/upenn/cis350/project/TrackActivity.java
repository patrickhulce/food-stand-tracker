package edu.upenn.cis350.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TrackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        
        
        /* Replacing views
        int optionId = R.layout.activity_start;

        View C = findViewById(R.id.view1);
        ViewGroup parent = (ViewGroup) C.getParent();
        int index = parent.indexOfChild(C);
        parent.removeView(C);
        C = getLayoutInflater().inflate(optionId, parent, false);
        parent.addView(C, index); */
        
        //Replace the ViewStub
        ViewStub body = (ViewStub) findViewById(R.id.trackStub);
        body.setLayoutResource(R.layout.tracking_info);
        body.inflate();
        
        Spinner spinner = (Spinner) findViewById(R.id.spinnerInfo1);
        
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
             R.array.school_list, android.R.layout.simple_spinner_item);
     
        // Specify the layout to use when the list of choices appears
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        // Apply the adapter to the spinner
       // spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
}