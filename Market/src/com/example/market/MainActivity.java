package com.example.market;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

import com.example.market.R.id;
import com.market.util.HttpUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.View.OnClickListener;
public class MainActivity extends InstrumentedActivity{
	private TextView username;
	private TextView password;
	
	private EditText user_i;
	private EditText pw_i;
	private Button login;
	private Button signin;
	private String url;
	private int if_login=0;
	private Thread thread_getgood;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin);
		JPushInterface.setDebugMode(true);
		JPushInterface.init(this);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		username=(TextView)findViewById(R.id.Username);
		password=(TextView)findViewById(R.id.Password);
		user_i=(EditText)findViewById(R.id.Editusername);
		pw_i=(EditText)findViewById(R.id.Editpw);
		login=(Button)findViewById(R.id.login);
		signin=(Button)findViewById(R.id.signin);
		login.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				System.out.println("--------fklsajfklsadjflksajdflksadj-------");
				// TODO Auto-generated method stub
				if(validate())
			//	if(true)
				{
					
					login();
					while(if_login == 0){
						System.out.println("SJC");try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
					if(if_login == 2)
			//		if(true)
					{
						Intent intent_login=new Intent(MainActivity.this,signin.class);
						startActivity(intent_login);
					}
					else if(if_login == 1)
					{
						System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
						showDialog("用户名称或者密码错误，请重新输入！");
						if_login = 0;
						System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ");

					}
				}
			}
		});
		
		signin.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {
				Intent intent_tosignin=new Intent(MainActivity.this,signin_real.class);
				startActivity(intent_tosignin);
			}
		});
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 //Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//定义一个显示提示信息的对话框
	private void showDialog(String msg)
	{
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false).setPositiveButton("确定",new DialogInterface.OnClickListener() {
			
			//@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub				
			}
		});
		AlertDialog alert=builder.create();
		alert.show();
	}
	
	private boolean validate()
	{
		String un=user_i.getText().toString();
		System.out.println(un);
		if(un.equals(""))
		{
			showDialog("用户名称是必填项");
			return false;
		}
		String pwd=pw_i.getText().toString();
		if(pwd.equals(""))
		{
			showDialog("用户密码是必填项");
			return false;
		}
		
		return true;
	}
	
	//通过用户名和密码进行查询，发送Post请求，获得相应结果
	private String query(String un,String pwd)
	{
		String queryString="username="+un+"&password="+pwd;
		url=HttpUtil.BASE_URL+"page/AndroidLoginServlet?"+queryString;
		System.out.println(url);
		Runnable runnable=new Runnable()
		{
			@Override
			public void run()
			{
				//TODO:http request
				System.out.println("发送post请求，验证用户名和密码");
				String msg=HttpUtil.queryStringForPost(url);
				System.out.println("#####################"+msg);
				if(msg==null||msg.equals("notFound")||msg.equals("网络异常"))
				{
					if_login=1;
				}
				else
				{
					System.out.println("返回结果正确！！！！！");
					saveUserMsg(msg);
					if_login= 2;
				}
			}
		};
		thread_getgood=new Thread(runnable);
		thread_getgood.setPriority(1);
		thread_getgood.start();
		return "";
	}
	
	//将用户信息保存到配置文件
	private void saveUserMsg(String msg)
	{
		MainApplication appState = ((MainApplication)getApplicationContext());
		System.out.println(msg);
		String temp="";
		//用户编号
		
		System.out.println("___________________________");
		String[] msgs=msg.split("\\|");
		temp=msgs[0];
		appState.setuserno(temp);
		temp=msgs[1];
		appState.setusername(temp);
		JPushInterface.setAlias(getApplicationContext(),temp,new TagAliasCallback() {

			@Override
			public void gotResult(int arg0, String arg1, Set<String> arg2) {
				// TODO Auto-generated method stub
				Log.i("JPush", "Jpush status: " + arg0);//状态

			}

		});
	}
	
	//登陆方法
	private int login()
	{
		String un=user_i.getText().toString();
		String pwd=pw_i.getText().toString();
		query(un,pwd);
		return if_login;
	}
}
