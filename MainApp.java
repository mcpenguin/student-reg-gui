package Classes;

import java.awt.event.*;
import javax.swing.*;

public class MainApp extends JFrame {
	
	private JTable table;
	private StudentDialog sd;
	private JButton addBtn, deleteBtn, searchBtn;
	private StudentTableModel tableModel;
	private School school;
	
	public MainApp(School school) {
		setSchool(school);
		setTitle(school.getName());
		sd = new StudentDialog(this);
		
		tableModel = new StudentTableModel(school);
		table = new JTable(tableModel);
		getContentPane().add(new JScrollPane(table), "Center");
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(addBtn = new JButton("Add Student"));
		btnPanel.add(deleteBtn = new JButton("Delete Student"));
		btnPanel.add(searchBtn = new JButton("Search for Student"));
		getContentPane().add(btnPanel, "South");
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 sd.pack();
				 sd.setVisible(true);
				 Student s = sd.getStudent();
				 if (s == null) {
					 JOptionPane.showMessageDialog(null, "Addition aborted");
				 }
				 else
					 tableModel.addStudent(s);
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	
	public static void main(String[] args) {
		School school = new School("JKL");
		MainApp ma = new MainApp(school);
		ma.setSize(500, 300);
		ma.setVisible(true);
	}

}
