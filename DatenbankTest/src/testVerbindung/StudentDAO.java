package testVerbindung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	private int number;
	private String firstName;
	private String lastName;

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
		// setup the connection with the DB.
		Connection c;
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager
					.getConnection("jdbc:mysql://172.16.19.136/StudentList?user=studentapp&password=lukibals");

			Statement stmt = c.createStatement();

			ResultSet resultSet = stmt.executeQuery("select * from Students");
			resultSet.first();
			while (!(resultSet.isAfterLast())) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				number = resultSet.getInt(1);
				firstName = resultSet.getString(2);
				lastName = resultSet.getString(3);
				resultSet.next();
			}
			stmt.close();
			c.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
