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

public class ViewLeaveData extends JFrame
{
	static ViewLeaveData frame;
	
	public ViewLeaveData()
	{
		List<String[]> leaveDetail = LeaveDAO.viewLeaveData();
		int size = leaveDetail.size();
		
		String leaveData[][] = new String[size][14];
		int row = 0;
		
		for(String rowDetail[]: leaveDetail)
		{
			leaveData[row][0] = rowDetail[0];
			leaveData[row][1] = rowDetail[1];
			leaveData[row][2] = rowDetail[2];
			leaveData[row][3] = rowDetail[3];
			leaveData[row][4] = rowDetail[4];
			leaveData[row][5] = rowDetail[5];
			leaveData[row][6] = rowDetail[6];
			leaveData[row][7] = rowDetail[7];
			leaveData[row][8] = rowDetail[8];
			leaveData[row][9] = rowDetail[9];
			leaveData[row][10] = rowDetail[10];
			leaveData[row][11] = rowDetail[11];
			leaveData[row][12] = rowDetail[12];
			leaveData[row][13] = rowDetail[13];
			
			row++;
		}
		
		String columnNames[] = {"Employee ID", "Januray", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", "Leaves Remaining"};
		
		JTable jt = new JTable(leaveData, columnNames);
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		
		TableColumn column = null;
		column = jt.getColumnModel().getColumn(0);
		column.setPreferredWidth(150);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 400);
	}
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try
				{
					frame = new ViewLeaveData();
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