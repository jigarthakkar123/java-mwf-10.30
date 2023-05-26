package com.thread;

class Callback extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
	
}


public class SynchronizationDemo{

	
	public static void main(String[] args) throws InterruptedException {
		Callback c1=new Callback();
		Callback c2=new Callback();
		Callback c3=new Callback();
		
		c1.setPriority(Thread.MAX_PRIORITY);
		c3.setPriority(Thread.MIN_PRIORITY);
		c2.setPriority(Thread.NORM_PRIORITY);
		
		c1.start();
		c2.start();
		c3.start();
		
		
	}	
}
