package com.fundamental;

class Student
{
	int rno;
	String sname;
	public Student() {
		System.out.println("Default Constructor Called");
	}
	public Student(int rno,String sname) {
		this();
		this.rno=rno;
		this.sname=sname;
	}
	void show(Student s)
	{
		System.out.println("Roll No : "+s.rno);
		System.out.println("Student Name : "+s.sname);
	}
	void print()
	{
		this.show(this);
	}
	void display()
	{
		System.out.println("Roll No : "+this.rno);
		System.out.println("Student Name : "+this.sname);
	}
}

public class thisDemo {

	public static void main(String[] args) {
		Student s=new Student(1, "Jigar");
		s.display();
		s.print();
	}
}
