package com.adleida.sdk;

import com.adleida.sd.AdleidaActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * @author jcle
 * this is sdk test
 * 
 */
public class MainActivity extends Activity{
	LinearLayout layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		layout=(LinearLayout) findViewById(R.id.adLayout);
		layout.addView(AdleidaActivity.createView(this));
	}
}
