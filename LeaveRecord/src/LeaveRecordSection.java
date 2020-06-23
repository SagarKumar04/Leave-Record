import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LeaveRecordSection
{
	private JFrame frame;

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
					LeaveRecordSection window = new LeaveRecordSection();
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
	public LeaveRecordSection()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Leave Record Section");
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLeaveRecordSection = new JLabel("Employee Details Section");
		lblLeaveRecordSection.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblLeaveRecordSection.setBounds(128, 11, 193, 19);
		frame.getContentPane().add(lblLeaveRecordSection);
		
		JButton btnAddEmployeeData = new JButton("Add Employee Data");
		btnAddEmployeeData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnAddEmployeeData.setBounds(117, 41, 193, 23);
		frame.getContentPane().add(btnAddEmployeeData);
		
		btnAddEmployeeData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				AddEmployee.main(new String[] {});
				frame.dispose();
			}
		});
		
		JButton btnViewEmployeeData = new JButton("View Employee Data");
		btnViewEmployeeData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnViewEmployeeData.setBounds(117, 89, 193, 23);
		frame.getContentPane().add(btnViewEmployeeData);
		
		btnViewEmployeeData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ViewEmployee.main(new String[] {});
			}
		});
		
		JButton btnEditEmployeeData = new JButton("Edit Employee Data");
		btnEditEmployeeData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnEditEmployeeData.setBounds(117, 136, 193, 23);
		frame.getContentPane().add(btnEditEmployeeData);
		
		btnEditEmployeeData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				TakeEmployeeID.main(new String [] {});
				frame.dispose();
			}
		});
		
		JButton btnDeleteEmployeeData = new JButton("Delete Employee Data");
		btnDeleteEmployeeData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnDeleteEmployeeData.setBounds(117, 185, 193, 23);
		frame.getContentPane().add(btnDeleteEmployeeData);
		
		btnDeleteEmployeeData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DeleteEmployee.main(new String[] {});
			}
		});
		
		JButton btnApplyLeave = new JButton("Apply Leave");
		btnApplyLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnApplyLeave.setBounds(117, 238, 193, 23);
		frame.getContentPane().add(btnApplyLeave);
		
		btnApplyLeave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ApplyLeave.main(new String[] {});
			}
		});
		
		JButton btnCancelLeave = new JButton("Cancel Leave");
		btnCancelLeave.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCancelLeave.setBounds(117, 291, 193, 23);
		frame.getContentPane().add(btnCancelLeave);
		
		btnCancelLeave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				CancelLeave.main(new String[] {});
			}
		});
		
		JButton btnViewLeaveData = new JButton("View Leave Data");
		btnViewLeaveData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnViewLeaveData.setBounds(117, 343, 193, 23);
		frame.getContentPane().add(btnViewLeaveData);
		
		btnViewLeaveData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ViewLeaveData.main(new String[] {});
			}
		});
		
		JLabel lblNote1 = new JLabel("Note: At the beginning of every year, please reset the");
		lblNote1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNote1.setBounds(32, 395, 392, 19);
		frame.getContentPane().add(lblNote1);
		
		JLabel lblNote2 = new JLabel("leave data by clicking the 'Reset Data' button");
		lblNote2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNote2.setBounds(32, 425, 330, 19);
		frame.getContentPane().add(lblNote2);
		
		JButton btnResetData = new JButton("Reset Data");
		btnResetData.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnResetData.setBounds(117, 469, 193, 23);
		frame.getContentPane().add(btnResetData);
		
		btnResetData.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int status;
				
				status = LeaveDAO.reset();
				
				if(status > 0)
				{
					JOptionPane.showMessageDialog(null, "Data reset successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data reset unsuccessful");
				}
			}
		});
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnLogout.setBounds(171, 527, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		btnLogout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
				LoginPage.main(new String[] {});
			}
		});
	}
}