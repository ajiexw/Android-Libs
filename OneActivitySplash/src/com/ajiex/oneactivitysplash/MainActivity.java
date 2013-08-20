package com.ajiex.oneactivitysplash;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private LinearLayout splash;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN, WindowManager.LayoutParams. FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		splash = (LinearLayout)findViewById(R.id.splashScreen);
		Handler x = new Handler();
		x.postDelayed(new SplashRunnable(), 3600);
	}
	
	class SplashRunnable implements Runnable{
		public void run() {
			splash.setVisibility(View.GONE);
		}
	}


}
