package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Employee;
import com.bean.EmployeePersonalInfo;
import com.bean.User;

public class EmployeeUtil {

	public static Session createSession()
	{
		Session session=null;
		SessionFactory sf=new Configuration()
				.addAnnotatedClass(EmployeePersonalInfo.class)
				.addAnnotatedClass(Employee.class)
				.configure()
				.buildSessionFactory();
		session=sf.openSession();
		return session;
	}
}
