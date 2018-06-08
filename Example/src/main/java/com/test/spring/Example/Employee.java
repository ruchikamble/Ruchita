package com.test.spring.Example;

public class Employee
{
	Address address;
	String name;
	int age;
	
	public Employee() {
		
	}

	public Employee(Address address, String name, int age) {
		super();
		this.address = address;
		this.name = name;
		this.age = age;
	}
	
	public void show()
	{
		System.out.println(age+ " "+name);
		System.out.println(address.toString());
	}

}
