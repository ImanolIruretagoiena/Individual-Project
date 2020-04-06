package individualProjectSDA;

import java.util.Comparator;

/**
 * Class that stores details of a task,
 * such as its title, due date, project
 * and whether it is completed or not.
 *  
 * @author ImanolIruretagoiena
 * @version 2020.04.05
 */
public class Task {
	
	//The task's title.
	private String title;
	//The task's due date.
	private String dueDate;
	//Whether the task is completed.
	private boolean isCompleted;
	//The task's project.
	private String project;
	
	/**
	 * Constructor for new objects of class Task added
	 * to the list by the user. If a new task is added to the
	 * list, it is considered that the task is not completed.
	 * @param title Title of the new task.
	 * @param dueDate Due Date of the new task.
	 * @param project Project of the new task.
	 */
	public Task(String title, String dueDate, String project) {
		
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		isCompleted = false;
	}
	
	/**
	 * Constructor for new objects of class Task added when
	 * importing data from a file. File can hold both incomplete
	 * and completed tasks when it's saved, so the fourth parameter
	 * is included to indicate the status of the imported task.
	 * @param title Title of imported task.
	 * @param dueDate Due date of imported task.
	 * @param project Project of imported task.
	 * @param isCompleted Whether imported task is completed or not.
	 */
	public Task(String title, String dueDate, String project, boolean isCompleted) {
		
		this.title = title;
		this.dueDate = dueDate;
		this.project = project;
		this.isCompleted = isCompleted;
	}
	
	/**
	 * Returns project of specified task.
	 * @return Project of task.
	 */
	public String getProject() {
		return project;
	}
	
	/**
	 * Sets new project to the task.
	 * @param newProject New project of task.
	 */
	public void setProject(String newProject) {
		project = newProject;
	}
	
	/**
	 * Returns due date of specified task.
	 * @return Due date of task.
	 */
	public String getDueDate() {
		return dueDate;
	}
	
	/**
	 * Sets new due date to the task.
	 * @param newDueDate New due date of task.
	 */
	public void setDueDate(String newDueDate) {
		dueDate = newDueDate;
	}
	
	/**
	 * Returns title of specified task.
	 * @return Title of task.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets new title to the task.
	 * @param newTitle New title of task.
	 */
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	/**
	 * Returns whether task is completed or not.
	 * @return If task is completed or not.
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	
	/**
	 * Sets task's status to completed.
	 */
	public void setCompleted() {
		isCompleted = true;
	}
	
	/**
	 * Returns a string containing the task's details.
	 * @return Task's details.
	 */
	public String getDetails() {
		return "Task title: " + title + "; Due Date: " + dueDate + "; Project: " 
	            + project + "; Completed: " + isCompleted;
	}
	
	/**
	 * Comparator of tasks based on project.
	 */
	public static Comparator<Task> TaskProjectComparator = new Comparator<Task>() {
		
		public int compare(Task task1, Task task2) {
			String TaskProject1 = task1.getProject().toUpperCase();
			String TaskProject2 = task2.getProject().toUpperCase();
			return TaskProject1.compareTo(TaskProject2);
		}
	};
	
	/**
	 * Comparator of tasks based on due date.
	 */
	public static Comparator<Task> TaskDueDateComparator = new Comparator<Task>() {
		
		public int compare(Task task1, Task task2) {
			String TaskDueDate1 = task1.getDueDate().toUpperCase();
			String TaskDueDate2 = task2.getDueDate().toUpperCase();
			return TaskDueDate1.compareTo(TaskDueDate2);
		}
	};
}
