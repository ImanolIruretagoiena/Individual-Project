package individualProjectSDA;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTask {

	@Test
	public void testSetProject() {
		Task task = new Task("Cleaning", "05/13", "B");
		task.setProject("E");
		String result = task.getProject();
		assertEquals("E", result);
	}
	
	@Test
	public void testSetDueDate() {
		Task task = new Task("Cleaning", "05/13", "B");
		task.setDueDate("01/18");
		String result = task.getDueDate();
		assertEquals("01/18", result);
	}
	
	@Test
	public void testSetTitle() {
		Task task = new Task("Cleaning", "05/13", "B");
		task.setTitle("Cooking");
		String result = task.getTitle();
		assertEquals("Cooking", result);
	}
	
	@Test
	public void testSetCompleted() {
		Task task = new Task("Cleaning", "05/13", "B");
		task.setCompleted();
		boolean result = task.isCompleted();
		assertEquals(true, result);
	}
	
	@Test
	public void testSetEmptyTitle() {
		Task task = new Task("Cleaning", "05/13", "B");
		task.setTitle("");
		String result = task.getTitle();
		assertEquals("", result);
	}
}
