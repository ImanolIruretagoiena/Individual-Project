package IndividualProject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Display {

	private ArrayList<Task> list;
	int toDoTotal;
	int doneTotal;
	
	public Display() {
		list = new ArrayList<>();
		toDoTotal = 0;
		doneTotal = 0;
	}
	
	public void displayWelcome() {
		
		getTotalNumbers();
		System.out.println("ToDo List Application");
		System.out.println();
		System.out.println("---------------------");
		System.out.println();
		System.out.println("Welcome to ToDoLy");
		System.out.println("You have " + toDoTotal + " tasks todo and " + doneTotal + " tasks are done!");
		System.out.println("Pick an option:");
		System.out.println("(1) Show Task List (by date or project)");
		System.out.println("(2) Add New Task");
		System.out.println("(3) Edit Task (update, mark as done, remove)");
		System.out.println("(4) Save and Quit");
		System.out.println();
	}
		
	public void addTask() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter task details: ");
		System.out.println("Title: ");
		String title = keyboard.nextLine();
		System.out.println("Due Date (Month/Day): ");
		String dueDate = keyboard.nextLine();
		System.out.println("Project (A, B, C): ");
		String project = keyboard.nextLine();
		list.add(new Task(title, dueDate, project));
		System.out.println("Task added!");
		System.out.println();
		
	}
	
	public void showProjectSortedList() {
		
		System.out.println("Task list by Project:");
		System.out.println();
		Collections.sort(list, Task.TaskProjectComparator);
		for(Task task : list) {
			
			System.out.println(task.getDetails());
		}
		System.out.println();
	}
	
	public void showDateSortedList() {
		
		System.out.println("Task list by Due Date:");
		System.out.println();
		Collections.sort(list, Task.TaskDueDateComparator);
		for(Task task : list) {
			
			System.out.println(task.getDetails());
		}
		System.out.println();
	}
	
	public void getTotalNumbers() {
		
		for(Task task : list) {
			
			if(task.isCompleted() == false) {
				
				toDoTotal++;
			} else {
				
				doneTotal++;
			}
		}
	}
	
	
	public void updateTask() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter title of task to be updated: ");
		String taskTitle = keyboard.nextLine();
		for(Task task : list) {
			
			if(taskTitle.equals(task.getTitle())) {
				
				System.out.println("Enter new Task details: ");
				System.out.println();
				System.out.println("Title: ");
				String newTitle = keyboard.nextLine();
				task.setTitle(newTitle);
				System.out.println("Due Date (Month/Day): ");
				String newDueDate = keyboard.nextLine();
				task.setDueDate(newDueDate);
				System.out.println("Project (A, B, C): ");
				String newProject = keyboard.nextLine();
				task.setProject(newProject);
				System.out.println("Task updated successfully!");
				System.out.println();
			}	
		}
	}	
		
	public void markAsDone() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter title of task to be marked as done: ");
		String taskTitle = keyboard.nextLine();
		for(Task task : list) {
			
			if(taskTitle.equals(task.getTitle())) {
				
				task.setCompleted();
				System.out.println("Task set as completed!");
				System.out.println();
			}	
		}
	}
	
	public void removeTask() {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter title of task to be removed: ");
		String taskTitle = keyboard.nextLine();
		Iterator<Task> it = list.iterator();
		while(it.hasNext()) {
			
			Task t = it.next();
			if(taskTitle.equals(t.getTitle())) {
				
				it.remove();
				System.out.println("Task removed!");
				System.out.println();
			}
		}
	}
	
	public void createFile() {
		
		try {
			
			File listFile = new File("/Users/imanoliruretagoiena/Desktop/list.txt");
			if(listFile.createNewFile()) {
				
				System.out.println("File created: " + listFile.getName());
			
			} else {
				
				System.out.println("File already exists.");
			}
		
		} catch(IOException e){
			
			System.out.println("An error ocurred.");
			e.printStackTrace();
		}
	}
	
	public void writeToFile() {
		
		try {
			
			FileWriter listWriter = new FileWriter("/Users/imanoliruretagoiena/Desktop/list.txt");
			for(Task task : list) {
				
				listWriter.write(task.getDetails() + "\n");
			}
			
			System.out.println("Successfully wrote to the file!");
			listWriter.close();
		
		} catch(IOException e) {
			
			System.out.println("An error ocurred.");
			e.printStackTrace();
		}
	}
}
