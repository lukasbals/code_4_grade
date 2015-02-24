package at.bals.taskservice.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.bals.taskservice.dao.ItemDao;
import at.bals.taskservice.vo.Item;

public class ItemDaoTest {

	@Test
	public void testGetData() {
		try {
			ItemDao dao = new ItemDao();
			List<Item> taskList = dao.getData();
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
			ItemDao dao = new ItemDao();
			Item t = new Item(0, "hans", 3);
			dao.insertData(t);

			Assert.assertTrue(true);

		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testDeleteData() {
		try {
			ItemDao dao = new ItemDao();
			int id = 15;
			dao.deleteData(id);

			Assert.assertTrue(true);

		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

}
