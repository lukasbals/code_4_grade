package todos;

public class Todo {
	int id;
	String todo;

	public Todo(String todo) {
		super();
		this.todo = todo;
	}

	public Todo(String todo, int id) {
		super();
		this.todo = todo;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}
}
