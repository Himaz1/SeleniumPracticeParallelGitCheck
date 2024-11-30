package com.qa.javacollection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<Object> obj = new ArrayList<Object>();
		obj.add(87);
		obj.add(4.0);
		obj.add("Himaz");
		obj.add(0.05);
		System.out.println(obj.size());
		for(Object out:obj)
		{
			System.out.println(out);
		}
	}

}
