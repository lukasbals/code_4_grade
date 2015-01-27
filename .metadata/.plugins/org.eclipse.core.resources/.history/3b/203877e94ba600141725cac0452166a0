package at.bals.students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private Connection connection;
	private  List<Student> studentList = new ArrayList<Student>();
	private static int nextID = 1;

	public List<Student> getAllStudents() {
		if (this.connection == null) {
			setConnection();
		}
		studentList.clear();
		getStudents();
		return studentList;

	}

	private void getStudents() {
		try {
			Statement stmt = this.connection.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from Students;");
			resultSet.first();
			while (!(resultSet.isAfterLast())) {
				Student s = new Student(resultSet.getString(2),
						resultSet.getString(3), resultSet.getInt(1));
				studentList.add(s);
				resultSet.next();
			}
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveStudent(Student s) {
		s.setId(nextID);
		studentList.add(s);
		nextID++;
	}

	public void deleteStudent(int id) {
		studentList.remove(id);
	}

	private void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager
					.getConnection("jdbc:mysql://172.16.19.136/StudentList?user=studentapp&password=lukibals");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
