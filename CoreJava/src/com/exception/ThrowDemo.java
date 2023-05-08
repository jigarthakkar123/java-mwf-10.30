package com.exception;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowDemo {

	static FileOutputStream fos=null;
	public static void demo() throws ArithmeticException,InputMismatchException,ArrayIndexOutOfBoundsException, FileNotFoundException
	{
		fos=new FileOutputStream("tops1.txt");
		int x;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter X : ");
		x=sc.nextInt();
		if(x>0)
		{
			System.out.println("Square Of "+x+" Is "+(x*x));
		}
		else
		{
			throw new ArithmeticException("Please Enter Positive Value Only");
		}
		
	}
	public static void main(String[] args) throws IOException {
		try{
			demo();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			fos.close();
		}
	}
}
