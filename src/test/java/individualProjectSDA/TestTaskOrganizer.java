package individualProjectSDA;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;

/**
 * Test class for testing of TaskOrganizer class methods.
 * @author ImanolIruretagoiena
 * @version 2020.04.05
 */
public class TestTaskOrganizer {

	//Field for TaskOrganizer objects.
	TaskOrganizer testTaskOrganizer;
	//Default input inlet.
	InputStream standardInput = System.in;
	//Test file for test methods.
	File testfile;
	
	/**
	 * Test which shows adding a new Task successfully
	 * into an empty list.
	 */
	@Test
	public void testAddTaskIntoEmptyList() {
		
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		testTaskOrganizer = new TaskOrganizer();
		testTaskOrganizer.addTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(1, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows adding a new Task successfully
	 * into a non empty list.
	 */
	@Test
	public void testAddTaskIntoNonEmptyList() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
					+ "Cooking" + "\n" + "04/15" +"\n" + "D";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		testTaskOrganizer = new TaskOrganizer();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(2, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows how trying to add a Task which already
	 * exists in the list will fail.
	 */
	@Test
	public void testAddTaskWhichAlreadyExists() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
					+ "Cleaning" + "\n" + "04/15" + "\n" + "D";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		testTaskOrganizer = new TaskOrganizer();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(1, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Method for adding multiple elements to the testTaskOrganizer.
	 */
	public void addMultipleElements() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		testTaskOrganizer = new TaskOrganizer();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
	}
	
	/**
	 * Test which shows successful sorting of tasks based on project.
	 */
	@Test
	public void testSortListByProject() {
		addMultipleElements();
		testTaskOrganizer.sortListByProject();
		String result = testTaskOrganizer.getList().get(0).getProject();
		assertEquals("A", result);
		result = testTaskOrganizer.getList().get(1).getProject();
		assertEquals("A", result);
		result = testTaskOrganizer.getList().get(2).getProject();
		assertEquals("B", result);
		result = testTaskOrganizer.getList().get(3).getProject();
		assertEquals("D", result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows successful sorting of tasks based on due date.
	 */
	@Test
	public void testSortListByDueDate() {
		addMultipleElements();
		testTaskOrganizer.sortListByDueDate();
		String result = testTaskOrganizer.getList().get(0).getDueDate();
		assertEquals("02/12", result);
		result = testTaskOrganizer.getList().get(1).getDueDate();
		assertEquals("03/18", result);
		result = testTaskOrganizer.getList().get(2).getDueDate();
		assertEquals("04/15", result);
		result = testTaskOrganizer.getList().get(3).getDueDate();
		assertEquals("07/13", result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows successful printing of task list.
	 */
	@Test
	public void testPrintList() {
		addMultipleElements();
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer.printList();
		String expectedOutput = "Task title: Cleaning; Due Date: 02/12; Project: B; Completed: false" + "\r\n"
								+ "Task title: Cooking; Due Date: 04/15; Project: D; Completed: false" + "\r\n"
								+ "Task title: Eating; Due Date: 07/13; Project: A; Completed: false" + "\r\n"
								+ "Task title: Studying; Due Date: 03/18; Project: A; Completed: false" + "\r\n\r\n";
		assertEquals(expectedOutput, output.toString());
		System.setIn(standardInput);
		System.setOut(standardOutput);
	}
	
	/**
	 * Test which shows successful calculation of incomplete
	 * and complete task quantities.
	 */
	@Test
	public void testGetTotalNumbers() {
		addMultipleElements();
		testTaskOrganizer.getTotalNumbers();
		long result = testTaskOrganizer.getToDoTotal();
		assertEquals(4, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Method for adding multiple elements to the testTaskOrganizer and doing some
	 * action with it.
	 * @param data The full data entered by the user in the process.
	 */
	public void addMultipleElementsBasedOnInput(String data) {
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		testTaskOrganizer = new TaskOrganizer();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
		testTaskOrganizer.addTask();
	}
	
	/**
	 * Test which shows successful update of a task.
	 */
	@Test
	public void testUpdateTaskSuccessfully() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Eating" + "\n" + "Eating" + "\n" + "10/02" + "\n" + "C";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.updateTask();
		String result = testTaskOrganizer.getList().get(2).getDueDate();
		assertEquals("10/02", result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows unsuccessful attempt of updating a
	 * task's title into one which already exists in another task.
	 */
	@Test
	public void testTryToUpdateTaskWithATitleThatIsAlreadyInTheList() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Eating" + "\n" + "Cleaning" + "\n" + "10/02" + "\n" + "C";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.updateTask();
		String result = testTaskOrganizer.getList().get(2).getTitle();
		assertEquals("Eating", result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows unsuccessful attempt of updating a task
	 * not present on the list.
	 */
	@Test
	public void testTryToUpdateTaskWhichDoesNotExist() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Shopping" + "\n" + "Cleaning" + "\n" + "10/02" + "\n" + "C";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.updateTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(4, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows successfully updating a task's status
	 * to completed.
	 */
	@Test
	public void testMarkTaskAsDoneSuccessfully() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Studying";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.markAsDone();
		boolean isComplete = testTaskOrganizer.getList().get(3).isCompleted();
		assertEquals(true, isComplete);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows unsuccessful attempt of trying to make
	 * a non existing task complete.
	 */
	@Test
	public void testMarkAsDoneTaskWhichDoesNotExist() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Shopping";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.markAsDone();
		testTaskOrganizer.getTotalNumbers();
		long toDoTotal = testTaskOrganizer.getToDoTotal();
		assertEquals(4, toDoTotal);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows successful attempt of removing a task
	 * from the list.
	 */
	@Test
	public void testRemoveTaskSuccessfully() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Cooking";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.removeTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(3, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows unsuccessful attempt of removing a task
	 * which is not in the list.
	 */
	@Test
	public void testTryToRemoveTaskWhichDoesNotExist() {
		String data = "Cleaning" + "\n" + "02/12" + "\n" + "B" + "\n"
				+ "Cooking" + "\n" + "04/15" + "\n" + "D" + "\n"
				+ "Eating" + "\n" + "07/13" + "\n" + "A" + "\n"
				+ "Studying" + "\n" + "03/18" + "\n" + "A" + "\n"
				+ "Shopping";
		addMultipleElementsBasedOnInput(data);
		testTaskOrganizer.removeTask();
		int result = testTaskOrganizer.getList().size();
		assertEquals(4, result);
		System.setIn(standardInput);
	}
	
	/**
	 * Test which shows successful attempt of creating a file for
	 * the list to be stored in.
	 */
	@Test
	public void testCreateFileForFirstTimeSuccessfully() {
		boolean success = false;
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer = new TaskOrganizer();
		testfile = new File("testfile.txt");
		testTaskOrganizer.createFile(testfile);
		if(output.toString().contains("File created")) {
			success = true;
		}
		assertEquals(true, success);
		System.setOut(standardOutput);
		testfile.delete();
	}
	
	/**
	 * Test which shows how a file will not be created again if one
	 * with that name already exists on the directory.
	 */
	@Test
	public void testTryToCreateFileWhichAlreadyExists() {
		testTaskOrganizer = new TaskOrganizer();
		testfile = new File("testfile.txt");
		testTaskOrganizer.createFile(testfile);
		boolean success = false;
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer.createFile(testfile);
		if(output.toString().contains("File already exists")) {
			success = true;
		}
		assertEquals(true, success);
		System.setOut(standardOutput);
		testfile.delete();
	}
	
	/**
	 * Test which shows how trying to create an invalid file
	 * will result in an error.
	 */
	@Test
	public void testTryToCreateInvalidFile() {
		boolean success = false;
		testTaskOrganizer = new TaskOrganizer();
		testfile = new File("/InvalidDirectory/testfile.txt");
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer.createFile(testfile);
		if(output.toString().contains("An error ocurred")) {
			success = true;
		}
		assertEquals(true, success);
		System.setOut(standardOutput);
		testfile.delete();
	}
	
	/**
	 * Test which shows successful attempt to save the task list
	 * to a valid file.
	 */
	@Test
	public void testSaveToFileSuccessfully() {
		FileWriter filewriter;
		testfile = new File("testsavetofile.txt");
		boolean success = false;
		testTaskOrganizer = new TaskOrganizer();
		try{
			filewriter = new FileWriter(testfile);
			testTaskOrganizer.saveToFile(filewriter);
			success = true;
		} catch(IOException e) {
			e.printStackTrace();
		}
		assertEquals(true, success);
		testfile.delete();
	}
	
	/**
	 * Test which shows unsuccessful attempt to save the list to an
	 * invalid file. An IOException is thrown in that case.
	 */
	@Test
	public void testTryingToSaveToInvalidFile() {
		FileWriter filewriter;
		testfile = new File("/InvalidDirectory/testsavetofile.txt");
		boolean success = false;
		testTaskOrganizer = new TaskOrganizer();
		try {
			filewriter = new FileWriter(testfile);
			testTaskOrganizer.saveToFile(filewriter);
		} catch(IOException e) {
			e.printStackTrace();
			success = true;
		}
		assertEquals(true, success);
		testfile.delete();
	}
	
	/**
	 * Test which shows success when reading from an existing file.
	 */
	@Test
	public void testReadFromFileSuccessfully() {
		testTaskOrganizer = new TaskOrganizer();
		testfile = new File("testreadfromfile.txt");
		testTaskOrganizer.createFile(testfile);
		boolean success = false;
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer.readFile(testfile);
		if(output.toString().contains("File data imported successfully")) {
			success = true;
		}
		assertEquals(true, success);
		System.setOut(standardOutput);
		testfile.delete();
	}
	
	/**
	 * Test which shows how the program will not recognise a file
	 * which has not been created before when trying to read from it.
	 */
	@Test
	public void testTryToReadFromFileWhichHasNotBeenCreated() {
		boolean success = false;
		testTaskOrganizer = new TaskOrganizer();
		testfile = new File("testreadfromfile.txt");
		PrintStream standardOutput = System.out;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		testTaskOrganizer.readFile(testfile);
		if(output.toString().contains("File not found")) {
			success = true;
		}
		assertEquals(true, success);
		System.setOut(standardOutput);
		testfile.delete();
	}
}
