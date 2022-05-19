package com.company.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSortingExample {

	public static void main(String[] args) {
		List<String> nameList = new ArrayList<>();
		nameList.add("John");
		nameList.add("Smith");
		nameList.add("Beth");
		nameList.add("Emma");
		nameList.add("Sharon");

		Collections.sort(nameList);
		System.out.println(nameList);
	}

}
