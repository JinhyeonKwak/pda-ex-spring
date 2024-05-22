package com.example.shoppingmall.order;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter - init");
	}

	@Override
	public void destroy() {
		System.out.println("Filter - destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();

        System.out.println("Filter Request - " + requestURI);
        chain.doFilter(request, response);
        System.out.println("Filter Response - " + requestURI);
	}
}
