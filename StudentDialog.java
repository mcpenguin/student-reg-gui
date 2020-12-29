package Classes;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.*;

import javax.swing.*;

public class StudentDialog extends JDialog {
	
	private JLabel nameL, dateL, yearL, genderL;
	private JTextField nameTF, dateTF, yearTF;
	private JButton okBtn, resetBtn, cancelBtn;
	private JRadioButton maleRBtn, femaleRBtn;
	private Student s;
	
	public StudentDialog(JFrame parent) {
		super(parent, true);
		nameL = new JLabel("Name: ");
		dateL = new JLabel("DOB: ");
		yearL = new JLabel("Year: ");
		genderL = new JLabel("Gender: ");
		
		nameTF = new JTextField(10);
		dateTF = new JTextField(10);
		yearTF = new JTextField(10);
		
		okBtn = new JButton("OK");
		resetBtn = new JButton("Reset");
		cancelBtn = new JButton("Cancel");
		
		maleRBtn = new JRadioButton("Male", true);
		femaleRBtn = new JRadioButton("Female");
		
		ButtonGroup genderBtnGrp = new ButtonGroup();
		genderBtnGrp.add(maleRBtn);
		genderBtnGrp.add(femaleRBtn);
		
		createLayout();
		
		nameTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String s = nameTF.getText();
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text for name");
				}
			}
		});
		
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String name = nameTF.getText();
				String dob = dateTF.getText();
				String year = yearTF.getText();
				String gender = maleRBtn.isSelected()?"male": "female";
				if (name.equals("") || dob.equals("") || year.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter text in all fields");
				}
				else {
					s = new Student(name, LocalDate.parse(dob, Utility.malaysianFormatter), 
							gender.charAt(0), new ArrayList<Subject>(), Integer.parseInt(year));
					System.out.println(s);
					reset();
					setVisible(false);
				}
				//reset();
				//setVisible(false);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				reset();
				s = null;
				setVisible(false);
			}
		});
	}
	
	
	
	public Student getStudent() {
		return s;
	}
	
	public void setStudent(Student student) {
		this.s = student;
	}
	
	public void createLayout() {
		JPanel jpL = new JPanel(new GridLayout(0, 1, 0, 15));
		jpL.add(nameL);
		jpL.add(dateL);
		jpL.add(yearL);
		jpL.add(genderL);
		
		JPanel jpRB = new JPanel();
		jpRB.add(maleRBtn);
		jpRB.add(femaleRBtn);
		
		JPanel jpTF = new JPanel(new GridLayout(0, 1));
		jpTF.add(nameTF);
		jpTF.add(dateTF);
		jpTF.add(yearTF);
		jpTF.add(jpRB);
		
		JPanel jpBtn = new JPanel();
		jpBtn.add(okBtn);
		jpBtn.add(resetBtn);
		jpBtn.add(cancelBtn);
		
		JPanel jp1 = new JPanel();
		jp1.add(jpL);
		jp1.add(jpTF);
		
		JPanel jpMain = new JPanel(new GridLayout(0, 1));
		jpMain.add(jp1);
		jpMain.add(jpBtn);
		
		getContentPane().add(jpMain, "North");
	}
	
	public void reset() {
		
	}

	public static void main(String[] args) {
		StudentDialog sd = new StudentDialog(new JFrame());
		sd.setSize(300, 300);
		sd.setVisible(true);
	}
	

}
