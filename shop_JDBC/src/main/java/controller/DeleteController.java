package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import service.impl.GoodsServiceImpl;

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public DeleteController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		new GoodsServiceImpl().delete(id);
		
		GoodsServiceImpl goodsService = new GoodsServiceImpl();
		 if (goodsService.isIdDuplicate(id)) {	    	
	    		
	        	request.getSession().setAttribute("message", "商品刪除成功！");	    		
		    	
	        } else {
	        	request.getSession().setAttribute("errorMessage", "商品ID不存在!");
	            
	        } 	
		    response.sendRedirect("goodsDelete.jsp");
		}
}
