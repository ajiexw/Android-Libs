package com.ajiex.httpclient;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	String urlAdress = "http://exp.aoaola.com/aoaolaapi/getbrandlist";
	TextView textView;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		textView = (TextView)findViewById(R.id.textView);
		
		try{
			HttpGet httpGet = new HttpGet(urlAdress);
			HttpClient hc = new DefaultHttpClient();
			HttpResponse ht = hc.execute(httpGet);
			if(ht.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				String result = EntityUtils.toString(ht.getEntity());
				textView.setText(result);
			}else{
				textView.setText("error");  
			}
		} catch (ClientProtocolException e) {  
	        textView.setText(e.getMessage().toString());  
	    } catch (IOException e) {  
	    	textView.setText(e.getMessage().toString());   
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}
