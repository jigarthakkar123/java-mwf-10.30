package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Product;
import com.util.UserUtil;

public class ProductDao {

	public static void addProduct(Product p)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="insert into product(product_name,product_category,product_price,product_desc,product_image,uid) values(?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_name());
			pst.setString(2,p.getProduct_category());
			pst.setDouble(3, p.getProduct_price());
			pst.setString(4, p.getProduct_desc());
			pst.setString(5, p.getProduct_image());
			pst.setLong(6, p.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteProduct(int pid)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="delete from product where pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, pid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateProduct(Product p)
	{
		String sql="";
		try {
			Connection conn=UserUtil.createConnection();
			if(p.getProduct_image().equals(""))
			{
				sql="update product set product_name=?,product_category=?,product_desc=?,product_price=? where pid=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, p.getProduct_name());
				pst.setString(2,p.getProduct_category());
				pst.setDouble(4, p.getProduct_price());
				pst.setString(3, p.getProduct_desc());
				pst.setLong(5, p.getPid());
				pst.executeUpdate();
			}
			else
			{
				sql="update product set product_name=?,product_category=?,product_desc=?,product_price=?,product_image=? where pid=?";
				PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, p.getProduct_name());
				pst.setString(2,p.getProduct_category());
				pst.setDouble(4, p.getProduct_price());
				pst.setString(3, p.getProduct_desc());
				pst.setString(5, p.getProduct_image());
				pst.setLong(6, p.getPid());
				pst.executeUpdate();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Product> getProductsBySeller(int uid)
	{
		List<Product> list=new ArrayList<Product>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from product where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setPid(rs.getInt("pid"));
				p.setUid(rs.getInt("uid"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_desc(rs.getString("product_desc"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static List<Product> getAllProducts()
	{
		List<Product> list=new ArrayList<Product>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from product";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setPid(rs.getInt("pid"));
				p.setUid(rs.getInt("uid"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_desc(rs.getString("product_desc"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static Product getProduct(long pid)
	{
		Product p=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from product where pid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, pid);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				p=new Product();
				p.setPid(rs.getInt("pid"));
				p.setUid(rs.getInt("uid"));
				p.setProduct_category(rs.getString("product_category"));
				p.setProduct_desc(rs.getString("product_desc"));
				p.setProduct_image(rs.getString("product_image"));
				p.setProduct_name(rs.getString("product_name"));
				p.setProduct_price(rs.getInt("product_price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
