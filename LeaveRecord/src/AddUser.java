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

public class AddUser
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

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
					AddUser window = new AddUser();
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
	public AddUser()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Add User");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddUserPage = new JLabel("Add User");
		lblAddUserPage.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblAddUserPage.setBounds(178, 11, 173, 28);
		frame.getContentPane().add(lblAddUserPage);
		
		JLabel lblUniqueId = new JLabel("Unique ID");
		lblUniqueId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUniqueId.setBounds(35, 50, 100, 19);
		frame.getContentPane().add(lblUniqueId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUsername.setBounds(35, 80, 83, 19);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblPassword.setBounds(35, 110, 83, 19);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(188, 50, 115, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 81, 115, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnSubmit.setBounds(89, 214, 100, 28);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblConfirmPassword.setBounds(35, 145, 132, 19);
		frame.getContentPane().add(lblConfirmPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 146, 115, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(188, 111, 115, 20);
		frame.getContentPane().add(passwordField_1);
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String uId = textField.getText(); 
				String username = textField_1.getText();
				char passCharArray[] = passwordField.getPassword();
				String password = String.valueOf(passCharArray);
				char confirmPassCharArray[] = passwordField_1.getPassword();
				String confirmPassword = String.valueOf(confirmPassCharArray);
				
				int status;
				
				if(password.equals(confirmPassword))
				{
					status = UserDAO.addNewUser(uId, username, password);
				}
				else
				{
					status = 0;
				}
				
				if(status > 0)
				{
					JOptionPane.showMessageDialog(null, "New User Added Successfully");
					textField.setText("");
					textField_1.setText("");
					passwordField_1.setText("");
					passwordField.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Failed to add new user");
				}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(228, 214, 100, 28);
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
