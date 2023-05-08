/*
 * Method Overloading : When there is more than one method in a single class having the same
 * name but with different number of arguments and their data types then it is called method
 * overloading.
 * 
 * */

package com.fundamental;

public class MethodOverloading {

	void test()
	{
		System.out.println("test with no argument");
	}
	void test(int a)
	{
		System.out.println("test with 1 int argument");
	}
	void test(int a,int b)
	{
		System.out.println("test with 2 int argument");
	}
	public static void main(String[] args) {
		MethodOverloading m1=new MethodOverloading();
		m1.test();
		m1.test(10);
		m1.test(10,20);
	}
}
