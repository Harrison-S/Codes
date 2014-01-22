<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.market.controlmysql.*,org.market.types.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="description of your site" />
    <meta name="author" content="author of the site" />
    <title>USERS</title>
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
    <div class="page">
      <div class="page-container">
<div class="container">
  <div class="row">
  <p>&nbsp;</p>
  <p>&nbsp;</p>
    <!--div class="span12"><a href="#" data-toggle="modal" class="btn pull-right">New User</a-->
    <h4 class="header">Users</h4>
      <table class="table table-striped sortable">
        <thead>
          <tr>
            <th>No</th>
            <th>UserName</th>
            <th>Password</th>
            <th>Sex</th>
            <th>StudentID</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Create</th>
          </tr>
        </thead>
        <tbody>
        <% 
        ClientInfo clientDAO = new ClientInfo();
        ArrayList<ClientType> clientList = clientDAO.allClient(); 
        ClientType clientTemp = new ClientType();
        int i = 0;
        for(;i<clientList.size();i++){
        	clientTemp = clientList.get(i);
        %>
          <tr>
            <td><%=i%></td>
            <td><%=clientTemp.getName() %></td>
            <td><%=clientTemp.getPassword() %></td>
            <%if( clientTemp.getGender() == 1) {%>
            <td><%="Male" %></td><%} %>
            <%if( clientTemp.getGender() == 0) {%>
            <td><%="Female" %></td><%} %>
    		<td><%=clientTemp.getStuNO() %></td>
    		<td><%=clientTemp.getPhone() %></td>
    		<td><%=clientTemp.getEmail() %></td>
            <td><%=clientTemp.getDate() %></td>
            <td>
              <div class="btn-group">
                <button class="btn">Remove</button>
                <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                <ul class="dropdown-menu">
                  <li><a href="DeleteUserInfoServlet?input=<%=clientTemp.getName() %>">Remove</a>
                  <a href="#" onclick="editUser(<%=i%>)">Edit</a></li>
                <script>
               	function editUser(data){
					var datai = data;
					window.open("modify_userInfo.jsp?input="+datai,null,"height=600,width=600");
				}
                </script>
                </ul>
              </div>
            </td>
          </tr>
          <%} %>
        </tbody>
      </table>
      <!--div class="pagination pagination-centered">
        <ul>
          <li class="disabled"><a href="#">&laquo;</a></li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">3</a></li>
          <li><a href="#">4</a></li>
          <li><a href="#">5</a></li>
          <li><a href="#">&raquo;</a></li>
        </ul>
      </div-->
    </div>
  </div>
</div>
      </div>
    </div>
  </body>
  <script src="js/d3-setup.js"></script>
</html>
