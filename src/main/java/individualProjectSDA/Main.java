package individualProjectSDA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class for Individual Project.
 * @author ImanolIruretagoiena
 * @version 2020.04.05
 */
public class Main {
	
	/**
	 * Runs the application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		
		TaskOrganizer taskOrganizer = new TaskOrganizer();
		Scanner keyboard = new Scanner(System.in);
		taskOrganizer.createFile(new File("list.txt"));
		taskOrganizer.readFile(new File("list.txt"));
		taskOrganizer.displayApplicationHeader();
		while(true) {
			
			taskOrganizer.getTotalNumbers();
			taskOrganizer.displayOptionMenu();
			System.out.println("Select option(1, 2, 3 or 4): ");
			int operation = keyboard.nextInt();
			
			if(operation == 1) {
				
				System.out.println("Select sorting method(Due Date or Project): ");
				keyboard.nextLine();
				String sortingMethod = keyboard.nextLine();
				
				if(sortingMethod.equals("Due Date")) {
					taskOrganizer.sortListByDueDate();
					taskOrganizer.printList();
				} else if(sortingMethod.equals("Project")) {
					taskOrganizer.sortListByProject();
					taskOrganizer.printList();
				} else {
					System.out.println("Incorrect sorting method!" + "\n");
				}
			
			} else if(operation == 2) {
				taskOrganizer.addTask();
			} else if(operation == 3) {
				
				System.out.println("Select edit operation(Update, Mark As Done or Remove): ");
				keyboard.nextLine();
				String editOperation = keyboard.nextLine();
				
				if(editOperation.equals("Update")) {	
					taskOrganizer.updateTask();
				} else if(editOperation.equals("Mark As Done")) {
					taskOrganizer.markAsDone();
				} else if(editOperation.equals("Remove")) {
					taskOrganizer.removeTask();
				} else {
					System.out.println("Incorrect operation!" + "\n");
				}
			
			} else if(operation == 4) {
				try{
					taskOrganizer.saveToFile(new FileWriter("list.txt"));
				} catch(IOException e) {
					System.out.println("File not found!" + "\n");
				}
				break;
			} else {
				System.out.println("Incorrect option!" + "\n");
			}
		}
		keyboard.close();
	}

}

