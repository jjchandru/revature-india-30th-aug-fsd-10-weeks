package com.revature.app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/annotation")
public class AnnotationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Hello World from annotation configured servlet.");
		String version = (String) getServletContext().getAttribute("version");
		resp.getWriter().write("Version is: " + version + "\n");		
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			resp.getWriter().write("Key: " + cookie.getName() + " Value: " + cookie.getValue() + "\n");
		}
		resp.getWriter().write("Session ID:" + req.getSession().getId() + "\n");
		resp.getWriter().write("Customer ID:" + req.getSession().getAttribute("customerId") + "\n");
	}

}
