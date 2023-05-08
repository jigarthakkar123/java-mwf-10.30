/*
 * 
 * Inheritance : The object of one class aquire the properties of another class is called inheritance.
 * or Creating a new class from an existing class is called inheritance.
 * 1. Single
 * 2. Multilevel
 * 3. Multiple - Not supported through class
 * 4. Hierarchy
 * 5. Hybrid - Not supported through class
 * 
 * */

package com.fundamental;

import java.util.Scanner;

class A
{
	int a;
	void getA()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter A:");
		a=sc.nextInt();
	}
	void putA()
	{
		System.out.println("A : "+a);
	}
}
class B extends A
{
	int b;
	void getB()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter B:");
		b=sc.nextInt();
	}
	void putB()
	{
		System.out.println("B : "+b);
	}
}
class C extends A
{
	int c;
	void getC()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter C:");
		c=sc.nextInt();
	}
	void putC()
	{
		System.out.println("C : "+c);
	}
}
public class InheritanceDemo {

	public static void main(String[] args) {
		B b1=new B();
		C c1=new C();
		c1.getA();
		b1.getB();
		c1.getC();
		b1.putA();
		b1.putB();
		c1.putC();
	}
	
}
