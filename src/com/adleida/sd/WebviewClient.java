package com.adleida.sd;

import android.webkit.WebView;
import android.webkit.WebViewClient;
/**
 * 
 * @author jcle
 * this is webviewclient
 */
public class WebviewClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url){
			view.loadUrl(url);
			return true;
		}
	}

