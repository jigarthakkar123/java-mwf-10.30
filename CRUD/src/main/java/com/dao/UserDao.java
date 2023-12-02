package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {

	public static void insertUser(User u)
	{
		try {
			Connection conn=UserUtil.createConnection();
			String sql="insert into usr(fname,lname,email,mobile,gender,address,password) values(?,?,?,?,?,?,?)";
			System.out.println("pst");
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getGender());
			pst.setString(6, u.getAddress());
			pst.setString(7, u.getPassword());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<User> getAllUser()
	{
		List<User> list=new ArrayList<User>();
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from usr";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setUid(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getLong(5));
				u.setAddress(rs.getString(7));
				u.setGender(rs.getString(6));
				u.setPassword(rs.getString(8));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static User getUser(int uid)
	{
		User u=null;
		try {
			Connection conn=UserUtil.createConnection();
			String sql="select * from usr where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				u=new User();
				u.setUid(rs.getInt(1));
				u.setFname(rs.getString(2));
				u.setLname(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getLong(5));
				u.setAddress(rs.getString(7));
				u.setGender(rs.getString(6));
				u.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	public static void updateUser(User u) {
		try {
			Connection conn=UserUtil.createConnection();
			String sql="update usr set fname=?,lname=?,email=?,mobile=?,gender=?,address=?,password=? where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getGender());
			pst.setString(6, u.getAddress());
			pst.setString(7, u.getPassword());
			pst.setInt(8, u.getUid());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteUser(int uid) {
		try {
			Connection conn=UserUtil.createConnection();
			String sql="delete from usr where uid=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, uid);
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
