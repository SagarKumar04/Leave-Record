import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class EmployeeDAO
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
	
	public static int addEmployee(String empId, String name, String designation, String branch, String salary, String dob)
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("insert into leave_employee (empId, name, designation, branch, salary, dob) values(?, ?, ?, ?, ?, ?)");
			ps.setString(1, empId);
			ps.setString(2, name);
			ps.setString(3, designation);
			ps.setString(4, branch);
			ps.setString(5, salary);
			ps.setString(6, dob);
			
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static List<String[]> viewAllEmployeeData()
	{
		List <String[]> employeeDetail = new ArrayList<String[]>();
		try
		{	
			
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from leave_employee inner join leave_data on leave_employee.empid = leave_data.empid");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String rows[] = new String[7];
				
				rows[0] = rs.getString("empid");
				rows[1] = rs.getString("name");
				rows[2] = rs.getString("designation");
				rows[3] = rs.getString("branch");
				rows[4] = rs.getString("salary");
				rows[5] = rs.getString("dob");
				rows[6] = rs.getString("leaves");
				
				employeeDetail.add(rows);
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return employeeDetail;
	}
	
	public static int checkIfEmployeeExists(String empId)
	{	
		int status = 0;
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from leave_employee where empid = ?");
			ps.setString(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				status = status + 1;
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static String[] getEmployeeDataByEmployeeID(String empId)
	{
		String s[] = new String[5];
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from leave_employee where empid = ?");
			ps.setString(1, empId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				s[0] = rs.getString("name");
				s[1] = rs.getString("designation");
				s[2] = rs.getString("branch");
				s[3] = rs.getString("salary");
				s[4] = rs.getString("dob");
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return s;
	}
	
	public static int update(String s[])
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("update leave_employee set empid = ?, name = ?, designation = ?, branch = ?, salary = ?, dob = ? where empid = ?");
			ps.setString(1, s[0]);
			ps.setString(2, s[1]);
			ps.setString(3, s[2]);
			ps.setString(4, s[3]);
			ps.setString(5, s[4]);
			ps.setString(6, s[5]);
			ps.setString(7, s[0]);
			
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static int delete(String empId)
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("delete from leave_employee where empid = ?");
			ps.setString(1, empId);
			
			status = ps.executeUpdate();
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
