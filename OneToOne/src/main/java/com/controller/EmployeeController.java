package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.EmployeePersonalInfo;
import com.dao.EmployeeDao;

public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("insert"))
		{
			EmployeePersonalInfo epi=new EmployeePersonalInfo();
			epi.setFname(request.getParameter("fname"));
			epi.setLname(request.getParameter("lname"));
			epi.setEmail(request.getParameter("email"));
			epi.setMobile(Long.parseLong(request.getParameter("mobile")));
			epi.setAddress(request.getParameter("address"));
			
			EmployeeDao.insertEmployeePersonalInfo(epi);
			
			Employee e=new Employee();
			e.setUname(request.getParameter("uname"));
			e.setDname(request.getParameter("dname"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setEpinfo(epi);
			EmployeeDao.insertEmployee(e);
			
			response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("edit"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			Employee e=EmployeeDao.getEmployee(eid);
			request.setAttribute("e", e);
			request.getRequestDispatcher("update.jsp").forward(request, response);
		}
		else if(action.equalsIgnoreCase("update"))
		{
			EmployeePersonalInfo epi=new EmployeePersonalInfo();
			epi.setEpid(Integer.parseInt(request.getParameter("epid")));
			epi.setFname(request.getParameter("fname"));
			epi.setLname(request.getParameter("lname"));
			epi.setEmail(request.getParameter("email"));
			epi.setMobile(Long.parseLong(request.getParameter("mobile")));
			epi.setAddress(request.getParameter("address"));			
			Employee e=new Employee();
			e.setEid(Integer.parseInt(request.getParameter("eid")));
			e.setUname(request.getParameter("uname"));
			e.setDname(request.getParameter("dname"));
			e.setSalary(Double.parseDouble(request.getParameter("salary")));
			e.setEpinfo(epi);
			EmployeeDao.insertEmployee(e);
			
			response.sendRedirect("show.jsp");
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			int eid=Integer.parseInt(request.getParameter("eid"));
			EmployeeDao.deleteEmployee(eid);
			response.sendRedirect("show.jsp");
		}
	}

}
