package View;

import java.util.List;
import java.util.Scanner;

import Model.Task;

public class taskViewer {

	private Scanner in;

	public taskViewer() {
		in = new Scanner(System.in);
	}

	public int menu() {

		System.out.println("\n\n1. Create a new task");
		System.out.println("2. Show the tasks");
		System.out.println("3. Update the tasks");
		System.out.println("4. Mark task as complete");
		System.out.println("0. Exit");

		System.out.print("Enter choice : ");
		int choice = in.nextInt();
		in.nextLine();

		return choice;
//		if (choice == 1) {
//
//		} else if (choice == 2) {
//
//		} else if (choice == 3) {
//
//		} else if (choice == 4) {
//
//		} else if (choice == 0) {
//			
//		}
//		else {
//			System.out.println("Incorrect choice");
//		}

	}

	public void createNewTask(List<Task> taskList, String title) {

		System.out.print("Enter task description : ");
		String description = in.nextLine();
		// in.nextLine();
		System.out.print("Enter task priority level : ");
		int priorityLevel = in.nextInt();
		// in.nextLine();
		// completion status is initially false
		taskList.add(new Task(title, description, priorityLevel, false));

	}

	public void displayTasks(List<Task> taskList) {
		System.out.println("Displaying Task List : \n");

		for (Task i : taskList) {
			System.out.println("Task title : " + i.getTitle());
			System.out.println("Task description : " + i.getDescription());
			System.out.println("Task priority level : " + i.getPriorityLevel());
			System.out.println("Task completion status : " + i.getCompletionStatus());
			System.out.println("\n");
		}

	}

	public String taskTitle() {
		System.out.print("Enter task title : ");
		String title = in.nextLine();
		return title;
	}

	public String newTaskDescription() {
		System.out.print("Enter new task description : ");
		String description = in.nextLine();
		return description;
	}

	public int newTaskPriority() {
		System.out.print("Enter new task priority : ");
		int priority = in.nextInt();
		return priority;
	}

}
