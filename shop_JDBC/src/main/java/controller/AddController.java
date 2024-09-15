package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import service.impl.GoodsServiceImpl;

@WebServlet("/AddController")
public class AddController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AddController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
	    String price = request.getParameter("price");
	    String quantity = request.getParameter("quantity");
	    
	    GoodsServiceImpl goodsService = new GoodsServiceImpl();
	    if (goodsService.isNameDuplicate(name)) {
	    	request.getSession().setAttribute("errorMessage", "商品名稱已存在，請使用其他名稱");
            response.sendRedirect("goodsAdd.jsp");
        } else {
	    try {
	    	Integer priceInt = Integer.parseInt(price);
            Integer quantityInt = Integer.parseInt(quantity);
            
            Goods g = new Goods(null, name, priceInt, quantityInt);
            new GoodsServiceImpl().addGoods(g);
    	    
            request.getSession().setAttribute("message", "商品新增成功！");
    	    response.sendRedirect("goodsAdd.jsp");
	    }	catch (NumberFormatException e) {
	    	response.getWriter().println("Invalid input for price or quantity.");
	    	}	    
        }
	}
}
