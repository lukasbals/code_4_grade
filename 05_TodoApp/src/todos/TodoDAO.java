package todos;

import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
	private static List<Todo> todoList = new ArrayList<Todo>();
	private static int nextID = 1;

	public List<Todo> getAllTodos() {
		return todoList;
	}

	public void saveStudent(Todo t) {
		t.setId(nextID);
		todoList.add(t);
		nextID++;
	}

	public synchronized void deleteStudent(int id) {
		for (Todo todo : todoList) {
			if (todo.getId() == id) {
				todoList.remove(todo);
				return;
			}

		}

	}
}
