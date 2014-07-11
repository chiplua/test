package com.chiplua.person;
import com.chiplua.person.Person;

public class Worker extends Person{
	public Worker() {
		System.out.println("Worker: Constructor the Worker class");
	}

	public void workPlace() {
		System.out.println("Worker: The Worker work in factory");
	}
}
