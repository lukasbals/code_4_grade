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
import javax.ws.rs.core.Response;

import at.bals.taskservice.dao.TaskDao;
import at.bals.taskservice.vo.Task;

@Path("tasks/")
public class TaskService {
	private Connection connection;
	private List<Task> taskList = new ArrayList<Task>();

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> getAllTasks() {
		taskList.clear();
		try {
			// taskList.clear();
			// if (this.connection == null) {
			// setConnection();
			// }
			//
			// Statement stmt = this.connection.createStatement();
			// ResultSet resultSet =
			// stmt.executeQuery("select * from firstRest;");
			// resultSet.first();
			// while (!(resultSet.isAfterLast())) {
			// Task t = new Task(resultSet.getInt(1), resultSet.getString(2),
			// resultSet.getString(3));
			// taskList.add(t);
			// resultSet.next();
			// }
			// stmt.close();

			TaskDao dao = new TaskDao();
			// List<Task> taskList =
			dao.getData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taskList;
	}

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_XML)
	public Response addTask(Task task) {

		try {
			TaskDao dao = new TaskDao();
			dao.insertData(task);
			return Response.status(201).build();
		} catch (SQLException e) {
			return Response.status(400).build();
		}

	}

	// private void setConnection() {
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// this.connection = DriverManager
	// .getConnection("jdbc:mysql://172.16.19.136/firstRest?user=firstRest&password=lukibals");
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
