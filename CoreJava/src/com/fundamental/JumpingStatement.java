package com.fundamental;

public class JumpingStatement {

	public static void main(String[] args) {
		int i,j;
		for(i=0;i<10;i++)
		{
			for(j=0;j<=i;j++)
			{
				if(j==5)
				{
					continue;
				}
				else
				{
					System.out.println("J : "+j);
				}
			}
		}
	}
}
