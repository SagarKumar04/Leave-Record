import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class ApplyLeave
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
					ApplyLeave window = new ApplyLeave();
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
	public ApplyLeave()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLeaveDetails = new JLabel("Leave Details");
		lblLeaveDetails.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblLeaveDetails.setBounds(164, 11, 107, 19);
		frame.getContentPane().add(lblLeaveDetails);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblEmployeeId.setBounds(22, 68, 100, 19);
		frame.getContentPane().add(lblEmployeeId);
		
		JLabel lblLeaveStartDate = new JLabel("Leave Start Date");
		lblLeaveStartDate.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblLeaveStartDate.setBounds(22, 115, 126, 19);
		frame.getContentPane().add(lblLeaveStartDate);
		
		JLabel lblLeaveEndDate = new JLabel("Leave End Date");
		lblLeaveEndDate.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblLeaveEndDate.setBounds(22, 160, 113, 19);
		frame.getContentPane().add(lblLeaveEndDate);
		
		textField = new JTextField();
		textField.setBounds(205, 69, 135, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(205, 116, 135, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(205, 161, 135, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(205, 248, 135, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCalculateDuration = new JButton("Calculate Duration");
		btnCalculateDuration.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCalculateDuration.setBounds(141, 209, 177, 23);
		frame.getContentPane().add(btnCalculateDuration);
		
		btnCalculateDuration.addActionListener(new ActionListener()
		{	
			public void actionPerformed(ActionEvent arg0)
			{
				String sStartDate = textField_1.getText();
				String sEndDate = textField_2.getText();
				try
				{
					Date sDate = new SimpleDateFormat("dd/MM/yyyy").parse(sStartDate);
					Date eDate = new SimpleDateFormat("dd/MM/yyyy").parse(sEndDate);
					
					long diff = eDate.getTime() - sDate.getTime();
					
					long diffInDays = TimeUnit.MILLISECONDS.toDays(diff);
					
					String sDiffInDays = String.valueOf(diffInDays);
					
					textField_3.setText(sDiffInDays);
				}
				catch (ParseException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblDuration.setBounds(22, 247, 69, 19);
		frame.getContentPane().add(lblDuration);
		
		JLabel lblLeaveType = new JLabel("Leave Type");
		lblLeaveType.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblLeaveType.setBounds(22, 331, 89, 19);
		frame.getContentPane().add(lblLeaveType);
		
		JRadioButton rdbtnCasualLeave = new JRadioButton("Casual Leave");
		rdbtnCasualLeave.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdbtnCasualLeave.setBounds(13, 362, 109, 23);
		frame.getContentPane().add(rdbtnCasualLeave);
		
		JRadioButton rdbtnOfficialDuty = new JRadioButton("Official Duty");
		rdbtnOfficialDuty.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdbtnOfficialDuty.setBounds(141, 362, 109, 23);
		frame.getContentPane().add(rdbtnOfficialDuty);
		
		JRadioButton rdbtnCompensatedLeave = new JRadioButton("Compensated Leave");
		rdbtnCompensatedLeave.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdbtnCompensatedLeave.setBounds(260, 362, 155, 23);
		frame.getContentPane().add(rdbtnCompensatedLeave);
		
		JRadioButton rdbtnSpecialLeaveDeath = new JRadioButton("Special Leave (Death)");
		rdbtnSpecialLeaveDeath.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		rdbtnSpecialLeaveDeath.setBounds(59, 409, 155, 23);
		frame.getContentPane().add(rdbtnSpecialLeaveDeath);
		
		JRadioButton rdbtnSpecialLeaveMarriage = new JRadioButton("Special Leave (Marriage)");
		rdbtnSpecialLeaveMarriage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnSpecialLeaveMarriage.setBounds(229, 409, 177, 23);
		frame.getContentPane().add(rdbtnSpecialLeaveMarriage);
		
		ButtonGroup leaveType = new ButtonGroup();
		leaveType.add(rdbtnCasualLeave);
		leaveType.add(rdbtnOfficialDuty);
		leaveType.add(rdbtnCompensatedLeave);
		leaveType.add(rdbtnSpecialLeaveDeath);
		leaveType.add(rdbtnSpecialLeaveMarriage);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnCheck.setBounds(179, 455, 89, 23);
		frame.getContentPane().add(btnCheck);
		
		long duration;
		
		btnCheck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String empId = textField.getText();
				String sStartDate = textField_1.getText();
				
				Date sDate;
				
				int month = 0;
				int leavesRemaining[] = new int[13];
				int duration = 0;
				int lossOfPayDuration;
				
				boolean result1 = false;
				boolean result2 = false;
				
				leavesRemaining = LeaveDAO.getLeave(empId);
				
				try
				{
					sDate = new SimpleDateFormat("dd/MM/yyyy").parse(sStartDate);
					month = sDate.getMonth() + 1;
					
				}
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				
				try
				{
					duration = Integer.parseInt(textField_3.getText());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				if((month >= 1 && month <= 6 && leavesRemaining[12] >= 8) || (month >= 7 && month <= 12 && leavesRemaining[12] >= 0))
				{
					result1 = true;
				}
				else
				{
					result1 = false;
				}
				
				if((rdbtnCasualLeave.isSelected() && duration <= (2 - leavesRemaining[month - 1])) ||
						rdbtnOfficialDuty.isSelected() ||
						rdbtnCompensatedLeave.isSelected() ||
						(rdbtnSpecialLeaveDeath.isSelected() && duration <= (12 + (2 - leavesRemaining[month - 1]))) ||
						(rdbtnSpecialLeaveMarriage.isSelected() && duration <= (7 + (2 - leavesRemaining[month - 1]))))
				{
					result2 = true;
				}
				else
				{
					result2 = false;
				}
				
				
				if(result1 && result2)
				{
					JOptionPane.showMessageDialog(null, "No loss of pay");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loss of pay");
				}
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setBounds(73, 514, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int status;
				String empId = textField.getText();
				int duration = 0;
				int lossOfPayDuration;
				int month = 0;
				String sStartDate = textField_1.getText();
				
				Date sDate;
				
				try
				{
					sDate = new SimpleDateFormat("dd/MM/yyyy").parse(sStartDate);
					month = sDate.getMonth() + 1;
					
				}
				catch (ParseException e)
				{
					e.printStackTrace();
				}
				
				try
				{
					duration = Integer.parseInt(textField_3.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				int leavesRemaining[] = new int[13];
				
				leavesRemaining = LeaveDAO.getLeave(empId);
				
				if(rdbtnOfficialDuty.isSelected() || rdbtnCompensatedLeave.isSelected() ||
						(rdbtnSpecialLeaveDeath.isSelected() && duration <= 12) ||
						(rdbtnSpecialLeaveMarriage.isSelected() && duration <= 7))
				{
					lossOfPayDuration = 0;
				}
				else if(rdbtnSpecialLeaveDeath.isSelected() && duration >= 12)
				{
					lossOfPayDuration = duration - 12 - (2 - leavesRemaining[month - 1]);
				}
				else if((rdbtnSpecialLeaveMarriage.isSelected() && duration >= 7))
				{
					lossOfPayDuration = duration - 7 - (2 - leavesRemaining[month - 1]);
				}
				else if(rdbtnCasualLeave.isSelected() && duration >= 2)
				{
					lossOfPayDuration = duration - (2 - leavesRemaining[month - 1]);
				}
				else
				{
					lossOfPayDuration = duration - leavesRemaining[month - 1];
				}
				
				leavesRemaining[month - 1] = leavesRemaining[month - 1] + duration;
				leavesRemaining[12] = leavesRemaining[12] - duration;
				
				status = LeaveDAO.update(empId, leavesRemaining);
				
				if(status > 0)
				{
					JOptionPane.showMessageDialog(null, "Leave applied successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Failed to apply leave");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(287, 514, 89, 23);
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