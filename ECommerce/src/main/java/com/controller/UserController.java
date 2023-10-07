package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Cart;
import com.bean.User;
import com.bean.Wishlist;
import com.dao.CartDao;
import com.dao.UserDao;
import com.dao.WishlistDao;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.service.Services;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("sign up"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==false)
			{
				if(request.getParameter("password").equals(request.getParameter("cpassword")))
				{
					User u=new User();
					u.setUsertype(Long.parseLong(request.getParameter("usertype")));
					u.setFname(request.getParameter("fname"));
					u.setLname(request.getParameter("lname"));
					u.setMobile(Long.parseLong(request.getParameter("mobile")));
					u.setEmail(request.getParameter("email"));
					u.setAddress(request.getParameter("address"));
					u.setPassword(request.getParameter("password"));
					UserDao.signupUser(u);
					request.setAttribute("msg", "User SIgn Up Successfully");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Password & Confirm Password Does Not Matched");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email Already Exists");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			User u=UserDao.loginUser(request.getParameter("email"));
			if(u!=null)
			{
				if(u.getPassword().equals(request.getParameter("password")))
				{
					HttpSession session=request.getSession();
					List<Wishlist> list=WishlistDao.getWishlistByUser(u.getUid());
					session.setAttribute("wishlist_count", list.size());
					List<Cart> list1=CartDao.getCartByUser(u.getUid());
					session.setAttribute("cart_count", list1.size());
					session.setAttribute("u", u);
					if(u.getUsertype()==1)
					{
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("seller-index.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Email or Password Is Incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Email or Password Is Incorrect");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login-mobile"))
		{
			User u=UserDao.loginUserMobile(Long.parseLong(request.getParameter("mobile")));
			String mobile=request.getParameter("mobile");
			if(u!=null)
			{
				Random t = new Random();
		    	int minRange = 1000, maxRange= 9999;
	        	int otp = t.nextInt(maxRange - minRange) + minRange;
				try {
					HttpResponse response1 = Unirest.get("https://www.fast2sms.com/dev/bulkV2?authorization=DwF5Auzh16qo3fXC2JMSTcOiyBEZmWH0eR8GIg4NbQrpUnKsjvhz0YwyOCGvHJEFuXRrTc7feDVaM1NA&variables_values="+otp+"&route=otp&numbers="+mobile)
							  .header("cache-control", "no-cache")
							  .asString();
					request.setAttribute("mobile", mobile);
					request.setAttribute("otp", otp);
					request.getRequestDispatcher("otp-mobile.jsp").forward(request, response);
				} catch (UnirestException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				request.setAttribute("msg", "Mobile Not Registered");
				request.getRequestDispatcher("login-mobile.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("change password"))
		{
			HttpSession session=request.getSession();
			User u=(User) session.getAttribute("u");
			if(u.getPassword().equals(request.getParameter("old_password")))
			{
				if(request.getParameter("new_password").equals(request.getParameter("cnew_password")))
				{
					if(!u.getPassword().equals(request.getParameter("new_password")))
					{
						UserDao.changePassword(u.getUid(), request.getParameter("new_password"));
						response.sendRedirect("logout.jsp");
					}
					else
					{
						request.setAttribute("msg", "Your New Password Can't Be Your Old Password");
						request.getRequestDispatcher("change-password.jsp").forward(request, response);
					}
				}
				else
				{
					request.setAttribute("msg", "Your New Password & Confirm New Password Does Not Matched");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("msg", "Old Password Is Incorrect");
				request.getRequestDispatcher("change-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update profile"))
		{
			HttpSession session=request.getSession();
			User u=(User) session.getAttribute("u");
			u.setFname(request.getParameter("fname"));
			u.setLname(request.getParameter("lname"));
			u.setMobile(Long.parseLong(request.getParameter("mobile")));
			u.setAddress(request.getParameter("address"));
			UserDao.updateProfile(u);
			//session.setAttribute("u", u);
			//request.setAttribute("msg", "Profile Updated Successfully");
			//request.getRequestDispatcher("profile.jsp").forward(request, response);
			response.sendRedirect("profile.jsp");
		}
		else if(action.equalsIgnoreCase("send otp"))
		{
			boolean flag=UserDao.checkEmail(request.getParameter("email"));
			if(flag==true)
			{
				Random t = new Random();
		    	int minRange = 1000, maxRange= 9999;
	        	int otp = t.nextInt(maxRange - minRange) + minRange;
	        	Services.sendMail(request.getParameter("email"), otp);
	        	request.setAttribute("email", request.getParameter("email"));
	        	request.setAttribute("otp", otp);
	        	request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "Email Not Registered");
				request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify otp"))
		{
			String email=request.getParameter("email");
			int otp=Integer.parseInt(request.getParameter("otp"));
			int uotp=Integer.parseInt(request.getParameter("uotp"));
			
			if(otp==uotp)
			{
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("email", email);
	        	request.setAttribute("otp", otp);
	        	request.setAttribute("msg", "Invalid OTP");
	        	request.getRequestDispatcher("otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify otp mobile"))
		{
			long mobile=Long.parseLong(request.getParameter("mobile"));
			int otp=Integer.parseInt(request.getParameter("otp"));
			int uotp=Integer.parseInt(request.getParameter("uotp"));
			User u=UserDao.loginUserMobile(mobile);
			if(otp==uotp)
			{
				HttpSession session=request.getSession();
				List<Wishlist> list=WishlistDao.getWishlistByUser(u.getUid());
				session.setAttribute("wishlist_count", list.size());
				List<Cart> list1=CartDao.getCartByUser(u.getUid());
				session.setAttribute("cart_count", list1.size());
				session.setAttribute("u", u);
				if(u.getUsertype()==1)
				{
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("seller-index.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("mobile", mobile);
	        	request.setAttribute("otp", otp);
	        	request.setAttribute("msg", "Invalid OTP");
	        	request.getRequestDispatcher("otp-mobile.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update password"))
		{
			String email=request.getParameter("email");
			
			if(request.getParameter("new_password").equals(request.getParameter("cnew_password")))
			{
				UserDao.updatePassword(email,request.getParameter("new_password"));
				request.setAttribute("msg", "Password Updated Successfully");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute(email, email);
				request.setAttribute("msg", "Your New Password & Confirm New Password Does Not Matched");
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
	}

}
