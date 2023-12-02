package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("login"))
		{
			if(!request.getParameter("email").equals(""))
			{
				if(!request.getParameter("password").equals(""))
				{
					if(request.getParameter("email").equals("tops") && request.getParameter("password").equals("tops"))
					{
						//response.sendRedirect("success.jsp");
						request.setAttribute("msg", "Logged In Successfully");
						request.getRequestDispatcher("success.jsp").forward(request, response);
						
					}
					else
					{
						request.setAttribute("msg", "Email or Password Is Incorrect");
						request.getRequestDispatcher("login.jsp").include(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Password Is Missing");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email Is Missing");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}
	}

}
