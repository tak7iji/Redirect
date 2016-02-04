package org.sample.redirect.app.welcome;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;

public class RedirectFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(RedirectFilter.class);

	private String redirectPath;
	private Boolean useSpringSecurity;
	private DefaultRedirectStrategy redirectStrategy;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		redirectStrategy = new DefaultRedirectStrategy();
		redirectStrategy.setContextRelative(true);

		redirectPath = filterConfig.getInitParameter("redirectPath");
		useSpringSecurity = Boolean.valueOf(filterConfig.getInitParameter("useSpringSecurity"));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		if(useSpringSecurity.equals(Boolean.TRUE)) {
			logger.info("Use DefaultRedirectStrategy: [{}]", redirectPath);
			redirectStrategy.sendRedirect(req, res, redirectPath);
		}
		else {
			logger.info("Use HttpServletResponse: [{}]", redirectPath);
			res.sendRedirect(req.getContextPath()+redirectPath);
		}
		if(!response.isCommitted())
			chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
