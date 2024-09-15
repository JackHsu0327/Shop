<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品新增</title>
</head>
<body>
<h1>新增商品</h1>
<form action="AddController" method="post">
		<table width=400 align="center">
		<tr>
			<td>
			商品名稱:<input type="text" name="name"><br>
			價格:<input type="text" name="price"><br>
			庫存數量:<input type="text" name="quantity"><br>
			<input type="submit" value="新增商品">
		</table>	

</form>
<a href="index.jsp">返回首頁</a>

<%
    String errorMessage = (String) session.getAttribute("errorMessage");
    if (errorMessage != null) {
        out.println("<p style='color:red;'>" + errorMessage + "</p>");
        session.removeAttribute("errorMessage"); 
    }

    String successMessage = (String) session.getAttribute("successMessage");
    if (successMessage != null) {
        out.println("<p style='color:green;'>" + successMessage + "</p>");
        session.removeAttribute("successMessage"); 
    }
%>
</body>
</html>