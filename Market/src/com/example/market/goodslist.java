package com.example.market;

import java.util.ArrayList;
import java.util.List;

import com.example.market.R.id;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class goodslist extends Activity{ 
	private ListView lv_goodslist;
	List<String> strs_goodslist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goodslist);
		MainApplication appState = ((MainApplication)getApplicationContext());
		strs_goodslist=appState.getgoodname();
		lv_goodslist=(ListView)findViewById(id.listView_goodslist);
		lv_goodslist.setAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, strs_goodslist));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 //Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
