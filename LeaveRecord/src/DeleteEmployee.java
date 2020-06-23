import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteEmployee
{
	private JFrame frame;
	private JTextField textField;

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
					DeleteEmployee window = new DeleteEmployee();
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
	public DeleteEmployee()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeleteEmployeeDetails = new JLabel("Delete Employee Details");
		lblDeleteEmployeeDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDeleteEmployeeDetails.setBounds(124, 21, 186, 20);
		frame.getContentPane().add(lblDeleteEmployeeDetails);
		
		JLabel lblEnterRegistrationNumber = new JLabel("Enter Employee ID");
		lblEnterRegistrationNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEnterRegistrationNumber.setBounds(142, 70, 137, 20);
		frame.getContentPane().add(lblEnterRegistrationNumber);
		
		textField = new JTextField();
		textField.setBounds(150, 114, 129, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnDelete.setBounds(80, 181, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int status1;
				int status2;
				
				String empId = textField.getText();
				status1 = EmployeeDAO.delete(empId);
				status2 = LeaveDAO.delete(empId);
				
				if(status1 > 0 && status2 > 0)
				{
					JOptionPane.showMessageDialog(null, "Deletion successful");
					textField.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Deletion unsuccessful");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(260, 181, 89, 23);
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