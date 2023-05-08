package com.p1;

public class NonDerived {

	public NonDerived() {
		Protection p1=new Protection();
		System.out.println("NonDerived's Constructor");
		System.out.println("n : "+p1.n);
		System.out.println("n_pub : "+p1.n_pub);
		//System.out.println("n_pri : "+p1.n_pri);
		System.out.println("n_pro : "+p1.n_pro);
	}
}
