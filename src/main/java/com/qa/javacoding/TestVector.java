package com.qa.javacoding;

import java.util.Vector;

public class TestVector {
	public static void main(String[] args) {
		Vector<Integer> obj = new Vector<Integer>();
		obj.add(6);
		obj.add(2);
		obj.add(8);
		obj.add(12);
		System.out.println(obj.capacity());
		for(int output:obj)
		{
			System.out.println(output);
		}
	}

}
