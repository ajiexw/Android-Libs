package com.ajiex.webview;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	private WebView webview;
	private ProgressDialog pd;
	private ProgressBar progressBar;
	private String urlAddress = "http://m.aoaola.com";

	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
		webview = (WebView)findViewById(R.id.webview);
		progressBar = (ProgressBar)findViewById(R.id.progressBar);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebViewClient(new HelloWebViewClient());
			
		//pd=new ProgressDialog(MainActivity.this);
        //pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //pd.setMessage("数据载入中...");
		//pd.show();
		webview.loadUrl(urlAddress);
				
		webview.setWebChromeClient(new WebChromeClient(){
        	public void onProgressChanged(WebView view,int progress){ 
             	if(progress==100){
             		progressBar.setVisibility(View.GONE);
            	}   
                super.onProgressChanged(view, progress);   
            }   
        });
 
	}
	
	private class HelloWebViewClient extends WebViewClient{
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			progressBar.setVisibility(View.VISIBLE);
			view.loadUrl(url);
			return true;
		}
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()){
			webview.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
