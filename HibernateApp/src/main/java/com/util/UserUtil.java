package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.User;

public class UserUtil {

	public static Session createSession()
	{
		Session session=null;
		SessionFactory sf=new Configuration()
				.addAnnotatedClass(User.class)
				.configure()
				.buildSessionFactory();
		session=sf.openSession();
		return session;
	}
}
