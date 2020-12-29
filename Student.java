package Classes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student {
	
	private static int idGen = 10000;
	
	private String name;
	private int year;
	private LocalDate dob;
	private char gender;
	private ArrayList<Subject> subjects;
	private int id;
	
	public Student(String name, LocalDate dob, char gender, ArrayList<Subject> subjects, int year) {
		this.setName(name);
		this.setDob(dob);
		this.setGender(gender);
		this.setSubjects(subjects);
		this.setYear(year);
		this.setId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject s) {
		subjects.add(s);
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return "Student [" + name + ", "+ id + "] in year "+year+", born on"+Utility.malaysianFormatter.format(dob);
				
	}

	public int getId() {
		return id;
	}

	public void setId() {
		this.id = idGen++;
	}

}
