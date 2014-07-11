package com.chiplua.person;
import com.chiplua.person.*;

public class Student extends Person {
	public int grade;
	public String sex;

	public Student(){
		System.out.println("Student: The constructor Student() function");
	}

	public Student(String name, int age, String sex) {
		super(name, age);
		this.sex = sex;
	}

	public void studyLanguage() {
		System.out.println("Student: stuydyLanguage() function");
		System.out.println("Student: Verygood function for test");
		System.out.println("Student: This a the studyLanguage function");
	} 
						

	public void eat() {
		System.out.println("Student: The eat() function");
	}

	public void workPlace() {
		System.out.println("Student: The student study at school");
	}
}		

	
