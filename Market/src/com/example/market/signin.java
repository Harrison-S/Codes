package com.example.market;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.util.EntityUtils;

import com.example.market.R.id;
import com.market.util.HttpUtil;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.view.*;
import android.app.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.*;
public class signin extends TabActivity  {
	private List<String> strs_home=new ArrayList<String>();
	private List<String> strs1=new ArrayList<String>();
	private List<String> strs2_1=new ArrayList<String>();
	private List<String> strs2_2=new ArrayList<String>();
	private List<String> strs2_3=new ArrayList<String>();
	private List<String> strs2_4=new ArrayList<String>();
	private List<String> strs2_5=new ArrayList<String>();
	private List<String> strs2_6=new ArrayList<String>();
	private boolean isfinished;
	private Button logout;
	private ListView lv2;
	private String url;
	private int list1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabHost th=getTabHost();
		isfinished=false;
		list1=0;
		LayoutInflater.from(this).inflate(R.layout.activity_main,th.getTabContentView(),true);
		th.addTab(th.newTabSpec("home").setIndicator("主页").setContent(R.id.LinearLayout_home));
		th.addTab(th.newTabSpec("sort").setIndicator("分类").setContent(R.id.LinearLayout_sort));
		th.addTab(th.newTabSpec("detail").setIndicator("个人中心").setContent(R.id.LinearLayout_detail));
		
		logout=(Button)findViewById(R.id.button1);
		logout.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent_login=new Intent(signin.this,MainActivity.class);
				startActivity(intent_login);
			}
		});
		
		strs_home.add("小雨的内裤");
		strs_home.add("第二个项目");
		ListView lv_home=(ListView)findViewById(id.listView_home);
		lv_home.setAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, strs_home));
		
		lv_home.setOnItemClickListener(new OnItemClickListener()
		{
			 @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                    long arg3) {
	                // TODO Auto-generated method stub
	                if(strs_home.get(arg2).equals("第二个项目"))
	                {
	                    Intent intent_home = new Intent(signin.this,goods.class);
	                    startActivity(intent_home);
	                }
	            }

		}
		);
		lv2=(ListView)findViewById(id.listView2);
		strs1.add("数码产品");
		strs1.add("美容保健");
		strs1.add("图书音像");
		strs1.add("服装箱包");
		strs1.add("家具代步");
		strs1.add("饮食娱乐");
		strs1.add("饮食娱乐");
		strs1.add("饮食娱乐");
		strs1.add("饮食娱乐");
		strs1.add("饮食娱乐");
		strs1.add("饮食娱乐");
		
		strs2_1.add("手机及配件");
		strs2_1.add("电脑");
		strs2_1.add("外设");
		strs2_1.add("其他");
		
		strs2_2.add("护肤");
		strs2_2.add("香水");
		strs2_2.add("美甲");
		strs2_2.add("其他");
		
		strs2_3.add("书");
		strs2_3.add("碟片");
		strs2_3.add("海报");

		strs2_4.add("鞋帽");
		strs2_4.add("衣服");
		strs2_4.add("包");
		strs2_4.add("其他");
		
		strs2_5.add("桌椅");
		strs2_5.add("代步工具");
		strs2_5.add("家居耗材");
		strs2_5.add("其他");
		
		strs2_6.add("门票");
		strs2_6.add("优惠卡");
		strs2_6.add("饮食");
		strs2_6.add("其他");
		
		
		
		ListView lv1=(ListView)findViewById(id.listView1);
		lv1.setAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, strs1));
		
		lv2.setAdapter(new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, strs2_1));
		
		lv1.setOnItemClickListener(new OnItemClickListener()
		{
			 @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                    long arg3) {
				 	list1=arg2;
	                // TODO Auto-generated method stub
	                if(strs1.get(arg2).equals("数码产品"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_1));
	                }
	                if(strs1.get(arg2).equals("美容保健"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_2));
	                }
	                if(strs1.get(arg2).equals("图书音像"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_3));
	                }
	                if(strs1.get(arg2).equals("服装箱包"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_4));
	                }
	                if(strs1.get(arg2).equals("家具代步"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_5));
	                }
	                if(strs1.get(arg2).equals("饮食娱乐"))
	                {
	            		lv2.setAdapter(new ArrayAdapter<String>(signin.this,
	            		android.R.layout.simple_list_item_1, strs2_6));
	                }
	            }

		}
		);
		
		
		
		
		ListView lv2=(ListView)findViewById(id.listView2);
		lv2.setAdapter(new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, strs2_1));
		lv2.setOnItemClickListener(new OnItemClickListener()
		{
			 @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                    long arg3) {
	                // TODO Auto-generated method stub
				 String temp1=""+list1;
				 String temp2=""+arg2;
				 query(temp1,temp2);
//				 saveGoodsMsg(str);
//				 System.out.println(str);
				 Intent to_goodlist = new Intent(signin.this,goodslist.class);
                 startActivity(to_goodlist);
//				 str =  EntityUtils.toString(str.getEntity(),"UTF-8");
//				 System.out.println(str);
	            }

		}
		);
		
	}
