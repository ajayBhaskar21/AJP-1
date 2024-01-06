package Main;

import Controller.taskController;
import View.taskViewer;

public class Main {

	public static void main(String[] args) {

		// menu should be displayed by view but it should be controlled by controller

		// create view object
		taskViewer view = new taskViewer();

		// create controller object
		taskController controller = new taskController(view);

		controller.startMenu();

		System.out.println("\nended\n");
	}

}
