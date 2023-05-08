package com.fundamental;

abstract class RBI
{
	void meth()
	{
		
	}
	abstract void roi(double r);
}
class SBI extends RBI
{
	void roi(double r) {
		System.out.println("Rate Of Interest By SBI : "+r);
	}
}
class BOI extends RBI
{
	void roi(double r) {
		System.out.println("Rate Of Interest By BOI : "+r);
	}
}
public class AbstractClass {

	public static void main(String[] args) {
		SBI s=new SBI();
		BOI b=new BOI();
		
		s.roi(7.5);
		b.roi(6.5);
	}
}
