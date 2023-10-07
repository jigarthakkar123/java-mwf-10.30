<%@page import="com.dao.CartDao"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="com.bean.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%@ include file="header.jsp" %>

<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=u.getUid();
	Product p=ProductDao.getProduct(pid);
	double product_price=p.getProduct_price();
	int product_qty=1;
	Cart c=new Cart();
	c.setPid(pid);
	c.setUid(uid);
	c.setProduct_qty(1);
	c.setTotal_price((int)product_price);
	CartDao.addToCart(c);
	List<Cart> list=CartDao.getCartByUser(uid);
	session.setAttribute("cart_count", list.size());
	response.sendRedirect("cart.jsp");
%>