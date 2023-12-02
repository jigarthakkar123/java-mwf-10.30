package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.User;
import com.util.UserUtil;

public class UserDao {

	public static void insertUser(User u)
	{
		Session session=UserUtil.createSession();
		Transaction tr=session.beginTransaction();
		session.saveOrUpdate(u);
		tr.commit();
		session.close();
	}
	public static List<User> getAllUser()
	{
		Session session=UserUtil.createSession();
		List<User> list=session.createQuery("from User").list();
		session.close();
		return list;
	}
	public static User getUser(int uid)
	{
		Session session=UserUtil.createSession();
		User u=session.get(User.class, uid);
		session.close();
		return u;
	}
	public static void deleteUser(int uid)
	{
		Session session=UserUtil.createSession();
		Transaction tr=session.beginTransaction();
		User u=session.get(User.class, uid);
		session.delete(u);
		tr.commit();
		session.close();
	}
}
