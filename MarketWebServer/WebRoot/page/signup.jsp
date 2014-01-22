<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*,org.market.tools.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Sign Up Now!</title>
<style type="text/css">
.color1 {
	color: #D8F0FE;
}
body {
	background-color: #f6f6f6;
}
.color {
	color: #A2C8EE;
}
</style>
<script type="text/javascript">
function MM_popupMsg(msg) { //v1.0
  alert(msg);
}
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="126" valign="bottom" bgcolor="#292929"><h2 align="right"><strong onclick="MM_goToURL('parent','login.jsp');return document.MM_returnValue"><span class="color">&lt; Back</span></strong></h2></td>
    <td bgcolor="#292929">&nbsp;</td>
  </tr>
</table>
<div>
  <form id="form1" name="form1" method="post" action="RegisterServlet">
  <p>&nbsp;</p>
  <div align="center">
    <table width="612" height="298" >
      <tr>
        <td width="174" rowspan="6"><img src="img/user_add.png" width="128" height="128" /></td>
        <td width="128">用户名：</td>
        <td width="298"><label for="usr8"></label>
        <input type="text" name="usr" id="usr" /></td>
      </tr>
      <tr>
        <td>密码：</td>
        <td width="268"><label for="password"></label>
        <input type="password" name="password" id="password" /></td>
      </tr>
      <tr>
        <td>确认密码：</td>
        <td width="268"><label for="pconfirm"></label>
        <input type="password" name="pconfirm" id="pconfirm" /></td>
      </tr>
      <tr>
        <td>学号：</td>
        <td><label for="stuNO"></label>
          <input type="text" name="stuNO" id="stuNO" /></td>
      </tr>
      <tr>
        <td>性别：</td>
        <td width="268"><table width="200">
          <tr>
            <td><label>
              <input type="radio" name="sex" value="1" id="sex_0" />
              男</label></td>
          </tr>
          <tr>
            <td><label>
              <input type="radio" name="sex" value="0" id="sex_1" />
              女</label></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="40">邮箱：</td>
        <td width="268"><label for="email"></label>
        <input type="text" name="email" id="email" /></td>
      </tr>
      <tr>
        <td height="45">&nbsp;</td>
        <td>手机号：</td>
        <td><label for="phone"></label>
        <input type="text" name="phone" id="phone" /></td>
      </tr>
    </table>
  </div>
  <div align="center">
    <table width="244" height="65">
      <tr>
        <td width="76"><input type="button" name="button1" id="button1" value="Signup" onclick = "register()"/></td>
        <td width="151">&nbsp;</td>
        <td width="74"><input name="reset" type="reset" id="reset" value="Reset"/></td>
      </tr>
    </table>
  </div>
  <p>&nbsp;</p>
</form>
<p align="center">&nbsp;</p>
</div>
</body>
</html>
<script>
var errori='<%=request.getParameter("error")%>';
if(errori == 'usrExist'){
	alert("用户名已存在！");
}

function regIs123ABC(data)
{
    var reg = new RegExp("^[A-Za-z0-9]+$");
    return (reg.test(data));
}
function regIsPhone(data)
{
    var reg = new RegExp("^1[3|4|5|8][0-9]{9}$");
    return (reg.test(data));
}
function regIsStu(data)
{
    var reg = new RegExp("^[0-9]*$");
    return (reg.test(data));
}
function regIsEmail(data){
	var reg = new RegExp("^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$");
    return (reg.test(data));
}
function register(){
	var usr = document.getElementById("usr").value;
	var pwd = document.getElementById("password").value;
	var pwdi = document.getElementById("pconfirm").value;
	var stu = document.getElementById("stuNO").value;
	var sex = document.getElementsByName("sex");
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	if(!regIs123ABC(usr) || !regIs123ABC(pwd)){
		alert("用户名、密码只能由数字和字母组成！");	
	}
	else if(pwd != pwdi){
		alert("两次密码输入不一致！");	
	}
	else if(!regIsStu(stu)){
		alert("请输入合法的学号");
	}
	else if(!sex[0].checked && !sex[1].checked){
		alert("您还未选择性别呢~");
	}
	else if(!regIsEmail(email)){
		alert("请输入合法的邮箱地址");	
	}
	else if(!regIsPhone(phone)){
		alert("请输入合法的手机号码");
	}
	else{
		form1.submit();	
	}
	//window.location.href("RegisterServlet");
}
</script>