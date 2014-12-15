package at.bals.students;

import java.util.ArrayList;

import java.util.List;

public class StudentDAO {

	private static List<Student> studentList = new ArrayList<Student>();
	private static int nextID = 1;

	public List<Student> getAllStudents() {
		return studentList;
	}

	public void saveStudent(Student s) {
		s.setId(nextID);
		studentList.add(s);
		nextID++;
	}

	public synchronized void deleteStudent(int id) {
		for (Student student : studentList) {
			if (student.getId() == id) {
				studentList.remove(student);
				return;
			}

		}

	}
}