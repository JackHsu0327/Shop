package config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/EncodeFilter")
public class EncodeFilter extends HttpFilter implements Filter{

	public EncodeFilter() {
		super();
	}
	public void destroy() {
		
	}
	
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException{
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig config) throws ServletException{
		
	}
}
