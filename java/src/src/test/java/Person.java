//package com.chiplua.person;

class Person {
	protected String name;
	public int	age;

	Person() {
	    System.out.println("Person: The constructor function");
	}

	Person(String name, int age) {
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
