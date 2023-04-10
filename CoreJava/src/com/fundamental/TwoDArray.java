package com.fundamental;

import java.util.Scanner;

public class TwoDArray {

	public static void main(String[] args) {
		int a[][]=new int[3][3];
		int b[][]=new int[3][3];
		int i,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 2 D Array A");
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a.length;j++)
			{
				System.out.print("Enter "+i+" Row & "+j+" Column : ");
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("2 D Array A Is");
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a.length;j++)
			{
				System.out.print(" "+a[i][j]);
			}
			System.out.println();
		}
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a.length;j++)
			{
				b[i][j]=a[j][i];
			}
			System.out.println();
		}
		System.out.println("2 D Array B Is");
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a.length;j++)
			{
				System.out.print(" "+b[i][j]);
			}
			System.out.println();
		}
	}
}
