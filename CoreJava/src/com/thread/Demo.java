package com.thread;

public class Demo extends Thread{

	public Demo() throws Exception {
		super("My Thread");
		System.out.println("1");
		start();
		Thread.sleep(5000);
		System.out.println("2");
	}
	public void run() {
		System.out.println("3");
	}

	public static void main(String[] args) throws Exception {
		new Demo();
	}
}
