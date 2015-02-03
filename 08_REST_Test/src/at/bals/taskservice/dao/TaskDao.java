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
	private Connection connection;

	/**
	 *  Returns all Tasks from the Database
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
		return taskList;
	}

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

	private void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager
					.getConnection("jdbc:mysql://172.16.19.136/firstRest?user=firstRest&password=lukibals");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
