package org.sample.redirect.simple;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("Initialze ForwardServlet");
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("URI: "+req.getRequestURI());
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("default2");
		rd.forward(req, res);
	}

}
