package at.bals.taskservice.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import at.bals.taskservice.dao.ItemDao;
import at.bals.taskservice.vo.Item;

public class ItemDaoTest {

	//Test für das holen der Daten
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

	//Test für das hinzufügen eines Items
	@Test
	public void testInsertData() {
		try {
			ItemDao dao = new ItemDao();
			Item t = new Item(2, "Ketchup", 3);
			dao.insertData(t);

			Assert.assertTrue(true);

		} catch (SQLException e) {
			fail(e.getMessage());
		}

	}

	//Test für das löschen eines Items
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

	//Test zum holen eines einzelnen Items
	@Test
	public void testGetItemById() {
		ItemDao dao = new ItemDao();
		try {
			Item i = dao.getItemForId(18);
			if (i.getName().equals("Klopapierrollen")) {
				Assert.assertTrue(true);
			} else {
				fail();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Test zum updaten von Daten
	@Test
	public void testUpdateData() {
		try {
			ItemDao dao = new ItemDao();
			Item i = dao.getItemForId(18);
			int qu = i.getQuantity();
			qu = qu + 1;
			i.setQuantity(qu);
			dao.updateData(i);
			if (i.getQuantity() == qu) {
				Assert.assertTrue(true);
			} else {
				fail();
			}
		} catch (SQLException e) {
			fail(e.getMessage());
		}
	}
}
