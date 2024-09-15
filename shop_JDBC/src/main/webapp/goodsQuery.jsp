<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="service.impl.GoodsServiceImpl" 
    import="model.Goods"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品查詢結果</title>
</head>
<body>
<h1>商品查詢結果</h1>

<form action="goodsQuery.jsp" method="post">
    <table width="1000" height="50" align="center" border="2">
        <tr>
        	<td>商品ID: <input type="text" name="id" size="5"></td>
            <td>商品名稱: <input type="text" name="name" size="5"></td>
            <td>商品價格最低價: <input type="text" name="minPrice" size="5"></td>
            <td>商品價格最高價: <input type="text" name="maxPrice" size="5"></td>
            <td><input type="submit" value="送出"></td>
        </tr>
    </table>
</form>

<%  
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String minPriceStr = request.getParameter("minPrice");
	String maxPriceStr = request.getParameter("maxPrice");
	
	GoodsServiceImpl goodsService = new GoodsServiceImpl();
    List<Goods> goodsList = null;
    
    if (id != null && !id.isEmpty()) {
        goodsList = goodsService.selectBy(Integer.parseInt(id));
    } else if (name != null && !name.isEmpty() && minPriceStr != null && maxPriceStr != null && !minPriceStr.isEmpty() && !maxPriceStr.isEmpty()) {
        int minPrice = Integer.parseInt(minPriceStr);
        int maxPrice = Integer.parseInt(maxPriceStr);
        goodsList = goodsService.selectNamePrice_1(name, minPrice, maxPrice);
    } else if (name != null && !name.isEmpty() && minPriceStr != null && !minPriceStr.isEmpty()) {
        int minPrice = Integer.parseInt(minPriceStr);
        goodsList = goodsService.selectNamePrice_2(name, minPrice);
    } else if (name != null && !name.isEmpty() && maxPriceStr != null && !maxPriceStr.isEmpty()) {
        int maxPrice = Integer.parseInt(maxPriceStr);
        goodsList = goodsService.selectNamePrice_3(name, maxPrice);
    } else if (minPriceStr != null && !minPriceStr.isEmpty()) {
        int minPrice = Integer.parseInt(minPriceStr);
        goodsList = goodsService.selectByPrice_1(minPrice);
    } else if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
        int maxPrice = Integer.parseInt(maxPriceStr);
        goodsList = goodsService.selectByPrice_2(maxPrice);
    } else {
        goodsList = goodsService.selectAll();
    }

    if (goodsList != null && !goodsList.isEmpty()) {
%>
<h2>查詢結果:</h2>
    <table border="1" width="80%" align="center">
        <tr>
            <th>商品編號</th>
            <th>商品名稱</th>
            <th>價格</th>
            <th>庫存數量</th>
        </tr>
        <% for (Goods goods : goodsList) { %>
        <tr>
            <td><%= goods.getId() %></td>
            <td><%= goods.getName() %></td>
            <td><%= goods.getPrice() %></td>
            <td><%= goods.getQuantity() %></td>
        </tr>
        <% } %>
    </table>
<%  
    } else {
        out.println("<p style='color:red;'>沒有找到符合條件的商品。</p>");
    }
%>

<a href="index.jsp">返回首頁</a>

</body>
</html>
