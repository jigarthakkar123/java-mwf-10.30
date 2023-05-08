/*
 * Final : It is a keyword.
 * - It is used to declare variable, methods & class.
 * - If you declare class as a final then you can't inherit it.
 * - If you declare method as a final then you can't override it.
 * - If you declare variable as a final then you can't change it's value.
 * 
 * */

package com.fundamental;

class f1
{
	final int a;
	f1() {
		a=10;
	}
	void show()
	{
	
	}
}
class f2 extends f1
{
	void show()
	{
		
	}
}
public class FinalKeyword {

}
