import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class ForgotPassword
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
					ForgotPassword window = new ForgotPassword();
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
	public ForgotPassword()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("Forgot Password");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUniqueId = new JLabel("Unique ID");
		lblUniqueId.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUniqueId.setBounds(41, 49, 116, 24);
		frame.getContentPane().add(lblUniqueId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblUsername.setBounds(41, 121, 116, 24);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(199, 51, 116, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 123, 116, 24);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnGetPassword = new JButton("Get Password");
		btnGetPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnGetPassword.setBounds(61, 203, 160, 35);
		frame.getContentPane().add(btnGetPassword);
		
		btnGetPassword.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String uId = textField.getText();
				String username = textField_1.getText();
				
				boolean status = UserDAO.retrievePassword(uId, username);
				
				if(status)
				{
					JOptionPane.showMessageDialog(null, "Password successfully retrived");
					textField.setText("");
					textField_1.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Unique ID or Username entered");
					textField.setText("");
					textField_1.setText("");
				}
			}
		});
		
		JLabel lblRetrievePasswordPage = new JLabel("Retrieve Password");
		lblRetrievePasswordPage.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		lblRetrievePasswordPage.setBounds(156, 11, 180, 27);
		frame.getContentPane().add(lblRetrievePasswordPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnBack.setBounds(251, 203, 126, 37);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				LoginPage.main(new String[]{});
				frame.dispose();
			}
		});
	}
}