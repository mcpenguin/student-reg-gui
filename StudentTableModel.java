package Classes;

import javax.swing.table.*;

public class StudentTableModel extends AbstractTableModel {

	private School school;
	
	public StudentTableModel(School school) {
		setSchool(school);
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return school.getStudents().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Student s = school.getStudents().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return rowIndex + 1;
		case 1:
			return s.getName();
		case 2:
			return s.getYear();
		case 3:
			return s.getDob();
		default:
			return null;
		
		}
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	public void addStudent(Student student) {
		school.addStudent(student);
		fireTableDataChanged();
	}
	
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "No.";
		case 1:
			return "Name";
		case 2:
			return "Year";
		case 3:
			return "DOB";
		default:
			return null;
		}
	}
	
	

}
