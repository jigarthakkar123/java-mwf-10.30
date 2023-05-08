package com.p1;

public class Protection {

	int n=10;
	public int n_pub=20;
	private int n_pri=30;
	protected int n_pro=40;
	
	public Protection() {
		System.out.println("Protection's Constructor");
		System.out.println("n : "+n);
		System.out.println("n_pub : "+n_pub);
		System.out.println("n_pri : "+n_pri);
		System.out.println("n_pro : "+n_pro);
	}
	
}
