package at.bals.tastkservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import at.bals.taskservice.vo.Task;

@Path("tasks/")
public class TaskService {
	@GET
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Task> getAllTasks() {
		Task t1 = new Task("do it", "now");
		Task t2 = new Task("dont do it", "never");

		List<Task> taskList = new ArrayList<Task>();
		taskList.add(t1);
		taskList.add(t2);

		return taskList;
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Task getTaskForId(@PathParam("id") int id) {
		Task t = new Task("id task", "id " + id);
		return t;
	}

	@POST
	@Path("")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_XML)
	public Task addTask(Task task) {
		return task;
	}
}
