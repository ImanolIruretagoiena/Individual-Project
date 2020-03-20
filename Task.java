package IndividualProject;

import java.util.Comparator;

public class Task {

	private String title;
	private String dueDate;
	private boolean isComplete;
	private String project;
	
	public Task(String title, String dueDate, String project) {
		
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		isComplete = false;
	}
	
	public String getProject() {
		
		return project;
	}
	
	public void setProject(String newProject) {
		
		project = newProject;
	}
	
	public String getDueDate() {
		
		return dueDate;
	}
	
	public void setDueDate(String newDueDate) {
		
		dueDate = newDueDate;
	}
	
	public String getTitle() {
		
		return title;
	}
	
	public void setTitle(String newTitle) {
		
		title = newTitle;
	}
	
	public boolean isCompleted() {
		
		return isComplete;
	}
	
	public void setCompleted() {
		
		isComplete = true;
	}
	
	public String getDetails() {
		
		return "Task title: " + title + "; Due Date: " + dueDate + "; Project: " + project + "; Completed: " + isComplete;
	}
	
	/*private void setDetails(String title, String dueDate, String project) {
		
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		isComplete = false;
	}
	*/
	
	public static Comparator<Task> TaskProjectComparator = new Comparator<Task>() {
		
		public int compare(Task task1, Task task2) {
			
			String TaskProject1 = task1.getProject().toUpperCase();
			String TaskProject2 = task2.getProject().toUpperCase();
			return TaskProject1.compareTo(TaskProject2);
		}
	};
	
	public static Comparator<Task> TaskDueDateComparator = new Comparator<Task>() {
		
		public int compare(Task task1, Task task2) {
			
			String TaskDueDate1 = task1.getDueDate().toUpperCase();
			String TaskDueDate2 = task2.getDueDate().toUpperCase();
			return TaskDueDate1.compareTo(TaskDueDate2);
		}
	};
}
