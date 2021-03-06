package todos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
	private Connection c;
	private static List<Todo> todoList = new ArrayList<Todo>();
	int x = 1;

	public TodoDAO() {
		if (this.c == null) {
			setConnection();
		}
		todoList.clear();
	}

	public List<Todo> getAllTodos() {
		getData();
		return todoList;
	}

	private void getData() {
		try {
			Statement stmt = this.c.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from Todos;");
			resultSet.first();
			while (!(resultSet.isAfterLast())) {
				Todo t = new Todo(resultSet.getString(2), resultSet.getInt(1));
				todoList.add(t);
				resultSet.next();
				this.x++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveTodo(String todo) {
		try {
			Statement stmt = this.c.createStatement();
			stmt.executeUpdate("insert into TodoApp.Todos (todo) VALUES ('"
					+ todo + "')");
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteTodo(int id) {
		try {
			Statement stmt = this.c.createStatement();

			stmt.executeUpdate("delete from Todos where idTodos=" + id);

			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTodo(int id, String update) {
		if (update != null) {
			try {
				Statement statement = this.c.createStatement();
				statement.executeUpdate("update TodoApp.Todos set todo='"
						+ update + "' where idTodos='" + id + "';");
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.c = DriverManager
					.getConnection("jdbc:mysql://172.16.19.138/TodoApp?user=studentapp&password=lukibals");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
