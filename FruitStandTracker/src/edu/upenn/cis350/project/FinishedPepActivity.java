package edu.upenn.cis350.project;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class FinishedPepActivity extends Activity {
	Bundle data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finished_pep);
		data = getIntent().getExtras();
		TextView txtv = (TextView) findViewById(R.id.profitability_congrats_view);
		if (data.getBoolean("profitable")) {
			txtv.setText("Great Job! You made money today! Hold your head high and brag about it!");
		} else {
			txtv.setText("Good Job! You risked it all, and while you didn't make money today, you can hold your head high and be proud of your work.");
		}
	}

	public void goBack(View v) {
		Intent i = new Intent(this, StartActivity.class);
		this.startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pre_sales_pep, menu);
		return true;
	}

}
