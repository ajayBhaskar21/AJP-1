package Main;

import java.util.Scanner;
import Controller.StudentController;
import View.StudentView;

public class Main {

	public static void main(String[] args) {
		// view object
		StudentView view = new StudentView();

		// controller object
		StudentController controller = new StudentController(view);

		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("\n\n1. Create student.");
			System.out.println("2. View student details");
			System.out.println("3. exit.");
			System.out.println("Enter your choice : ");

			int choice = in.nextInt();
			if (choice == 1) {
				controller.createStudent();
			} else if (choice == 2) {
				controller.displayView();
			} else if (choice == 3) {
				System.exit(1);
			} else {
				System.out.println("Wrong choice");
			}

		}

	}

}
