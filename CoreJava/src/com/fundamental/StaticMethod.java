package com.fundamental;

public class StaticMethod {

	static int a=10;
	static int b;
	public static void main(String[] args) {
		meth(12);
		StaticMethod s=new StaticMethod();
	}
	public StaticMethod() {
		System.out.println("Default Constructor");
	}
	{
		System.out.println("Block 2");
	}
	static void meth(int x)
	{
		System.out.println("X : "+x);
		System.out.println("A : "+a);
		System.out.println("B : "+b);
	}
	{
		System.out.println("Block 1");
	}
	static
	{
		System.out.println("Static Block Initialized");
		b=a*4;
	}
	
	
}
