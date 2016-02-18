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

	private String type;

	public void init(FilterConfig filterConfig) throws ServletException {
		type = filterConfig.getInitParameter("type");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println(type + " Status(Before): "+res.getStatus());
		System.out.println(type + " URL: "+req.getRequestURI());
		
		if(!response.isCommitted())
			chain.doFilter(request, new CustomServletResponseWrapper(res));
		System.out.println(type + " Status(After): "+res.getStatus());
		System.out.println(type + " Is committed: "+res.isCommitted());
	}

	public void destroy() {
	}

}
