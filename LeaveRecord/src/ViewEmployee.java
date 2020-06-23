import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

public class ViewEmployee extends JFrame
{
	static ViewEmployee frame;
	
	public ViewEmployee()
	{
		List<String[]> employeeDetail = EmployeeDAO.viewAllEmployeeData();
		int size = employeeDetail.size();
		
		String employeeData[][] = new String[size][7];
		int row = 0;
		
		for(String rowDetail[]: employeeDetail)
		{
			employeeData[row][0] = rowDetail[0];
			employeeData[row][1] = rowDetail[1];
			employeeData[row][2] = rowDetail[2];
			employeeData[row][3] = rowDetail[3];
			employeeData[row][4] = rowDetail[4];
			employeeData[row][5] = rowDetail[5];
			employeeData[row][6] = rowDetail[6];
			
			row++;
		}
		
		String columnNames[] = {"Employee ID", "Employee Name", "Designation", "Branch", "Salary", "Date of Birth", "Leaves Remaining"};
		
		JTable jt = new JTable(employeeData, columnNames);
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		
		TableColumn column = null;
		column = jt.getColumnModel().getColumn(0);
		column.setPreferredWidth(150);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 400);
	}
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try
				{
					frame = new ViewEmployee();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
}