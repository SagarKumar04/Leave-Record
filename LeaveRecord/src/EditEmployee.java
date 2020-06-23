import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class EditEmployee
{
	static String empId;
	static String name;
	static String designation;
	static String branch;
	static String salary;
	static String dob;
	
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
		empId = args[0];
		name = args[1];
		designation = args[2];
		branch = args[3];
		salary = args[4];
		dob = args[5];
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					EditEmployee window = new EditEmployee();
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
	public EditEmployee()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEditEmployeeDetails = new JLabel("Edit Employee Details");
		lblEditEmployeeDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEditEmployeeDetails.setBounds(142, 25, 168, 19);
		frame.getContentPane().add(lblEditEmployeeDetails);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmployeeId.setBounds(25, 80, 103, 19);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblName.setBounds(25, 128, 56, 19);
		frame.getContentPane().add(lblName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblBranch.setBounds(25, 176, 72, 19);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDesignation.setBounds(25, 228, 90, 19);
		frame.getContentPane().add(lblDesignation);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblSalary.setBounds(25, 277, 56, 19);
		frame.getContentPane().add(lblSalary);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDateOfBirth.setBounds(25, 332, 103, 19);
		frame.getContentPane().add(lblDateOfBirth);
		
		textField = new JTextField();
		textField.setBounds(168, 81, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 129, 142, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 177, 142, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 229, 142, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(168, 278, 142, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(168, 333, 142, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField.setText(empId);
		textField_1.setText(name);
		textField_2.setText(designation);
		textField_3.setText(branch);
		textField_4.setText(salary);
		textField_5.setText(dob);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setBounds(75, 395, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String getData[] = new String[6];
				int status;
				
				getData[0] = textField.getText();
				getData[1] = textField_1.getText();
				getData[2] = textField_2.getText();
				getData[3] = textField_3.getText();
				getData[4] = textField_4.getText();
				getData[5] = textField_5.getText();
				
				status = EmployeeDAO.update(getData);
				
				if(status > 0)
				{
					JOptionPane.showMessageDialog(null, "Employee data edited successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Failed to edit employee data");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(236, 395, 89, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				TakeEmployeeID.main(new String[] {});
				frame.dispose();
			}
		});
	}
}