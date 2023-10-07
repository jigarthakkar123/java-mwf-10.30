<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%
	int cid=Integer.parseInt(request.getParameter("cid"));
	int product_qty=Integer.parseInt(request.getParameter("product_qty"));
	Cart c=CartDao.getCart(cid);
	Product p=ProductDao.getProduct(c.getPid());
	c.setProduct_qty(product_qty);
	c.setTotal_price(product_qty*(int)p.getProduct_price());
	CartDao.updateCart(c);
	response.sendRedirect("cart.jsp");
%>