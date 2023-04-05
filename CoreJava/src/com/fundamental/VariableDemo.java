/*
 * Data Type:
 * 
 * 1. byte - 1byte
 * 2. short - 2byte
 * 3. int - 4byte
 * 4. long - 8byte
 * 5. float - 4byte
 * 6. double - 8byte
 * 7. char - 'a',' ',';' 1byte
 * 8. boolean - true/false
 * 
 * Variable : It is a data name & is used to store the data value.
 * 
 * int a=10;
 * 
 * Rules : 
 * 
 * 1. Must start with an alphabet.
 * 2. Uppercase & lowercase are significant
 * 
 * ASCII : American Standard Code For Information Interchange
 * 
 * A-Z : 65 to 90
 * a-z : 97 to 122
 * 
 * 3. Keyword is not allowed as a variable name.
 * 4. Space is not allowed between variable name.
 * 
 * */

package com.fundamental;

import java.util.Scanner;

public class VariableDemo {

	public static void main(String[] args) {
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter A : ");
		a=sc.nextInt();
		System.out.print("Enter B : ");
		b=sc.nextInt();
		c=a+b;
		System.out.println("Addition : "+c);
		c=a-b;
		System.out.println("Subtraction : "+c);
		c=a*b;
		System.out.println("Multiplication : "+c);
		c=a/b;
		System.out.println("Division : "+c);
	}
}
