package IndividualProject;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		display.displayWelcome();
		display.addTask();
		display.addTask();
		display.showDateSortedList();
		display.addTask();
		display.showDateSortedList();
		display.updateTask();
		display.showDateSortedList();
		display.createFile();
		display.writeToFile();
	}

}
