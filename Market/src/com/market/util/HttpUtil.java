package com.market.util;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class HttpUtil {
	//声明Base URL变量
	public static final String BASE_URL="http://192.168.0.102:8080/Market/";
	//public static final String BASE_URL1="http://169.254.50.166:8080/Market/";
	public static HttpGet getHttpGet(String url)
	{
		//实例化HttpGet
		HttpGet request=new HttpGet(url);
		return request;
	}
	public static HttpPost getHttpPost(String url)
	{
		
		//实例化HttpPost
		System.out.println("------");
		HttpPost request=new HttpPost(url);
		System.out.println("&&&&&&&&");
		return request;
	}
	//通过HttpGet获得HttpResponse对象
	public static HttpResponse getHttpResponse(HttpGet request) throws ClientProtocolException,IOException
	{
		//实例化HttpResponse
		HttpResponse response=new DefaultHttpClient().execute(request);
		return response;
	}
	// 通过HttpPost获得HttpResponse对象
	public static HttpResponse getHttpResponse(HttpPost request)throws ClientProtocolException,IOException
	{
		//实例化HttpResponse
		HttpResponse response=new DefaultHttpClient().execute(request);
		return response;
	}
	//通过url发送post请求，返回请求结果
	public static String queryStringForPost(String url)
	{
		//获得HttpPost实例
		HttpPost request=HttpUtil.getHttpPost(url);
		String result=null;
		try
		{
			//获得HttpResponse实例
			HttpResponse response=HttpUtil.getHttpResponse(request);
			System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+response.getStatusLine().getStatusCode());
			if(response.getStatusLine().getStatusCode()==200)
			{
				result=EntityUtils.toString(response.getEntity(),HTTP.UTF_8);
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result="网络异常";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result="网络异常";
			return result;
		}
		return null;
	}
	
	//通过HttpPost发送get请求，返回请求结果
	public static String queryStringForGet(String url)
	{
		//获得HttpPost实例
		HttpGet request=HttpUtil.getHttpGet(url);
		String result=null;
		try
		{
			//获得HttpResponse实例
			HttpResponse response=HttpUtil.getHttpResponse(request);
			if(response.getStatusLine().getStatusCode()==200)
			{
				result=EntityUtils.toString(response.getEntity(),HTTP.UTF_8);
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result="网络异常！";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result="网络异常！";
			return result;
		}
		return null;
	}
	
	//通过HttpPost发送post请求，返回请求结果
	public static String queryStringForPost(HttpPost request)
	{
		String result=null;
		try
		{
			//获得HttpResponse实例
			HttpResponse response=HttpUtil.getHttpResponse(request);
			if(response.getStatusLine().getStatusCode()==200)
			{
				result=EntityUtils.toString(response.getEntity(),HTTP.UTF_8);
				return result;
			}
		}catch(ClientProtocolException e)
		{
			e.printStackTrace();
			result="网络异常！";
			return result;
		}catch(IOException e)
		{
			e.printStackTrace();
			result="网络异常！";
			return result;
		}
		return null;
	}
	
	
}
