<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.market.controlmysql.*,org.market.types.*,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Modify Personal Information</title>
</head>
<% 
	String id = request.getParameter("input");
	int index = Integer.parseInt(id);
	ClientInfo clientDAO = new ClientInfo();
    ArrayList<ClientType> clientList = clientDAO.allClient(); 
    ClientType clientTemp = clientList.get(index);
%>
<body>
<p><h3>Modify Personal Information</h3><h4>User ID : <%=index%></h4></p>
<hr />
<form id="form1" name="form1" method="post" action="ModifyUserInfoServlet">
  <div align="center">
    <table width="412" height="351" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><div align="center">用户名：</div></td>
        <td><label for="usr"></label>
        <input type="text" name="usr" value=<%=clientTemp.getName()%> id="usr" style="background:#CCC" readonly/></td>
      </tr>
      <tr>
        <td><div align="center">密码：</div></td>
        <td><label for="password"></label>
        <input type="text" name="password" value=<%=clientTemp.getPassword()%> id="password" /></td>
      </tr>
      <tr>
        <td><div align="center">学号：</div></td>
        <td><label for="stuNO"></label>
        <input type="text" name="stuNO" value=<%=clientTemp.getStuNO()%> id="stuNO" /></td>
      </tr>
      <tr>
        <td><div align="center">性别：</div></td>
        <td><table width="200">
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
        <td><div align="center">邮箱：</div></td>
        <td><input type="text" name="email" value=<%=clientTemp.getEmail() %> id="email" style="background:#CCC" readonly/></td>
      </tr>
      <tr>
        <td><div align="center">手机号：</div></td>
        <td><input type="text" name="phone" value=<%=clientTemp.getPhone() %> id="phone" /></td>
      </tr>
      <tr>
        <td><div align="center">创建时间：</div></td>
        <td><input type="text" name="date" value=<%=clientTemp.getDate() %> id="date" style="background:#CCC" readonly/></td>
      </tr>
    </table>
    <p>
      <input type="button" name="button1" id="button1" value="Modify" onclick="submitInfo()"/>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="button" name="button2" id="button2" value="Reset" onclick="resetInfo()"/>
    </p>
  </div>
</form>
<script>
function submitInfo(){
	alert("submit testing...");
	var pwd = document.getElementById("password").value;
	var stu = document.getElementById("stuNO").value;
	var sex = document.getElementsByName("sex");
	var phone = document.getElementById("phone").value;
	if(!regIs123ABC(pwd)){
		alert("密码只能由数字和字母组成！");	
	}
	else if(!regIsStu(stu)){
		alert("请输入合法的学号");
	}
	else if(!sex[0].checked && !sex[1].checked){
		alert("您还未选择性别呢~");
	}
	else if(!regIsPhone(phone)){
		alert("请输入合法的手机号码");
	}
	else{
		form1.submit();
		window.close();
	}
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

function resetInfo(){
	alert("reset testing...");
	document.getElementById("password").value = <%=clientTemp.getPassword()%>;
	document.getElementById("stuNO").value = <%=clientTemp.getStuNO()%>;
	document.getElementById("phone").value = <%=clientTemp.getPhone()%>;
}

</script>
</body>
</html>
