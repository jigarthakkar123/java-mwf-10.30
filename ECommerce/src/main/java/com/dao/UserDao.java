package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {

	public static void signupUser(User u)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="insert into usr(fname,lname,email,mobile,address,password,usertype) values(?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getPassword());
			pst.setLong(7, u.getUsertype());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean checkEmail(String email)
	{
		boolean flag=false;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from usr where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
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
	public static User loginUser(String email)
	{
		User u=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from usr where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setUsertype(rs.getLong("usertype"));
				u.setUid(rs.getInt("uid"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getLong("mobile"));
				u.setAddress(rs.getString("address"));
				u.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static User loginUserMobile(long mobile)
	{
		User u=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from usr where mobile=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setLong(1, mobile);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setUsertype(rs.getLong("usertype"));
				u.setUid(rs.getInt("uid"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setEmail(rs.getString("email"));
				u.setMobile(rs.getLong("mobile"));
				u.setAddress(rs.getString("address"));
				u.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static void changePassword(int uid,String password)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update usr set password=? where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, uid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updatePassword(String email,String password)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update usr set password=? where email=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateProfile(User u)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update usr set fname=?,lname=?,mobile=?,address=? where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setLong(3, u.getMobile());
			pst.setString(4, u.getAddress());
			pst.setInt(5, u.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
