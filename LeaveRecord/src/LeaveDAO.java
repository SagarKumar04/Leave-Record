import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LeaveDAO
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
	
	public static int addEmployee(String empId, int leaveData[])
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("insert into leave_data (empid, january, february, march, april, may, june, july, august, september, october, november, december, leaves) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, empId);
			ps.setInt(2, leaveData[0]);
			ps.setInt(3, leaveData[1]);
			ps.setInt(4, leaveData[2]);
			ps.setInt(5, leaveData[3]);
			ps.setInt(6, leaveData[4]);
			ps.setInt(7, leaveData[5]);
			ps.setInt(8, leaveData[6]);
			ps.setInt(9, leaveData[7]);
			ps.setInt(10, leaveData[8]);
			ps.setInt(11, leaveData[9]);
			ps.setInt(12, leaveData[10]);
			ps.setInt(13, leaveData[11]);
			ps.setInt(14, leaveData[12]);
			
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
			
			PreparedStatement ps = con.prepareStatement("delete from leave_data where empid = ?");
			ps.setString(1, empId);
			
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static int[] getLeave(String empId)
	{
		int leaveData[] = new int[13];
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("select * from leave_data where empid = ?");
			ps.setString(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				leaveData[0] = rs.getInt("january");
				leaveData[1] = rs.getInt("february");
				leaveData[2] = rs.getInt("march");
				leaveData[3] = rs.getInt("april");
				leaveData[4] = rs.getInt("may");
				leaveData[5] = rs.getInt("june");
				leaveData[6] = rs.getInt("july");
				leaveData[7] = rs.getInt("august");
				leaveData[8] = rs.getInt("september");
				leaveData[9] = rs.getInt("october");
				leaveData[10] = rs.getInt("november");
				leaveData[11] = rs.getInt("december");
				leaveData[12] = rs.getInt("leaves");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return leaveData;
	}
	
	public static int update(String empId, int leavesRemaining[])
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("update leave_data set empid = ?, january = ?, february = ?, march = ?, april = ?, may = ?, june = ?, july = ?, august = ?, september = ?, october = ?, november = ?, december = ?, leaves = ? where empid = ?");
			ps.setString(1, empId);
			ps.setInt(2, leavesRemaining[0]);
			ps.setInt(3, leavesRemaining[1]);
			ps.setInt(4, leavesRemaining[2]);
			ps.setInt(5, leavesRemaining[3]);
			ps.setInt(6, leavesRemaining[4]);
			ps.setInt(7, leavesRemaining[5]);
			ps.setInt(8, leavesRemaining[6]);
			ps.setInt(9, leavesRemaining[7]);
			ps.setInt(10, leavesRemaining[8]);
			ps.setInt(11, leavesRemaining[9]);
			ps.setInt(12, leavesRemaining[10]);
			ps.setInt(13, leavesRemaining[11]);
			ps.setInt(14, leavesRemaining[12]);
			ps.setString(15, empId);
			
			status = ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
		return status;
	}
	
	public static List<String[]> viewLeaveData()
	{
		List <String[]> leaveData = new ArrayList<String[]>();
		try
		{	
			
			Connection con = getCon();
			PreparedStatement ps = con.prepareStatement("select * from leave_data");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String rows[] = new String[14];
				
				rows[0] = rs.getString("empid");
				rows[1] = rs.getString("january");
				rows[2] = rs.getString("february");
				rows[3] = rs.getString("march");
				rows[4] = rs.getString("april");
				rows[5] = rs.getString("may");
				rows[6] = rs.getString("june");
				rows[7] = rs.getString("july");
				rows[8] = rs.getString("august");
				rows[9] = rs.getString("september");
				rows[10] = rs.getString("october");
				rows[11] = rs.getString("november");
				rows[12] = rs.getString("december");
				rows[13] = rs.getString("leaves");
				
				leaveData.add(rows);
			}
			con.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		return leaveData;
	}
	
	public static int reset()
	{
		int status = 0;
		
		try
		{
			Connection con = getCon();
			
			PreparedStatement ps = con.prepareStatement("update leave_data set january = 0, february = 0, march = 0, april = 0, may = 0, june = 0, july = 0, august = 0, september = 0, october = 0, november = 0, december = 0, leaves = 15");
			
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
