package com.ajiex.splash;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Handler x = new Handler();
		x.postDelayed(new SplashRunnable(), 1200);
	}
	
	class SplashRunnable implements Runnable{
		public void run() {
			startActivity(new Intent(SplashActivity.this, MainActivity.class));
			SplashActivity.this.finish();
			
			//更改布局
			//SplashActivity.this.setContentView(R.layout.activity_main);
			
		}
	}

}
