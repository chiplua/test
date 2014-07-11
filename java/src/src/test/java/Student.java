class Student extends Person {
	int grade;
	String sex;

	Student(){
		System.out.println("Student: The constructor Student() function");
	}

	Student(String name, int age, String sex) {
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

	
