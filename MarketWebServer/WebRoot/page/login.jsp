<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <meta charset="utf8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="description of your site" />
    <meta name="author" content="author of the site" />
    <title>Manage Market</title>
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />
    <link rel="stylesheet" href="css/styles.css" />
    <link rel="stylesheet" href="css/toastr.css" />
    <link rel="stylesheet" href="css/fullcalendar.css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.knob.js"></script>
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="js/jquery.sparkline.min.js"></script>
    <script src="js/toastr.js"></script>
    <script src="js/jquery.tablesorter.min.js"></script>
    <script src="js/jquery.peity.min.js"></script>
    <script src="js/fullcalendar.min.js"></script>
    <script src="js/gcal.js"></script>
    <script src="js/setup.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
  <body>
    <div id="in-nav">
      <div class="container">
        <div class="row">
          <div class="span12">
            <ul class="pull-right">
              <li></li>
              <li><a href="signup.jsp">Signup</a></li>
            </ul>
            <h4>welcome admin</h4>
          </div>
        </div>
      </div>
    </div>
<div class="container">
  <div class="row">
    <div class="span6 offset2">
      <div class="login">
        <form class="form-horizontal" />        
          <div class="control-group">
            <div class="controls">
              <h4>Login</h4>
            </div>
          </div>
          <div class="control-group">
            <label for="inputEmail" class="control-label">Username</label>
            <div class="controls">
              <input id="inputEmail" type="text" placeholder="Username" />
            </div>
          </div>
          <div class="control-group">
            <label for="inputPassword" class="control-label">Password </label>
            <div class="controls">
              <input id="inputPassword" type="password" placeholder="Password" />
            </div>
          </div>
          <div class="control-group"> 
            <div class="controls">
              <div align="center"><input type="button" name="button2" id="button2" value="Login" onclick = "adminSubmit()"/></div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
  </body><script>protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://'; address = protocol + window.location.host + window.location.pathname + '/ws'; socket = new WebSocket(address);
socket.onmessage = function(msg) { msg.data == 'reload' && window.location.reload() }</script>
</html>
<script>
var errori='<%=request.getParameter("error")%>';
if(errori == 'notFound'){
	alert("用户名或密码错误！");
}
else if(errori == 'signup'){
	alert("注册成功！");
}
function adminSubmit(){
	var usr = document.getElementById("inputEmail").value;
	var pwd = document.getElementById("inputPassword").value;
	window.location.href = "LoginServlet?input="+usr+"|"+pwd;
}
</script>