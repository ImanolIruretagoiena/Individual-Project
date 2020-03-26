package individualProjectSDA;

import java.util.Scanner;

/**
 * Main class for Individual Project.
 * @author Imanol Iruretagoiena
 * @version 2020.03.23
 */
public class Main {
	
	/**
	 * Runs the application.
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskOrganizer taskOrganizer = new TaskOrganizer();
		Scanner keyboard = new Scanner(System.in);
		taskOrganizer.createFile();
		taskOrganizer.readFile();
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
					//display.printByDueDate();
				
				} else if(sortingMethod.equals("Project")) {
					
					taskOrganizer.sortListByProject();
					taskOrganizer.printList();
					//display.printByProject();
				
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
				
				taskOrganizer.saveToFile();
				break;
			
			} else {
				
				System.out.println("Incorrect option!" + "\n");
			}
		}
		keyboard.close();
	}

}

