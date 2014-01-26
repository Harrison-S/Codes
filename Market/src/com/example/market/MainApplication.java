package com.example.market;
import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.content.Context;
public class MainApplication extends Application{
	private String username;
	private String userno;
	private List<String> goodno=new ArrayList<String>();
	private List<String> goodname=new ArrayList<String>();
	private List<String> ownerno=new ArrayList<String>();
	private List<String> price=new ArrayList<String>();
	private List<String> info=new ArrayList<String>();
	private List<String> date=new ArrayList<String>();
	public List<String> getgoodno()
	{
		return goodno;
	}
	public List<String> getgoodname()
	{
		return goodname;
	}
	public List<String> getownerno()
	{
		return ownerno;
	}
	public List<String> getprice()
	{
		return price;
	}
	public List<String> getinfo()
	{
		return info;
	}
	public List<String> getdate()
	{
		return date;
	}
	public String getusername()
	{
		return username;
	}
	public String userno()
	{
		return userno;
	}
	
	/////////////////////////////////////////////////////
	public void setusername(String a)
	{
		username=a;
	}
	public void setuserno(String a)
	{
		userno=a;
	}
	public void addgoodname(String a)
	{
		goodname.add(a);
	}
	public void addownerno(String a)
	{
		ownerno.add(a);
	}
	public void addprice(String a)
	{
		price.add(a);
	}
	public void addgoodno(String a)
	{
		goodno.add(a);
	}
	public void addinfo(String a)
	{
		info.add(a);
	}
	public void adddate(String a)
	{
		date.add(a);
	}
}
























