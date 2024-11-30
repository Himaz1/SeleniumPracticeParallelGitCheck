package com.qa.javacoding;

import java.util.ArrayList;
import java.util.Iterator;

public class TestArrayList {
	public static void main (String[] args)
	{
		ArrayList<String> obj = new ArrayList<String>();
		obj.add("Himaz");
		obj.add("Car");
		obj.add("Cricket");
		obj.add("Sports");
		System.out.println(obj.get(1));
		System.out.println("**********");
		for(String print:obj)
		{
			System.out.println(print);
		}
		
		System.out.println("********");
		Iterator<String> it = obj.iterator();
		while (it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
