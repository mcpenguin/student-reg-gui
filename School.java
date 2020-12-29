package Classes;

import java.util.*;

public class School {
	
	private ArrayList<Student> students;
	private ArrayList<Subject> subjects;
	private String name;
	
	public School(String name) {
		this(name, new ArrayList<Student>(), new ArrayList<Subject>());
	}
	
	public School(String name, ArrayList<Student> students, ArrayList<Subject> subjects) {
		setName(name);
		setStudents(students);
		setSubjects(subjects);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void addSubject(Subject subject) {
		subjects.add(subject);
	}
	
	public Student searchStudentByID(int id) {
		for (Student s: students) {
			if (s.getId() == id) {
				return s;
			}
		}
		return null;
	}
	
	public ArrayList<Student> searchStudentByName(String name) {
		return null;
	}

}
