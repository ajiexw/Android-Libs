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
import android.annotation.SuppressLint;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	String urlAdress = "http://exp.aoaola.com/aoaolaapi/getbrandlist";
	TextView textView;
	Button button;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView)findViewById(R.id.textView);
		textView.post(runnable);
	}	
	
	Runnable runnable = new Runnable() {
		public void run() {
			HttpGet httpGet = new HttpGet(urlAdress);
			HttpClient hc = new DefaultHttpClient();
			String result;
			try{
				HttpResponse ht = hc.execute(httpGet);
				if(ht.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
					result = EntityUtils.toString(ht.getEntity());
				}else{
					result = "error";  
				}
			}catch(ClientProtocolException e) {  
				result = "error";  
		    }catch(IOException e) {  
		    	result = "error";  
		    }
			textView.setText(result);
			
		}
	};
	
	
}
