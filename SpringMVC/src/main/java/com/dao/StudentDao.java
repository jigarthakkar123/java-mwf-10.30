package com.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Student;

public class StudentDao{

	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insertStudent(Student s)
	{
		hibernateTemplate.saveOrUpdate(s);
	}
	public List<Student> getAllStudent()
	{
		return hibernateTemplate.loadAll(Student.class);
	}
	public Student getStudent(int id)
	{
		return hibernateTemplate.get(Student.class,id);
	}
	@Transactional
	public void deleteStudent(int id)
	{
		Student s=hibernateTemplate.get(Student.class,id);
		hibernateTemplate.delete(s);
	}
}
