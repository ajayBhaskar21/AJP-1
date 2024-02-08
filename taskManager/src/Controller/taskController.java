package Controller;

import Model.Task;
import View.taskViewer;
import java.util.List;
import java.util.ArrayList;

public class taskController {

	private taskViewer view;
	private List<Task> taskList;

	public taskController(taskViewer view) {
		this.view = view;
		taskList = new ArrayList<>();

	}

	public void startMenu() {

		while (true) {
			int val = view.menu();
			if (val == 0) {
				break;
			} else if (val == 1) {
				createTask();
			} else if (val == 2) {
				displayTask();
			} else if (val == 3) {
				updateTask();
			} else if (val == 4) {
				markAsComplete();
			} else {
				System.out.println("Wrong choice");
			}
		}

	}

	public void createTask() {

		String taskTitle = view.taskTitle();

		if (isTaskExists(taskTitle)) {
			System.out.println("task already exists!!!");
		} else {
			view.createNewTask(taskList, taskTitle);
			System.out.println("task created successfully");
		}

	}

	public void displayTask() {
		if (taskList.size() == 0) {
			System.out.println("No tasks!!\n");
			return ;
		}
		view.displayTasks(taskList);
	}

	public void updateTask() {
		String taskTitle = view.taskTitle();

		if (isTaskExists(taskTitle)) {
			for (Task i : taskList) {
				if (i.getTitle().equalsIgnoreCase(taskTitle)) {
					// update the details
					i.setDescription(view.newTaskDescription());
					i.setPriorityLevel(view.newTaskPriority());
					i.setCompletionStatus(false);
					break;
				}
			}
			System.out.println("task details have been updated.");
		} else {
			System.out.println("task title not found!!!");
		}

	}

	public void markAsComplete() {
		String taskTitle = view.taskTitle();

		if (isTaskExists(taskTitle)) {
			for (Task i : taskList) {
				if (i.getTitle().equalsIgnoreCase(taskTitle)) {
					// make this task as completed
					i.setCompletionStatus(true);
					break;
				}
			}
			System.out.println("task has been marked as complete.");
		} else {
			System.out.println("task title not found!!!");
		}
	}

	private boolean isTaskExists(String taskTitle) {
		for (Task i : taskList) {
			if (i.getTitle().equalsIgnoreCase(taskTitle))
				return true;
		}
		return false;
	}

}
