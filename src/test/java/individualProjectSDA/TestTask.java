package individualProjectSDA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for testing of Task class methods.
 * @author ImanolIruretagoiena
 * @version 2020.04.05
 */
public class TestTask {
	
	//Field for Task objects.
	Task testTask;
	
	/**
	 * Constructor which creates a new test Task.
	 */
	public TestTask() {
		testTask = new Task("Cleaning", "05/13", "B");
	}
		
	/**
	 * Method which tests whether the Task's project field can be
	 * correctly changed.
	 */
	@Test
	public void testSetProject() {
		testTask.setProject("E");
		String result = testTask.getProject();
		assertEquals("E", result);
	}
	
	/**
	 * Method which tests whether the Task's due date field can be
	 * correctly changed.
	 */
	@Test
	public void testSetDueDate() {
		testTask.setDueDate("01/18");
		String result = testTask.getDueDate();
		assertEquals("01/18", result);
	}
	
	/**
	 * Method which tests whether the Task's title field can be
	 * correctly changed.
	 */
	@Test
	public void testSetTitle() {
		testTask.setTitle("Cooking");
		String result = testTask.getTitle();
		assertEquals("Cooking", result);
	}
	
	/**
	 * Method which tests whether the Task can be set to
	 * completed correctly.
	 */
	@Test
	public void testSetCompleted() {
		testTask.setCompleted();
		boolean result = testTask.isCompleted();
		assertEquals(true, result);
	}
	
	/**
	 * Method which tests that in this version it is possible
	 * for a Task to have an empty title field.
	 */
	@Test
	public void testSetEmptyTitle() {
		testTask.setTitle("");
		String result = testTask.getTitle();
		assertEquals("", result);
	}
}
