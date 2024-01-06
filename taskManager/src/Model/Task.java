package Model;

public class Task {

	private String title;
	private String description;
	private int priorityLevel;
	private boolean completionStatus;

	public Task(String title, String description, int priorityLevel, boolean completionStatus) {
		super();
		this.title = title;
		this.description = description;
		this.priorityLevel = priorityLevel;
		this.completionStatus = completionStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public boolean isCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

}
