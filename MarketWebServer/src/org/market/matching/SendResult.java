package org.market.matching;

import java.util.ArrayList;

import cn.jpush.api.DeviceEnum;
import cn.jpush.api.ErrorCodeEnum;
import cn.jpush.api.JPushClient;
import cn.jpush.api.MessageResult;

public class SendResult {
	private String appKey="0dacb29bf974866b7e4b2079";
	private String masterSecret="f25fcc6860acc27e69117913";
	private static int sendNo=1;
	private String content="您和这些用户可以通过物物交换形成一个交友圈 ： ";
	public void push_frame()
	{
		ArrayList<Integer> temp=null;
		Matching a=new Matching();
		a.findCycle(0);
		ArrayList<ArrayList<Integer>> all_traces=a.getalltraces();
		System.out.println("TTTTT"+all_traces);
		for(int i=0;i<all_traces.size();i++)
		{
			temp=all_traces.get(i);
			System.out.println("ssssss"+all_traces.get(0));
			for(int j=0;j<temp.size();j++)
			{
				
				for(int k=0;k<temp.size();j++)
				{
					if(k!=j)
					{
						content+=a.getun_viauno(temp.indexOf(k));
						content+=" , ";
					}
				}
				send_tosig(86400,j,"物物匹配成功",content);
				System.out.println(content);
				content="您和这些用户可以通过物物交换形成一个交友圈 ： ";
			}
		}
	}
	private void send_toall(int timeToLive)
	{
		JPushClient jpush = new JPushClient(masterSecret, appKey, timeToLive);
//		 MessageResult result = jpush.sendCustomMessageWithAlias(timeToLive, "0", "!!!!", "~~~~~~~~~~~");
		 MessageResult result = jpush.sendNotificationWithAppKey(1,"~~~~~~~","~~~~~~~~");
		 if (null != result) {
			    if (result.getErrcode() == ErrorCodeEnum.NOERROR.value()) {
			        System.out.println("发送成功， sendNo=" + result.getSendno());
			    } else {
			        System.out.println("发送失败， 错误代码=" + result.getErrcode() + ", 错误消息=" + result.getErrmsg());
			    }
			} else {
			    System.out.println("无法获取数据");
			}
	     sendNo++;
	}
	public  void send_tosig(int timeToLive,int alias,String title,String content)
	{
		JPushClient jpush = new JPushClient(masterSecret, appKey, timeToLive);
		MessageResult result =jpush.sendNotificationWithAlias(sendNo, alias+"", title, content);
		 if (null != result) {
			    if (result.getErrcode() == ErrorCodeEnum.NOERROR.value()) {
			        System.out.println("发送成功， sendNo=" + result.getSendno());
			    } else {
			     //   System.out.println("发送失败， 错误代码=" + result.getErrcode() + ", 错误消息=" + result.getErrmsg());
			    }
			} else {
			//    System.out.println("无法获取数据");
			}
	     sendNo++;
	}
	public static void main(String[] args)
	{
		new SendResult().push_frame();
	}
}
