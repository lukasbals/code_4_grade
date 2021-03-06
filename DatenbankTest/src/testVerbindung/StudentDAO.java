package testVerbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	private Connection c;

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		try {
			dao.printStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printStudent() throws SQLException {
		if (this.c == null) {
			getConnection();
		}

		Statement stmt = this.c.createStatement();

		ResultSet resultSet = stmt.executeQuery("select * from Students");
		resultSet.first();
		while (!(resultSet.isAfterLast())) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			resultSet.next();
		}
		stmt.close();
		this.c.close();
	}

	private Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.c = DriverManager
					.getConnection("jdbc:mysql://172.16.19.136/StudentList?user=studentapp&password=lukibals");
			return c;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
