<%@page import="java.util.List"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%@ include file="header.jsp" %>

<%
	int pid=Integer.parseInt(request.getParameter("pid"));
	int uid=u.getUid();
	Wishlist w=new Wishlist();
	w.setPid(pid);
	w.setUid(uid);
	WishlistDao.addToWishlist(w);
	List<Wishlist> list=WishlistDao.getWishlistByUser(uid);
	session.setAttribute("wishlist_count", list.size());
	response.sendRedirect("wishlist.jsp");
%>