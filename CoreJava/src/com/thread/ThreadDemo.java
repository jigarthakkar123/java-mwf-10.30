package com.thread;

class NewThread implements Runnable
{
	Thread t;
	public NewThread() {
		t=new Thread(this,"Child Thread");
		t.start();
	}
	public void run() {
		for(int i=0;i<5;i++)
		{
			System.out.println(t+" : "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Child Thread Exiting");
	}
	
}

public class ThreadDemo {

	public static void main(String[] args) throws Exception {
		new NewThread();
		Thread t=Thread.currentThread();
		System.out.println(t);
		t.setName("My Thread");
		System.out.println(t);
		t.setPriority(3);
		System.out.println(t);
		for(int i=0;i<5;i++)
		{
			System.out.println(t+" : "+i);
			Thread.sleep(1000);
		}
		System.out.println("My Thread Exiting");
	}
}
