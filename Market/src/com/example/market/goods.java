package com.example.market;

import java.util.ArrayList;
import java.util.List;

import com.example.market.R.id;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class goods extends Activity{
	private ImageView myImageView;
	private TextView myTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sort);
		myImageView=(ImageView)findViewById(R.id.imageView1);
		myTextView=(TextView)findViewById(R.id.textView_goods);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 //Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
