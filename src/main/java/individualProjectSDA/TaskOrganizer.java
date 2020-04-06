package individualProjectSDA;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * A class to hold details of various tasks.
 * Tasks can be added, sorted, printed to console,
 * updated, marked as completed, removed and saved
 * to / loaded from external file.
 * @author ImanolIruretagoiena
 * @version 2020.04.05
 */
public class TaskOrganizer {
	
	//ArrayList for storing tasks.
	private ArrayList<Task> list;
	//Amount of tasks which are not completed.
	long toDoTotal;
	//Amount of tasks which are completed.
	long doneTotal;
	//Scanner for user input.
	Scanner keyboard;
	
	/**
	 * Create a new TaskOrganizer object. Creates a new
	 * empty ArrayList and a new scanner.
	 */
	public TaskOrganizer() {
		list = new ArrayList<>();
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Displays header / title of the application.
	 */
	public void displayApplicationHeader() {
		System.out.println("ToDo List Application" + "\n"  + "\n" + "---------------------" + "\n"
		+ "\n" + "Welcome to ToDoLy" + "\n");
	}
	
	/**
	 * Displays option menu for the user to choose from.
	 */
	public void displayOptionMenu() {
		System.out.println("You have " + toDoTotal + " task(s) todo and " + doneTotal + " task(s) " 
		+ "are done!" + "\n" + "Pick an option:" + "\n" + "(1) Show Task List (by date or project)"
		+ "\n" + "(2) Add New Task" + "\n" + "(3) Edit Task (update, mark as done, remove)" + "\n"
		+ "(4) Save and Quit" + "\n");
	}
	
	/**
	 * Adds new task to the ArrayList. Does not
	 * allow repetition of task titles.
	 */
	public void addTask() {
		System.out.println("Enter task details: " + "\n" + "\n" + "Title: ");
		String title = keyboard.nextLine();
		boolean taskRepeated = false;
		
		for(Task task : list) {	
			if(title.equals(task.getTitle())) {
				taskRepeated = true;
				System.out.println("Task title already exists! Use a different title or select the "
				+ "update task option to edit the details of the task with the entered title." + "\n");
			}
		}
		
		if(taskRepeated == false) {
			
			System.out.println("Due Date (Month/Day): ");
			String dueDate = keyboard.nextLine();
			System.out.println("Project (A, B, C): ");
			String project = keyboard.nextLine();
			list.add(new Task(title, dueDate, project));
			System.out.println("Task added!" + "\n");
		}
	}
	
	/**
	 * Sorts ArrayList by project.
	 */
	public void sortListByProject() {
		System.out.println("Task list by Project:" + "\n");
		Collections.sort(list, Task.TaskProjectComparator);
	}
	
	/**
	 * Sorts ArrayList by due date.
	 */
	public void sortListByDueDate() {
		System.out.println("Task list by Due Date:" + "\n");
		Collections.sort(list, Task.TaskDueDateComparator);
	}
	
	/**
	 * Prints details of all elements in
	 * the ArrayList to the console.
	 */
	public void printList() {
		
		for(Task task :list) {
			System.out.println(task.getDetails());
		}
		System.out.println();
	}
	
	/**
	 * Calculates amount of completed and
	 * incomplete tasks.
	 */
	public void getTotalNumbers() {
		
		toDoTotal = list.stream()
					.filter(task -> false == task.isCompleted())
					.count();
		
		doneTotal = list.stream()
					.filter(task -> true == task.isCompleted())
					.count();		
	}
	
	/**
	 * Updates details of a specific task by asking the
	 * user the title of the task to be updated. If this
	 * title is not found in the ArrayList, an error is shown.
	 * If the user tries to change its title to another one
	 * that already exists in the ArrayList, an error is shown.
	 */
	public void updateTask() {
		
		System.out.println("Enter title of task to be updated: ");
		String taskTitle = keyboard.nextLine();
		boolean taskFound = false;
		
		for(Task task : list) {
			
			if(taskTitle.equals(task.getTitle())) {
				
				taskFound = true;
				System.out.println("Enter new task details: " + "\n" + "\n" + "Title: ");
				String newTitle = keyboard.nextLine();
				boolean taskRepeated = false;
				
				for(Task tasks : list) {
					
					if(newTitle.equals(tasks.getTitle()) && !newTitle.equals(task.getTitle())) {
						taskRepeated = true;
						System.out.println("Another task with this title already exists!" + "\n");
					}
				}
				
				if(taskRepeated == false) {
					
					task.setTitle(newTitle);
					System.out.println("Due Date (Month/Day): ");
					String newDueDate = keyboard.nextLine();
					task.setDueDate(newDueDate);
					System.out.println("Project (A, B, C): ");
					String newProject = keyboard.nextLine();
					task.setProject(newProject);
					System.out.println("Task updated successfully!" + "\n");
				}
			}	
		}
		if(taskFound == false) {
			System.out.println("Task not found!" + "\n");
		}
	}	
	
	/**
	 * Changes the status of the task specified by the user.
	 * If task is not found within the list, an error is shown.
	 */
	public void markAsDone() {
		
		System.out.println("Enter title of task to be marked as done: ");
		String taskTitle = keyboard.nextLine();
		boolean taskFound = false;
		
		for(Task task : list) {
			
			if(taskTitle.equals(task.getTitle())) {
				taskFound = true;
				task.setCompleted();
				System.out.println("Task marked as done!" + "\n");
			}	
		}
		if(taskFound == false) {
			System.out.println("Task not found!" + "\n");
		}
	}
	
	/**
	 * Removes the task specified by the user from the list.
	 * If specified task is not found within the list, an error
	 * is shown.
	 */
	public void removeTask() {
		
		System.out.println("Enter title of task to be removed: ");
		String taskTitle = keyboard.nextLine();
		boolean taskFound = false;
		Iterator<Task> itr = list.iterator();
		
		while(itr.hasNext()) {
			
			Task temp = itr.next();
			if(taskTitle.equals(temp.getTitle())) {
				taskFound = true;
				itr.remove();
				System.out.println("Task removed!" + "\n");
			}
		}
		if(taskFound == false) {
			System.out.println("Task not found!" + "\n");
		}
	}
	
	/**
	 * Checks for specified file in specified directory. If it
	 * doen't exist, it is created. If it exists, a message showing
	 * this is printed.
	 */
	public void createFile(File listFile) {
		
		try {
			if(listFile.createNewFile()) {
				System.out.println("File created: " + listFile.getAbsolutePath() + "\n");
			} else {
				System.out.println("File already exists: " + listFile.getAbsolutePath() + "\n");
			}
		} catch(IOException e){
			System.out.println("An error ocurred." + "\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes details of all elements in the
	 * ArrayList into the specified file and displays
	 * goodbye message.
	 */
	public void saveToFile(FileWriter listWriter) {
		
		try {			
			for(Task task : list) {
				listWriter.write(task.getDetails() + "\n");
			}
			System.out.println("Successfully saved to file!" + "\n" + "Goodbye!");
			listWriter.close();
		
		} catch(IOException e) {
			System.out.println("An error ocurred." + "\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads text from specified file and imports
	 * the data into the ArrayList.
	 */
	public void readFile(File listFile) {
		
		try {
			Scanner fileReader = new Scanner(listFile);
			fileReader.useDelimiter("\\s*:\\s*|\\s*;\\s*|\n");
			
			while(fileReader.hasNext()) {
				fileReader.next();
				String title = fileReader.next();
				fileReader.next();
				String dueDate = fileReader.next();
				fileReader.next();
				String project = fileReader.next();
				fileReader.next();
				boolean isComplete = fileReader.nextBoolean();
				list.add(new Task(title, dueDate, project, isComplete));
			}
			fileReader.close();
			System.out.println("File data imported successfully!" + "\n");
		
		} catch(FileNotFoundException e) {
			System.out.println("File not found!" + "\n");
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the ArrayList of the TaskOrganizer.
	 * @return ArrayList of TaskOrganizer.
	 */
	public ArrayList<Task> getList(){
		return list;
	}
	
	/**
	 * Returns the number of incomplete tasks.
	 * @return Number of incomplete tasks.
	 */
	public long getToDoTotal() {
		return toDoTotal;
	}
}

