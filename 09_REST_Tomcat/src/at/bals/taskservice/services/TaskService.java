package at.bals.taskservice.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.bals.taskservice.dao.TaskDao;
import at.bals.taskservice.vo.Task;

@Path("tasks/")
public class TaskService {
	// private Connection connection;
	private List<Task> taskList = new ArrayList<Task>();

	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Task> getAllTasks() {
		taskList.clear();
		try {
			TaskDao dao = new TaskDao();
			this.taskList = dao.getData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return taskList;
	}

	@POST
	@Path("")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
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

	@DELETE
	@Path("{id}/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response deleteTask(@PathParam("id") int id) {
		try {
			TaskDao dao = new TaskDao();
			dao.deleteData(id);
			return Response.status(200).build();
		} catch (SQLException e) {
			return Response.status(400).build();
		}
	}

	@PUT
	@Path("{id}/")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response updateTask(Task task, @PathParam("id") int id) {
		try {
			TaskDao dao = new TaskDao();
			task.setId(id);
			dao.updateData(task, id);
			return Response.status(200).build();
		} catch (SQLException e) {
			return Response.status(400).build();
		}
	}
}
