package com.didiksazali.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashOneActivity extends Activity {

	ProgressBar prgLoading;
	int progress = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_one);
		prgLoading = (ProgressBar) findViewById(R.id.progressBar1);
		prgLoading.setProgress(progress);
		new Loading().execute();

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
	}

	public class Loading extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			while (progress < 100) {
				try {
					Thread.sleep(1000);
					progress += 20;
					prgLoading.setProgress(progress);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(SplashOneActivity.this, SplashTwoActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
}
