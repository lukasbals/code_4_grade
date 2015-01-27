package at.bals.tastkservice.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bals.taskservice.vo.Task;

@Path("tasks/")
public class TaskService {
	private Connection connection;
	private List<Task> taskList = new ArrayList<Task>();

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> getAllTasks() {

		if (this.connection == null) {
			setConnection();
		}

		getData();

		return taskList;
	}

	@GET
	// @POST
	@Path("add/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// @Consumes(MediaType.APPLICATION_XML)
	public int addTask() {
		try {
			Statement stmt = this.connection.createStatement();
			stmt.executeUpdate("insert into firstRest.firstRest (name, beschreibung) VALUES ('asdf', 'asdf');");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private void getData() {
		taskList.clear();
		try {
			Statement stmt = this.connection.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from firstRest;");
			resultSet.first();
			while (!(resultSet.isAfterLast())) {
				Task t = new Task(resultSet.getString(1),
						resultSet.getString(2));
				taskList.add(t);
				resultSet.next();
			}
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
