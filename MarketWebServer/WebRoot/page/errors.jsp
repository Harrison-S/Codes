
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%
      String url = basePath+"page/mainframe_information.html";
%>
<html>
    <head>    
    <meta http-equiv=refresh content=5;url=<%=url %>>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">    
<script>
    <!--
        window.moveTo(0,0);
    //-->
</script>       
</head>
<body >

<p>&nbsp;</p>
<p>&nbsp;</p>
<p align="center"><img src="img/error404.jpg" width="358" height="300"></p>
<p>&nbsp;</p>
<p align="center"><b style=color:blue><span></span>Returning to Login...</b></p>

</body>
</html>          

<script>
function countDown(secs){
    jump.innerText=secs;
    if(--secs>0)
        setTimeout("countDown("+secs+" )",1000);
}
countDown(5);
</script>