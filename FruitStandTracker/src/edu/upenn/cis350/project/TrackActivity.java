package edu.upenn.cis350.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_start, menu);
        return true;
    }
    
}