/*
 * 
 * While Loop
 * 
 * while(condition)
 * {
 * 		body of the loop;
 * }
 * 
 * - Entry Controlled Loop.
 * - No Semicolon after while.
 * - If condition false at first then no execution.
 * 
 * do/while
 * 
 * do
 * {
 * 		body of the loop;
 * }while(condition);
 * 
 * - Exit controlled loop.
 * - Semicolon after while.
 * - If condition false at first still minium one time execution.
 * 
 * 
 * */
package com.fundamental;

import java.util.Scanner;

public class WhileDemo {

	public static void main(String[] args) {
		int n,sum=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter N : ");
		n=sc.nextInt();
		while(n<0)
		{
			sum=sum+n;
			n--;
		}
		System.out.println("Sum : "+sum);
	}
}
