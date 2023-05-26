package com.collection;

public class Demo {

	public static void main(String[] args) {
		String s1="TOPS1";
		String s2="tops1";
		
		if(s1.equalsIgnoreCase(s2))
		{
			System.out.println("True");
		}
		else
		{
			System.out.println("False");
		}
		int counter=0;
		for(int i=0;i<255;i++)
		{
			System.out.print(" "+i+" - "+(char)i);
			if(counter==10 || counter==20 || counter==30 || counter==40 || counter==50 || counter==60)
			{
				System.out.println();
			}
		}
	}
}
