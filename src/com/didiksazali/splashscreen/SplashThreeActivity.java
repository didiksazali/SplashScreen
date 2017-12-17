package com.didiksazali.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;

public class SplashThreeActivity extends Activity {

	protected boolean aktif = true;
	protected int splash = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_splash_three);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int delay = 0;
					while (aktif && (delay < splash)) {
						sleep(100);
						if (aktif) {
							delay += 100;
						}
					}
				} catch (InterruptedException e) {
				} finally {
					finish();
					Intent intent = new Intent(SplashThreeActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}
		};
		splashTread.start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			aktif = false;
		}
		return true;
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
