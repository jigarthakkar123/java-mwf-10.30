package com.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ServletConfig config;
	ServletContext context;
	String email,driver;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initialized");
		this.config=config;
		this.context=config.getServletContext();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		email=config.getInitParameter("email");
		out.println("<b>Email : </b>"+email);
		driver=context.getInitParameter("driver");
		out.println("Driver : "+driver);
		
		email=config.getInitParameter("email");
		System.out.println("Email :"+email);
		driver=context.getInitParameter("driver");
		System.out.println("Driver : "+driver);
	}
	
	public void destroy() {
		System.out.println("Servlet Destroyed");
	}
}
