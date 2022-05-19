package com.company.comparable;

import java.util.Date;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private int age;
	private Date dateOfBirth;

	public Employee(int id, String name, int age, Date dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int compareTo(Employee o) {
		System.out.println("this.name: " + this.name);
		System.out.println("other.name: " + o.getName());
		//return this.name.compareTo(o.getName());
		return this.age - o.getAge();
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
