<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="org.market.controlmysql.*,org.market.types.*,java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Goods Details</title>
</head>
<%
		int index = Integer.parseInt(request.getParameter("input"));
 		GoodsInfo goodsDAO = new GoodsInfo();
        ArrayList<GoodsType> goodsList = goodsDAO.allGoods();
        GoodsType GoodsTemp = goodsList.get(index);
        
 %>

<body>
<h3>Details</h3>
<hr />
<form id="form1" name="form1" method="post" action="">
  <h4>Goods ID : <%=index %></h4>
  <div align="center">
    <table width="70%" height="337" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="132"><div align="center">商品名称：</div></td>
        <td width="591"><%=GoodsTemp.getName() %></td>
         <!-- input type="text" name="goodsname" value=<%//=GoodsTemp.getName()%> id="goodsname" style="background:#CCC" readonly/-->
      </tr>
      <tr>
        <td><div align="center">卖家：</div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">价格：</div></td>
        <td><%=GoodsTemp.getPrice() %></td>
      </tr>
      <tr>
        <td><div align="center">分类：</div></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><div align="center">介绍：</div></td>
        <td><%=GoodsTemp.getIntroduction() %></td>
      </tr>
      <tr>
        <td><div align="center">上架时间：</div></td>
        <td><%=GoodsTemp.getDate() %></td>
      </tr>
      <tr>
        <td width="20">&nbsp;</td>
        <td width="100" nowrap="nowrap">&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
  </div>
  <p>&nbsp;</p>
</form>
<p>&nbsp;</p>
</body>
</html>