package View;

import java.util.Scanner;

import Model.Student;

public class StudentView {
//	Student student;
//	StudentView(Student student) {
//		this.student = student;
//	}

	public void displayStudentDetails(String name, int id) {
		System.out.println("Student name : " + name);
		System.out.println("Student id : " + id);
	}

//	public void displayStudentDetails() {
//		System.out.println("Student name : " + student.getName());
//		System.out.println("Student id : " + student.getId());
//	}

	public Student createNewStudent() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter student name : ");
		String name = in.next();
		System.out.print("Enter student id : ");
		int id = in.nextInt();
		System.out.println(name + ", " + id);
		return new Student(name, id);
	}

}
