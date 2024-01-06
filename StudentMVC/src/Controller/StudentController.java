package Controller;

import Model.Student;
import View.StudentView;

public class StudentController {

	private Student student;
	private StudentView studentView;

	public StudentController(Student student, StudentView studentView) {
		this.student = student;
		this.studentView = studentView;
	}

	public StudentController(StudentView studentView) {
		this.studentView = studentView;
	}

	public void displayView() {
		studentView.displayStudentDetails(student.getName(), student.getId());
	}

	public void createStudent() {
		student = studentView.createNewStudent();
		System.out.println("Student created");
		
	}

}
