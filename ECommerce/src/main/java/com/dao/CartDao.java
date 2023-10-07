package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Cart;
import com.bean.Wishlist;
import com.util.UserUtil;

public class CartDao {

	public static void addToCart(Cart c)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="insert into cart(pid,uid,product_qty,total_price) values(?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getPid());
			pst.setInt(2, c.getUid());
			pst.setInt(3, c.getProduct_qty());
			pst.setInt(4, c.getTotal_price());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void removeFromCart(Cart c)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="delete from cart where pid=? and uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, c.getPid());
			pst.setLong(2, c.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateCart(Cart c)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update cart set product_qty=?,total_price=? where cid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getProduct_qty());
			pst.setInt(2, c.getTotal_price());
			pst.setInt(3, c.getCid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateCartPaymentStatus(int uid)
	{
		boolean flag1=true;
		boolean flag2=false;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update cart set payment_status=? where uid=? and payment_status=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setBoolean(1, flag1);
			pst.setInt(2, uid);
			pst.setBoolean(3, flag2);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<Cart> getCartByUser(int uid)
	{
		boolean flag1=false;
		List<Cart> list=new ArrayList<Cart>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from cart where uid=? and payment_status=? order by cid";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, uid);
			pst.setBoolean(2, flag1);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Cart c=new Cart();
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setUid(rs.getInt("uid"));
				c.setProduct_qty(rs.getInt("product_qty"));
				c.setTotal_price(rs.getInt("total_price"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Cart getCart(int cid)
	{
		Cart c=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from cart where cid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, cid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				c=new Cart();
				c.setCid(rs.getInt("cid"));
				c.setPid(rs.getInt("pid"));
				c.setUid(rs.getInt("uid"));
				c.setProduct_qty(rs.getInt("product_qty"));
				c.setTotal_price(rs.getInt("total_price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public static boolean checkCart(Cart c)
	{
		boolean flag=false;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from cart where uid=? and pid=? and payment_status=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, c.getUid());
			pst.setInt(2, c.getPid());
			pst.setBoolean(3, flag);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
