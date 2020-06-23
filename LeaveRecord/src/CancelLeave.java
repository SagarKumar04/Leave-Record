import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CancelLeave
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
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
					CancelLeave window = new CancelLeave();
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
	public CancelLeave()
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
		
		JLabel lblCancelLeave = new JLabel("Cancel Leave");
		lblCancelLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblCancelLeave.setBounds(170, 11, 106, 19);
		frame.getContentPane().add(lblCancelLeave);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmployeeId.setBounds(30, 49, 95, 19);
		frame.getContentPane().add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(190, 50, 113, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblMonth = new JLabel("Month Number");
		lblMonth.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblMonth.setBounds(30, 99, 122, 19);
		frame.getContentPane().add(lblMonth);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 98, 113, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNumberOfDays.setBounds(30, 152, 122, 19);
		frame.getContentPane().add(lblNumberOfDays);
		
		textField_2 = new JTextField();
		textField_2.setBounds(190, 153, 113, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCancelLeave = new JButton("Cancel Leave");
		btnCancelLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCancelLeave.setBounds(60, 205, 138, 23);
		frame.getContentPane().add(btnCancelLeave);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(243, 205, 138, 23);
		frame.getContentPane().add(btnBack);
		
		btnCancelLeave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String empId = textField.getText();
				int month = 0;
				int duration = 0;
				int leavesRemaining[] = new int[13];
				
				int status = 0;
				
				leavesRemaining = LeaveDAO.getLeave(empId);
				
				try
				{
					month = Integer.parseInt(textField_1.getText());
					duration = Integer.parseInt(textField_2.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				leavesRemaining[month - 1] = leavesRemaining[month - 1] - duration;
				leavesRemaining[12] = leavesRemaining[12] + duration;
				
				status = LeaveDAO.update(empId, leavesRemaining);
				
				if(status > 0)
				{
					JOptionPane.showMessageDialog(null, "Leave cancelled");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unable to cancel leave");
				}
			}
		});
		
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