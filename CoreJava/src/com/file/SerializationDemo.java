package com.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable
{
	int eid;
	String ename;
	double salary;
	public Student(int eid, String ename, double salary) {
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	public String toString() {
		return "Student [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
}

public class SerializationDemo {

	public static void main(String[] args) throws Exception {
		Student s1=new Student(1, "Jigar", 50000);
		FileOutputStream fos=new FileOutputStream("ser");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.flush();
		oos.close();
		
		FileInputStream fis=new FileInputStream("ser");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Student s2=(Student) ois.readObject();
		ois.close();
		System.out.println(s2);
	}
}
