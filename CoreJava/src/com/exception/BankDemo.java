package com.exception;

import java.util.Scanner;

public class BankDemo {

	public static void main(String[] args) {
		CheckingAccount c=new CheckingAccount(101, "Jigar", 1000);
		double amount;
		while(true) {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			Scanner sc=new Scanner(System.in);
			System.out.print("Enter Your Choice : ");
			int choice=sc.nextInt();
			
			if(choice==1)
			{
				System.out.print("Enter Deposit Amount : ");
				amount=sc.nextDouble();
				c.deposit(amount);
			}
			else if(choice==2)
			{
				System.out.print("Enter Withdrawal Amount : ");
				amount=sc.nextDouble();
				try {
					c.withdraw(amount);
				}catch (InSufficientFund e) {
					System.out.println("Sorry You Need Another "+e.getAmount()+" Rs.");
				}
			}
			else if(choice==3)
			{
				c.checkBalance();
			}
			else
			{
				System.out.println("Thank You For Using Our Services");
				break;
			}
		}
	}
}
