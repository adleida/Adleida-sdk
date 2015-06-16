package com.adleida.sd;

import java.util.List;
import java.util.UUID;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;

/**
 * 
 * @author jcle this is ad sdk
 * 
 */
public class AdleidaActivity {

	private static final String address = "http://123.57.70.242/js/ad.js";
	private static Context context;

	public static Context getContext() {
		return context;
	};

	public static View createView(Context context) {

		WebView localView = new WebView(context);
		// ����web�������Ӧ���߶�����
		localView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				300));
		// getwindowsManager
		WindowManager windows = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		// ��ȡ��Ļ���
		DisplayMetrics dm = new DisplayMetrics();
		windows.getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels; // ��ȡ�ֻ���Ļ�߶�
		int width = dm.widthPixels; // ��ȡ�ֻ���Ļ���
		// get height width
		Log.v("height", "height" + height + "width" + width);
		localView.setWebViewClient(new WebviewClient());
		localView.getSettings().setJavaScriptEnabled(true);
		String model = android.os.Build.MODEL; // ��ȡ�ֻ��ͺ�
		String brand = android.os.Build.BRAND; // ��ȡ�ֻ���Ϣ
		String version = android.os.Build.VERSION.RELEASE;// ��ȡ�ֻ��汾��
		UUID uuid = UUID.randomUUID(); // random device_id
		String country = context.getResources().getConfiguration().locale
				.getCountry(); // resources is CN
		String requestJSONString = "{    'adunit': {        'type': 1,        'floor': 1.6,        'cid': '1101201',        'param': {            'count': 3        }     },    'device': {        'os': 'ANDROID',        'os_version': "
				+ version
				+ ",        'resolution_w':"
				+ width
				+ " ,        'resolution_h': "
				+ height
				+ ",        'network_id': 70120,        'device_type': 2,        'device_id': "
				+ uuid
				+ ",        'device_id_enc': 1,        'delected_language': "
				+ country
				+ ",        'brand': "
				+ brand
				+ ",        'model': "
				+ model
				+ "    },    'geo': {        'country': '�й�',        'city': '����',        'latitude': 102.153585,        'longtitude': 10.5544    },    'user_id': 'bangbang2015001',    'is_test': 1,    'cur': 'CNY',    'sdk': 'bangbang'}";
		String html = "<html>\n<body>\n<script type='text/javascript' language='javascript'>var data = "
				+ requestJSONString
				+ "</script>\n"
				+ "<script type='text/javascript' language='javascript' src="
				+ address + "></script>\n</body>\n</html>";
		Log.v("requestdata", requestJSONString);
		localView.loadData(html, "text/html", "utf-8");
		return localView;
	}
}
