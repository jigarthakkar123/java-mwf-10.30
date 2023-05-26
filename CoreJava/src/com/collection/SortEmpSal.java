package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortEmpSal implements Comparator<Emp>{

	public int compare(Emp e1, Emp e2) {
		int value=0;
		if(e1.getSal()>e2.getSal())
		{
			value=-1;
		}
		else if(e1.getSal()<e2.getSal())
		{
			value=1;
		}
		else if(e1.getSal()==e2.getSal())
		{
			value=0;
		}
		return value;
	}
	public static void main(String[] args) {
		ArrayList<Emp> list=new ArrayList<Emp>();
		
		Emp e1=new Emp();
		e1.setEid(1);
		e1.setEname("Abhishek");
		e1.setSal(1000000);
		
		Emp e2=new Emp();
		e2.setEid(2);
		e2.setEname("Jitendra");
		e2.setSal(800000);
		
		Emp e3=new Emp();
		e3.setEid(3);
		e3.setEname("Anil");
		e3.setSal(600000);
		
		Emp e4=new Emp();
		e4.setEid(4);
		e4.setEname("Jignesh");
		e4.setSal(700000);
		
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		
		Collections.sort(list, new SortEmpSal());
		for(Emp e:list)
		{
			System.out.println("EID : "+e.getEid()+" ENAME : "+e.getEname()+" SALARY : "+e.getSal());
		}
	}

	
}
