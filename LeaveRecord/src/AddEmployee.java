import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddEmployee
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AddEmployee window = new AddEmployee();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public AddEmployee()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmployeeDetails.setBounds(154, 11, 133, 25);
		frame.getContentPane().add(lblEmployeeDetails);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmployeeId.setBounds(22, 62, 96, 14);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblName.setBounds(22, 99, 64, 19);
		frame.getContentPane().add(lblName);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDesignation.setBounds(22, 137, 81, 19);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblBranch.setBounds(22, 177, 64, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblSalary.setBounds(22, 213, 59, 25);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDateOfBirth.setBounds(22, 254, 106, 25);
		frame.getContentPane().add(lblDateOfBirth);
		
		textField = new JTextField();
		textField.setBounds(189, 61, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(189, 100, 130, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 138, 130, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(189, 176, 130, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(189, 217, 130, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(189, 258, 130, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setBounds(82, 314, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int status1;
				int status2;
				
				String empId = textField.getText();
				String name = textField_1.getText();
				String designation = textField_2.getText();
				String branch = textField_3.getText();
				String salary = textField_4.getText();
				String dob = textField_5.getText();
				
				int leaveData[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15};
				status1 = EmployeeDAO.addEmployee(empId, name, designation, branch, salary, dob);
				status2 = LeaveDAO.addEmployee(empId, leaveData);
				
				if(status1 > 0 && status2 > 0)
				{
					JOptionPane.showMessageDialog(null, "Employee added successfully");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Failed to add employee");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(230, 314, 89, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				LeaveRecordSection.main(new String[] {});
				frame.dispose();
			}
		});
	}
}