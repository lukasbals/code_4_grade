package at.bals.taskservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import at.bals.taskservice.vo.Item;

public class ItemDao {
	private static final String ipAddress = "localhost";
	private static final String databaseName = "firstRest";
	private static final String userName = "lukas";
	private static final String password = "lukas";
	private Connection connection;

	/**
	 * Returns all Tasks from the Database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Item> getData() throws SQLException {
		List<Item> taskList = new ArrayList<Item>();
		if (this.connection == null || this.connection.isClosed()) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from shoppingList;");
		resultSet.first();
		while (!(resultSet.isAfterLast())) {
			Item t = new Item(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getInt(3));
			taskList.add(t);
			resultSet.next();
		}
		stmt.close();
		connection.close();
		return taskList;
	}

	/**
	 * Returns all only one Task from the database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Item getItemForId(@PathParam("id") int id) throws SQLException {
		Item item = null;
		if (this.connection == null || this.connection.isClosed()) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		ResultSet resultSet = stmt
				.executeQuery("select * from shoppingList where id=" + id);
		resultSet.first();
		if (!(resultSet.isAfterLast())) {
			item = new Item(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getInt(3));
		}
		stmt.close();
		connection.close();
		return item;
	}

	/**
	 * Inserts one Task
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void insertData(Item t) throws SQLException {
		if (this.connection == null || this.connection.isClosed()) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("insert into firstRest.shoppingList (name, quantity) VALUES ('"
				+ t.getName() + "', '" + t.getQuantity() + "');");
		stmt.close();
		connection.close();
	}

	/**
	 * Deletes one Task
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void deleteData(Integer id) throws SQLException {
		if (this.connection == null || this.connection.isClosed()) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("delete from shoppingList where id=" + id + ";");
		stmt.close();
		connection.close();
	}

	/**
	 * Updates one Task
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void updateData(Item i) throws SQLException {
		if (this.connection == null || this.connection.isClosed()) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("update shoppingList set quantity='"
				+ i.getQuantity() + "' where id='" + i.getId() + "';");
		System.out.println(stmt);
		stmt.close();
		connection.close();
	}

	/**
	 * Sets a connection to the database
	 */
	private void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://"
					+ ipAddress + "/" + databaseName + "?user=" + userName
					+ "&password=" + password + "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
