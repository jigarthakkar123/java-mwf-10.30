/*
 * Constructor : They are a special member function whose task is to initialize the object of its class.
 * 
 * 1. They have the same name as the class name.
 * 2. They do not have any return type.
 * 3. They are invoked automatically when the objects are created.
 * 
 * Types of Constructor
 * 
 * 1.Default
 * 2.Parameterized
 * 3.Copy
 * 
 * */

package com.fundamental;

class Box
{
	double width,height,depth;
	Box()
	{
		System.out.println("Default Constructor Called");
		width=3;
		height=4;
		depth=5;
	}
	Box(int w,int h,int d)
	{
		System.out.println("Int Parameterized Constructor Called");
		width=w;
		height=h;
		depth=d;
	}
	Box(double w,double h,double d)
	{
		System.out.println("Parameterized Constructor Called");
		width=w;
		height=h;
		depth=d;
	}
	Box(Box b)
	{
		Box b1=new Box();
		System.out.println("Copy Constructor Called");
		width=b.width;
		height=b.height;
		depth=b.depth;
	}
	void volume()
	{
		System.out.println("Volume : "+(width*height*depth));
	}
}

public class ConstructorDemo {

	public static void main(String[] args) {
		Box b1=new Box();
		b1.volume();
		Box b2=new Box(4,5.5,6);
		b2.volume();
		Box b3=new Box(b2);
		b3.volume();
		Box b4=new Box(b3);
		b4.volume();
	}
}
