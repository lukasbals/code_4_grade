package at.bals.taskservice.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.bals.taskservice.dao.TaskDao;
import at.bals.taskservice.vo.Task;

public class TaskDaoTest {

	@Test
	public void testGetData() {
		try {
			TaskDao dao = new TaskDao();
			List<Task> taskList = dao.getData();
			if (taskList.size() > 0) {
				Assert.assertTrue(true);
			} else {
				fail("No data");
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testInsertData() {
		try {
			TaskDao dao = new TaskDao();
			Task t = new Task(0, "hans", "hans");
			dao.insertData(t);

			Assert.assertTrue(true);

		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testDeleteData() {
		try {
			TaskDao dao = new TaskDao();
			int id = 15;
			dao.deleteData(id);

			Assert.assertTrue(true);

		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

}