//	public View createTabContent(String tag)
//	{
////		ListView lv=new ListView(this);
////		List<String> list=new ArrayList<String>();
//		//list.add(tag);
////		if(tag.equals("home"))
////		{
//			ListView lv=new ListView(this);
//			List<String> list=new ArrayList<String>();
//			list.add("小雨的内裤");
//			list.add("小雨的秋裤");
//			ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list);
//			lv.setAdapter(adapter);
//			return lv;
////		}
////		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,list);
//////		lv.setAdapter(adapter);
////		return lv;
//	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 //Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onBackPressed()
	{
		if(isfinished)
		{
			finish();
		}else
		{
			Toast.makeText(this, "再点击一次退出程序", Toast.LENGTH_SHORT).show();
			new Thread()
			{
				public void run()
				{
					isfinished=true;
					try
					{
						Thread.sleep(2000);
						isfinished=false;
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				};
			}.start();
		}
	}
	private String query(String un,String pwd)
	{
		String queryString="list1="+un+"&list2="+pwd;
		url=HttpUtil.BASE_URL+"page/AndroidSearchGoodsServlet?"+queryString;
		System.out.println(url);
		Runnable runnable=new Runnable()
		{
			@Override
			public void run()
			{
				//TODO:http request
				System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
				String msg=HttpUtil.queryStringForPost(url);
				if(!(msg==null||msg.equals("notFound")))
				saveGoodsMsg(msg);
			}
		};
		Thread thread_getgood=new Thread(runnable);
		thread_getgood.setPriority(1);
		thread_getgood.start();
		return "";
		//page/AndroidLoginServlet?
	}
	private void saveGoodsMsg(String msg)
	{
		System.out.println("$$$$$$$$$$$$$$$$$$$"+msg);
		String[] msgs1=msg.split("\\$");
		MainApplication appState = ((MainApplication)getApplicationContext());
		
		System.out.println("++++++++++_______________"+msgs1[0]);
		String[][] msgs2=new String[msgs1.length][8];
		for(int i=0;i<msgs1.length;i++)
		{
			msgs2[i]=msgs1[i].split("\\|");
			System.out.println(msgs2[i][0]);
			System.out.println(msgs2[i][1]);
			System.out.println(msgs2[i][2]);
			System.out.println(msgs2[i][3]);
			System.out.println(msgs2[i][4]);
			System.out.println(msgs2[i][5]);
			System.out.println(msgs2[i][6]);
			System.out.println(msgs2[i][7]);
			
			appState.addgoodno(msgs2[i][0]);
			
			appState.addgoodname(msgs2[i][1]);
			
			appState.addownerno(msgs2[i][2]);
			
			appState.addprice(msgs2[i][3]);
			
			appState.addinfo(msgs2[i][6]);
			
			appState.adddate(msgs2[i][7]);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
