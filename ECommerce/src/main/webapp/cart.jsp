<%@page import="com.dao.CartDao"%>
<%@page import="com.bean.Cart"%>
<%@page import="com.dao.WishlistDao"%>
<%@page import="com.bean.Wishlist"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
   <head>
      <style type="text/css">
	.bttnStyle
	{
		background-color: lightblue;
		border-radius: 0.50rem;
		border:1px solid transperent;
	}
</style>
   </head>
   <body>
      <div class="hero_area">
      
      <!-- product section -->
      <section class="product_section layout_padding">
         <div class="container">
            <div class="heading_container heading_center">
            <%
            	int net_price=0; 
            	List<Cart> list=CartDao.getCartByUser(u.getUid());
            	if(list.size()>0)
            	{
            %>
               <h2>
                  My <span>Cart</span>
               </h2>
             <%
            	}
            	else
            	{
             %>
             	<h2>
                  No Products In Cart
               </h2>
             <%
            	}
             %>
            </div>
            <div class="row">
            <%
            	
            	for(Cart c:list)
            	{
            		net_price=net_price+c.getTotal_price();
            		Product p=ProductDao.getProduct(c.getPid());
            %>
               <div class="col-sm-6 col-md-4 col-lg-4">
                  <div class="box">
                 
                     <div class="img-box">
                        <img src="product_images/<%=p.getProduct_image() %>" alt="">
                     </div>
                     <div class="detail-box">
                        <h5>
                           <%=p.getProduct_category() %>
                        </h5>
                        <h6>
                           Price : <%=p.getProduct_price() %>
                        </h6>
                     </div>
                     <div class="detail-box">
                        <form method="post" action="change-qty.jsp">
                        	<input type="hidden" name="cid" value="<%=c.getCid()%>">
                        	Qty : <input type="number" min="1" max="10" name="product_qty" value="<%=c.getProduct_qty()%>" onchange="this.form.submit();">
                        </form>
                        <h6>
                           Total Price : <%=c.getTotal_price() %>
                        </h6>
                     </div>
                  </div>
               </div>
             <%
            	}
             %>
            </div>
            <div class="btn-box">
               <a href="">
               Net Price : <%=net_price %>
               </a>
               <form>
					<input type="text" id="amount" name="amount" value="<%=net_price%>">
				</form>
                <button id="payButton" onclick="CreateOrderID()" class="bttnStyle">Pay Now</button>
            </div>
         </div>
      </section>
      <!-- end product section -->

      
      <!-- footer start -->
      <footer>
         <div class="container">
            <div class="row">
               <div class="col-md-4">
                   <div class="full">
                      <div class="logo_footer">
                        <a href="#"><img width="210" src="images/logo.png" alt="#" /></a>
                      </div>
                      <div class="information_f">
                        <p><strong>ADDRESS:</strong> 28 White tower, Street Name New York City, USA</p>
                        <p><strong>TELEPHONE:</strong> +91 987 654 3210</p>
                        <p><strong>EMAIL:</strong> yourmain@gmail.com</p>
                      </div>
                   </div>
               </div>
               <div class="col-md-8">
                  <div class="row">
                  <div class="col-md-7">
                     <div class="row">
                        <div class="col-md-6">
                     <div class="widget_menu">
                        <h3>Menu</h3>
                        <ul>
                           <li><a href="#">Home</a></li>
                           <li><a href="#">About</a></li>
                           <li><a href="#">Services</a></li>
                           <li><a href="#">Testimonial</a></li>
                           <li><a href="#">Blog</a></li>
                           <li><a href="#">Contact</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-md-6">
                     <div class="widget_menu">
                        <h3>Account</h3>
                        <ul>
                           <li><a href="#">Account</a></li>
                           <li><a href="#">Checkout</a></li>
                           <li><a href="#">Login</a></li>
                           <li><a href="#">Register</a></li>
                           <li><a href="#">Shopping</a></li>
                           <li><a href="#">Widget</a></li>
                        </ul>
                     </div>
                  </div>
                     </div>
                  </div>     
                  <div class="col-md-5">
                     <div class="widget_menu">
                        <h3>Newsletter</h3>
                        <div class="information_f">
                          <p>Subscribe by our newsletter and get update protidin.</p>
                        </div>
                        <div class="form_sub">
                           <form>
                              <fieldset>
                                 <div class="field">
                                    <input type="email" placeholder="Enter Your Mail" name="email" />
                                    <input type="submit" value="Subscribe" />
                                 </div>
                              </fieldset>
                           </form>
                        </div>
                     </div>
                  </div>
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- footer end -->
      <div class="cpy_">
         <p class="mx-auto">© 2021 All Rights Reserved By <a href="https://html.design/">Free Html Templates</a><br>
         
            Distributed By <a href="https://themewagon.com/" target="_blank">ThemeWagon</a>
         
         </p>
      </div>
      <!-- jQery -->
      <script src="js/jquery-3.4.1.min.js"></script>
      <!-- popper js -->
      <script src="js/popper.min.js"></script>
      <!-- bootstrap js -->
      <script src="js/bootstrap.js"></script>
      <!-- custom js -->
      <script src="js/custom.js"></script>
      <script type="text/javascript">
	var xhttp=new XMLHttpRequest();
	var RazorpayOrderId;
	function CreateOrderID()
	{
		xhttp.open("GET","http://localhost:8082/ECommerce/OrderCreation",false);
		xhttp.send();
		RazorpayOrderId=xhttp.responseText;
		OpenCheckOut();
	}
</script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript">
	
	
	function OpenCheckOut()
	{
		var a_amount=document.getElementById("amount").value;
		var amount=a_amount*100;
		var options={
				"key":"rzp_test_M2570fHzxsVczK",
				"amount":amount,
				"currency":"INR",
				"name":name,
				"description":"Test",
				"callback_url":"http://localhost:8082/ECommerce/index.jsp?id=<%=u.getUid()%>",
				"prefill":{
					"name":"Jigar Thakkar",
					"email":"jigar.thakkar.tops@gmail.com",
					"contact":"9377614772"
				},
				"notes":{
					"address":"Gandhinagar"
				},
				"theme":{
					"color":"#3399cc"
				}
				
				
		};
		var rzp1=new Razorpay(options);
		rzp1.on('payment.failed',function (response){
			alert(response.error.code);
	        alert(response.error.description);
	        alert(response.error.source);
	        alert(response.error.step);
	        alert(response.error.reason);
	        alert(response.error.metadata.order_id);
	        alert(response.error.metadata.payment_id);
		});
		rzp1.open();
	    e.preventDefault();
	}
</script>
   </body>
</html>