package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import service.impl.GoodsServiceImpl;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UpdateController() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		int id = Integer.parseInt(request.getParameter("id"));	
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		new GoodsServiceImpl().update(id, price, quantity);
		GoodsServiceImpl goodsService = new GoodsServiceImpl();
		boolean updateSuccess = goodsService.updateSuccess(id, price, quantity);

		if (updateSuccess) {
            request.getSession().setAttribute("successMessage", "商品更新成功！");
        } else {
            request.getSession().setAttribute("errorMessage", "商品更新失敗！");
        }

        response.sendRedirect("goodsUpdate.jsp");
    }
}
