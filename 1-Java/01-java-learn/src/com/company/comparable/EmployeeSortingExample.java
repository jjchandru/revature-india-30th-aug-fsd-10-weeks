package com.company.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EmployeeSortingExample {
	
	public static void main(String args[]) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "John", 27, new Date()));
		employeeList.add(new Employee(2, "Smith", 32, new Date()));
		employeeList.add(new Employee(3, "Beth", 20, new Date()));
		employeeList.add(new Employee(4, "Emma", 45, new Date()));
		employeeList.add(new Employee(5, "Sharon", 22, new Date()));

		// Collections.sort(employeeList);
		Collections.sort(employeeList, new EmployeeNameComparator());
		employeeList.forEach(e -> System.out.println(e.getName()));
	}

}
