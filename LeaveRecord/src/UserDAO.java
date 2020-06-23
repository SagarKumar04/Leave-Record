import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class UserDAO
{
	public static Connection getCon()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","","");
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return con;
	}
	
	public static boolean validate(String name, String password)
	{
		boolean status = false;
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from leave_user where username = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
	}
	
	public static boolean retrievePassword(String uId, String username)
	{
		boolean status = false;
		String password = "";
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select password from leave_user where unique_id = ? and username = ?");
			ps.setString(1, uId);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(status)
			{
				password = rs.getString("password");
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		if(status)
		{
			JOptionPane.showMessageDialog(null, "Password: " + password);
		}
		
		return status;
	}
	
	public static int addNewUser(String uId, String username, String password)
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("insert into leave_user (unique_id, username, password) values(?,?,?)");
			ps.setString(1,uId);
			ps.setString(2,username);
			ps.setString(3,password);
			status = ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static boolean checkPassword(String uId, String username, String oPassword)
	{
		boolean status = false;
		String password = "";
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select password from leave_user where unique_id = ? and username = ?");
			ps.setString(1, uId);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if(status)
			{
				password = rs.getString("password");
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		if(password.equals(oPassword))
		{
			status = true;
		}
		else
		{
			status = false;
		}
		
		return status;
	}
	
	public static int updatePassword(String uId, String password)
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("update leave_user set password = ? where unique_id = ?");
			ps.setString(1, password);
			ps.setString(2, uId);
			
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return status;
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
	}
}