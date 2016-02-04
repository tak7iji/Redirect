package org.sample.redirect.simple;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingFilter implements Filter {
	private ServletContext servletContext;

	public void init(FilterConfig filterConfig) throws ServletException {
		servletContext = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("Request path: "+req.getRequestURI());
		if(servletContext.getMajorVersion() >= 3)
			System.out.println("Status code(before): "+res.getStatus());
		
		if(!response.isCommitted())
			chain.doFilter(request, response);

		if(servletContext.getMajorVersion() >= 3)
			System.out.println("Status code(after): "+res.getStatus());
	}

	public void destroy() {
	}

}
