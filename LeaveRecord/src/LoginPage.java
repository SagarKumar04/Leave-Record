import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.*;

public class LoginPage
{
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

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
					LoginPage window = new LoginPage();
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
	public LoginPage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Login Page");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Cambria", Font.BOLD, 20));
		lblUsername.setBackground(Color.GRAY);
		lblUsername.setBounds(50, 51, 116, 29);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria", Font.BOLD, 20));
		lblPassword.setBounds(50, 104, 116, 29);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(178, 54, 144, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(178, 108, 144, 29);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Sitka Small", Font.BOLD, 15));
		btnLogin.setBounds(10, 164, 196, 23);
		frame.getContentPane().add(btnLogin);
		
		textField.addKeyListener(new MyKeyListener());
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				boolean status = UserDAO.validate(name, password);
				
				if(status)
				{
					LeaveRecordSection.main(new String[]{});
					frame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong username or password");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setFont(new Font("Sitka Small", Font.BOLD, 15));
		btnForgotPassword.setBounds(228, 164, 196, 23);
		frame.getContentPane().add(btnForgotPassword);
		
		btnForgotPassword.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ForgotPassword.main(new String[]{});
			}
		});
		
		JButton btnAddNewUser = new JButton("Add New User");
		btnAddNewUser.setFont(new Font("Sitka Small", Font.BOLD, 15));
		btnAddNewUser.setBounds(228, 215, 196, 23);
		frame.getContentPane().add(btnAddNewUser);
		
		btnAddNewUser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				AddUser.main(new String[] {});
				frame.dispose();
			}
		});
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Sitka Small", Font.BOLD, 15));
		btnChangePassword.setBounds(10, 213, 196, 23);
		frame.getContentPane().add(btnChangePassword);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblLoginPage.setBounds(163, 11, 109, 23);
		frame.getContentPane().add(lblLoginPage);
		
		btnChangePassword.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ChangePassword.main(new String[] {});
				frame.dispose();
			}
		});
	}
}

class MyKeyListener extends KeyAdapter
{	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_CAPS_LOCK)
		{
			JOptionPane.showMessageDialog(null, "Caps Lock Key is Pressed");
		}
	}
}