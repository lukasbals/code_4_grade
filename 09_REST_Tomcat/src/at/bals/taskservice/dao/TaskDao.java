package at.bals.taskservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.bals.taskservice.vo.Task;

public class TaskDao {
	private static final String ipAddress = "172.16.19.136";
	private static final String databaseName = "firstRest";
	private static final String userName = "firstRest";
	private static final String password = "lukibals";
	private Connection connection;

	/**
	 * Returns all Tasks from the Database
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Task> getData() throws SQLException {
		List<Task> taskList = new ArrayList<Task>();
		if (this.connection == null) {
			setConnection();
		}

		Statement stmt = this.connection.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from firstRest;");
		resultSet.first();
		while (!(resultSet.isAfterLast())) {
			Task t = new Task(resultSet.getInt(1), resultSet.getString(2),
					resultSet.getString(3));
			taskList.add(t);
			resultSet.next();
		}
		stmt.close();
		connection.close();
		return taskList;
	}

	/**
	 * Inserts one Task
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void insertData(Task t) throws SQLException {
		if (this.connection == null) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("insert into firstRest.firstRest (name, beschreibung) VALUES ('"
				+ t.getName() + "', '" + t.getDescription() + "');");
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
		if (this.connection == null) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("delete from firstRest where id=" + id + ";");
		stmt.close();
		connection.close();
	}

	/**
	 * Updates one Task
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void updateData(Task t, Integer id) throws SQLException {
		if (this.connection == null) {
			setConnection();
		}
		Statement stmt = this.connection.createStatement();
		stmt.executeUpdate("update firstRest set name='" + t.getName()
				+ "', beschreibung='" + t.getDescription() + "' where id="
				+ t.getId() + ";");
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
