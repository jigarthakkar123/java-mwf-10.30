package com.spring.SpringHello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext a=new ClassPathXmlApplicationContext("Beans.xml");
    	Student student=a.getBean("s1",Student.class);
    	//student.setEmail("jigar93776@gmail.com");
    	System.out.println(student);
    	a.registerShutdownHook();
    }
}
