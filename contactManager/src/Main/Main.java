package Main;

import View.ContactView;
import controller.ContactController;

public class Main {
	public static void main(String[] args) {

		ContactView view = new ContactView();

		ContactController controller = new ContactController(view);

		controller.startMenu();

		System.out.println("\nended\n");

	}
}
