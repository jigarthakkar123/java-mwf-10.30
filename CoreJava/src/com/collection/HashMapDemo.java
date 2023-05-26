package com.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapDemo {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put(101,"Jigar");
		hm.put(908,"Abhishek");
		hm.put(345,"Jitendra");
		hm.put(565,"Anil");
		
		System.out.println(hm);
		System.out.println(hm.get(908));
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		System.out.println(hm.entrySet());
		hm.put(102, "Jignesh");
		System.out.println(hm);
		
		Set set=hm.entrySet();
		Iterator itr=set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	
	}
}
