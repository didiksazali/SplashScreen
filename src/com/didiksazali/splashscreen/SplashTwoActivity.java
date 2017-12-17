package com.didiksazali.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;

public class SplashTwoActivity extends Activity {

	private static final int splashDuration = 5000;
	private Handler myHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_two);

		if (android.os.Build.VERSION.SDK_INT > 10) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}

		myHandler = new Handler();
		myHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				finish();
				
				Intent intent = new Intent(SplashTwoActivity.this, SplashThreeActivity.class);
				startActivity(intent);

			}

		}, splashDuration);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

	}
}
