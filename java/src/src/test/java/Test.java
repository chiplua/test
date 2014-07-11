import java.io.*;
import java.util.ArrayList;
import com.chiplua.person.*;
import com.chiplua.factorymode.*;
import com.chiplua.graph.*;

class Test {
	public static void main(String args []) {
		Person person = new Person("zhangsan", 19);
	    Student student = new Student("lisi", 18, "remale");

		Person p1 = new Student("zhaoyi", 14, "male");
		Person p2 = new Worker();
		p1.workPlace();
		p2.workPlace();
		System.out.println("Test:===================================================================");

		
	   	String str = null;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				
		person.study();
		student.studyLanguage();
		student.eat();
		System.out.println("Test: This print line is for test, and it's first line. \n This is second line ");
		System.out.println("Test: The person.name is " + person.name);
		System.out.println("Test: The person.age is " + person.age);

		System.out.println("Test: The student.name is " + student.name);
		System.out.println("Test: The student.age is " + student.age);
		System.out.println("Test: The student.sex is " + student.sex);
		System.out.println("Test: The student.grade is " + student.grade);								   
	   	System.out.println("Test: Please input one number ");
		
	   	try {
			str = input.readLine();
	   	} catch (Exception e) {
			e.printStackTrace();
	   	}			
		//grandle	     
   		System.out.println("Test: The number you input is \"" + str + "\"");


		ArrayList list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add(i + "");
		}
		list.add("hellokitty");
		list.add("whatever you want");
		list.add("wherever you want");
		list.add("whenever you want");
		list.remove("wherever you want");
		list.add("Have removed the 12 data, but this line is 12 data added");
		System.out.println("The list.size() = " + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}



		ProductCreator creator = new ProductCreator();
		creator.creatorProduct("Fan").getName();
		creator.creatorProduct("Mouse").getName();
		

		//Graph gp = new Graph(); //error, Because the class Graph is a abstract class, can't be instantiated
		Rectangular graph = new Rectangular();
		graph.graphShap();
		graph.edgeCount();
	}
}
