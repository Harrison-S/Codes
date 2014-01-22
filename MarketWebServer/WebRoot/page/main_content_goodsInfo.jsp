<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.market.controlmysql.*,org.market.types.*,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="description" content="description of your site" />
    <meta name="author" content="author of the site" />
    <title>GOODS</title>
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
    <h4 class="header">Goods</h4>
      <table class="table table-striped sortable">
        <thead>
          <tr>
            <th>No</th>
            <th>Name</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
        <% 
        GoodsInfo goodsDAO = new GoodsInfo();
        ArrayList<GoodsType> goodsList = goodsDAO.allGoods();
        GoodsType GoodsTemp = new GoodsType();
        int i = 0;
        for(;i<goodsList.size();i++){
        	GoodsTemp = goodsList.get(i);
        %>
          <tr>
          	<td style="display:none;" id="hided"><%=GoodsTemp.getGNO() %></td>
            <td><%=i%></td>
            <td><%=GoodsTemp.getName() %></td>
            <td><%=GoodsTemp.getPrice() %></td>
            <td>
              <div class="btn-group">
                <button class="btn">Remove</button>
                <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                <ul class="dropdown-menu">
                  <li><a href="#" onclick="goodsDetails(<%=i %>)">Details</a><a href="DeleteGoodsInfoServlet?input=<%=GoodsTemp.getGNO()%>">Remove</a></li>
                  <script>
                  function goodsDetails(data){
                  	var datai = data;
                  	window.open("modify_goodsInfo.jsp?input="+datai,null,"height=800,width=800");
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
</html>