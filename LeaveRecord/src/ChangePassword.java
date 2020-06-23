import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ChangePassword
{
	private JFrame frame;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

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
					ChangePassword window = new ChangePassword();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangePassword()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Change Password");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblOldPassword.setBounds(30, 103, 105, 25);
		frame.getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblNewPassword.setBounds(30, 139, 105, 25);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblReenterNewPassword = new JLabel("Re-enter New Password");
		lblReenterNewPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblReenterNewPassword.setBounds(30, 175, 179, 25);
		frame.getContentPane().add(lblReenterNewPassword);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblChangePassword.setBounds(154, 11, 145, 25);
		frame.getContentPane().add(lblChangePassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUsername.setBounds(30, 67, 105, 25);
		frame.getContentPane().add(lblUsername);
		
		textField_3 = new JTextField();
		textField_3.setBounds(239, 69, 124, 25);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblUniqueId = new JLabel("Unique ID");
		lblUniqueId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUniqueId.setBounds(30, 40, 78, 19);
		frame.getContentPane().add(lblUniqueId);
		
		textField_4 = new JTextField();
		textField_4.setBounds(239, 36, 124, 25);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setBounds(59, 227, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(239, 103, 124, 24);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(239, 139, 124, 24);
		frame.getContentPane().add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(239, 175, 124, 24);
		frame.getContentPane().add(passwordField_2);
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String uId = textField_4.getText();
				String username = textField_3.getText();
				String oldPassword = String.valueOf(passwordField.getPassword());
				String newPassword = String.valueOf(passwordField_1.getPassword());
				String reNewPassword = String.valueOf(passwordField_2.getPassword());
				boolean result1 = UserDAO.checkPassword(uId, username, oldPassword);
				boolean result2 = newPassword.equals(reNewPassword);
				
				int status = 0;
				
				if(result1 && result2)
				{
					status = UserDAO.updatePassword(uId, newPassword);
					if(status > 0)
					{
						JOptionPane.showMessageDialog(null, "Password changed successfully");
						LoginPage.main(new String[]{});
						frame.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Unable to change password");
						textField_4.setText("");
						textField_3.setText("");
						passwordField.setText("");
						passwordField_1.setText("");
						passwordField_2.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please re-enter the data");
					textField_4.setText("");
					textField_3.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
					passwordField_2.setText("");
					
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(239, 227, 89, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				LoginPage.main(new String[] {});
				frame.dispose();
			}
		});
	}
}