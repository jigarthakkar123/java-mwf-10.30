/*
 * Polymorphism :One name multiple form.
 * 
 * 1. Method Overriding(Run time): When there is a same method prototype in your both base class
 * and derived class, and if you call that method using the object of derived class and only
 * derived class method will be called, so you can say that method of derived class overrides the
 * method of base class.
 * 
 * */

package com.fundamental;

class A1
{
	A1()
	{
		System.out.println("A1's Default Constructor");
	}
	void show() 
	{
		System.out.println("Show From A1");
	}
}
class B1 extends A1
{
	B1()
	{
		System.out.println("B1's Default Constructor");
	}
	void show() 
	{
		super.show();
		System.out.println("Show From B1");
	}
}
class C1 extends B1
{
	C1()
	{
		System.out.println("C1's Default Constructor");
	}
	void show() 
	{
		super.show();
		System.out.println("Show From C1");
	}
}

public class ConsChaining {

	public static void main(String[] args) {
		C1 c=new C1();
		c.show();
	}
}
