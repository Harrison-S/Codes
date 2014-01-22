package org.market.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatVerification {
	public static boolean verify123ABC(String a){//检验输入格式
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}	
	public static boolean verifyMail(String a){//检验输入格式
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static boolean verifyPhone(String a){
		Pattern pattern = Pattern.compile("^1[3|4|5|8][0-9]{9}$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	public static boolean verifyStuNO(String a){
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(a);
		return matcher.matches();
	}
	
}
