import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class TakeEmployeeID
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
					TakeEmployeeID window = new TakeEmployeeID();
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
	public TakeEmployeeID()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Employee ID");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterEmployeeId = new JLabel("Enter Employee ID");
		lblEnterEmployeeId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEnterEmployeeId.setBounds(147, 32, 166, 19);
		frame.getContentPane().add(lblEnterEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(147, 74, 135, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGetDetails = new JButton("Get Details");
		btnGetDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnGetDetails.setBounds(135, 125, 159, 23);
		frame.getContentPane().add(btnGetDetails);
		
		btnGetDetails.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{	
				String empId = textField.getText();
				String sqlData[] = new String[6];
				
				int status;
				
				status = EmployeeDAO.checkIfEmployeeExists(empId);
				if(status > 0)
				{
					sqlData = EmployeeDAO.getEmployeeDataByEmployeeID(empId);
					
					String data[] = new String[6];
					data[0] = textField.getText();
					
					for(int i = 1; i < 6; i++)
					{
						data[i] = sqlData[i - 1];
					}
					EditEmployee.main(data);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Employee does not exists");
					textField.setText("");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(166, 178, 89, 23);
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