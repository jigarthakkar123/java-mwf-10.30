<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
   <head>
      <!-- Basic -->
      <meta charset="utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <!-- Mobile Metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
      <!-- Site Metas -->
      <meta name="keywords" content="" />
      <meta name="description" content="" />
      <meta name="author" content="" />
      <link rel="shortcut icon" href="images/favicon.png" type="">
      <title>Famms - Fashion HTML Template</title>
      <!-- bootstrap core css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
      <!-- font awesome style -->
      <link href="css/font-awesome.min.css" rel="stylesheet" />
      <!-- Custom styles for this template -->
      <link href="css/style.css" rel="stylesheet" />
      <!-- responsive style -->
      <link href="css/responsive.css" rel="stylesheet" />
   </head>
   <body>
      <div class="hero_area">
         <!-- header section strats -->
         <header class="header_section">
            <div class="container">
               <nav class="navbar navbar-expand-lg custom_nav-container ">
                  <a class="navbar-brand" href="index.jsp"><img width="250" src="images/logo.png" alt="#" /></a>
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class=""> </span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                     <ul class="navbar-nav">
                        <li class="nav-item active">
                           <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                       
                       <li class="nav-item dropdown">
                           <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="true"> <span class="nav-label">Account <span class="caret"></span></a>
                           <ul class="dropdown-menu">
                           		<%
                           			User u=null;
    		  						if(session!=null)
    		  						{
    		  							if(session.getAttribute("u")!=null)
    		  							{
    		  								u=(User)session.getAttribute("u");
    		  							}
    		  						}
                           		%>
                           		<%
                           			if(u==null)
                           			{
                           		%>
                           				 <li><a href="login.jsp">Login</a></li>
                              			 <li><a href="signup.jsp">Sign Up</a></li>
                           		<%		
                           			}
                           			else
                           			{
                           		%>
                           					<li><a href="profile.jsp">Profile</a></li>
                           					<li><a href="change-password.jsp">Change Password</a></li>
                           					<li><a href="logout.jsp">Logout(<%=u.getFname() %>)</a></li>
                           		<%		
                           			}
                           		%>
                             
                           </ul>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="product.jsp">Add Product</a>
                        </li>
                        <li class="nav-item">
                           <a class="nav-link" href="view-product.jsp">View Product</a>
                        </li>
                       

                        <form class="form-inline">
                           <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit">
                           <i class="fa fa-search" aria-hidden="true"></i>
                           </button>
                        </form>
                     </ul>
                  </div>
               </nav>
            </div>
         </header>
         <!-- end header section -->
         
   </body>
</html>