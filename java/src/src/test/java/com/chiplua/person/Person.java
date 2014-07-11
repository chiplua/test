package com.chiplua.person;

public class Person {
	public String name;
	public int	age;

	public Person() {
	    System.out.println("Person: The constructor function");
	}

	public Person(String name, int age) {
	    this.name = name;
		this.age = age;
    }

	public void study() {
			System.out.println("Person: The study() function");
	}

	public void workPlace() {
	}

	// public abstract wearClothes() {
	// }
}     
