package jdbcdemo;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Table {



 
    
	public enum eMonth{
		January(1) ,February(2), March(3), April(4), May(5), June(6) , July(7), August(8), September(9), October(10) , November (11), December(12);
		 public int monthVal;
		 eMonth(int monthVal){
			 this.monthVal =monthVal;
		 }
		   public int getmonthVal() {
		        return monthVal;
		    }
	}
	
	
	

	static JFrame frmBuildingMenu;
	private static JTable table;
	public static  Integer _apartmentNo = 0;
	public static String _Payment = null;
	public static String  _Month;
	private JTextField tfInput;
	private JTextField tfInput1;
	private JTextField tlfmonth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Table window = new Table();
					window.frmBuildingMenu.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

		ResultSet rs = DB.getInstance().runQuery("select * from resident");
		
		System.out.println("tenant table now: ");

		
		fillTable(rs);
		
	}

	/**
	 * Create the application.
	 */
	public Table() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuildingMenu = new JFrame();
		frmBuildingMenu.setTitle("Building Menu");
		frmBuildingMenu.getContentPane().setFont(new Font("Dialog", Font.BOLD, 28));
		frmBuildingMenu.getContentPane().setBackground(new Color(245, 245, 245));
		frmBuildingMenu.setBounds(150, 150, 1273, 1002);
		frmBuildingMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuildingMenu.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 173, 1189, 471);
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0), 2));
		frmBuildingMenu.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 26));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			
			},
			new String[] {
				"Apartment_No", "Last_name", "First_name", "Last_Pay_Month", "Total__Remain_Payment"
			}
		));
		 table.getTableHeader().setPreferredSize(new Dimension(140, 50));
		 table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JButton btnPay = new JButton("Select No.");
		btnPay.setBounds(44, 657, 265, 67);
		btnPay.setFont(new Font("Dialog", Font.BOLD, 32));
		btnPay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model = (DefaultTableModel) table.getModel();
//				int a = model.getRowCount();
//				StringBuilder sb = new StringBuilder();
//				sb.append("");
//				sb.append(a);
//				String myString = sb.toString();
		
				if (_apartmentNo == null) {
					 	JOptionPane.showMessageDialog(null, "you need to insert/change a Apartment_No and then press Pay!");
					 	return;
					} 
				else if (_apartmentNo > 45 || _apartmentNo <= 0)
				{
				JOptionPane.showMessageDialog(null, "you need to insert Apartment_No between 1-45!");	
				}
				ResultSet rs = DB.runQuery("Select * From resident where ApartmentNo="+ _apartmentNo);
				fillTable(rs);
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				_apartmentNo = null;
				_Payment = null;
			}
		});
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmBuildingMenu.getContentPane().add(btnPay);
		
		tfInput = new JTextField();
		tfInput.setBounds(907, 691, 180, 39);
		tfInput.setFont(new Font("Tahoma", Font.BOLD, 22));
		tfInput.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int foo = Integer.parseInt(tfInput.getText());
				_apartmentNo = foo;
				System.out.println(_apartmentNo);
			
			}
		});
		frmBuildingMenu.getContentPane().add(tfInput);
		tfInput.setColumns(10);
		
		JLabel lblFd = new JLabel("Building Committe System");
		lblFd.setBounds(-78, 32, 1280, 117);
		lblFd.setHorizontalAlignment(SwingConstants.CENTER);
		lblFd.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 98));
		frmBuildingMenu.getContentPane().add(lblFd);
		
		tfInput1 = new JTextField();
		tfInput1.setBounds(907, 749, 180, 39);
		tfInput1.addFocusListener(new FocusAdapter() {
			@Override
			
				public void focusLost(FocusEvent e) {
				_Payment = tfInput1.getText();
				System.out.println(_Payment);
			}
		});
		tfInput1.setFont(new Font("Tahoma", Font.BOLD, 22));
		tfInput1.setColumns(10);
		frmBuildingMenu.getContentPane().add(tfInput1);
		
		JLabel lblNewLabel = new JLabel("Apartment No.:");
		lblNewLabel.setBounds(638, 691, 243, 33);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(lblNewLabel);
		
		JLabel lblPayment = new JLabel("Payment:");
		lblPayment.setBounds(635, 755, 208, 33);
		lblPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblPayment.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(lblPayment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(520, 1124, 131, -12);
		frmBuildingMenu.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 924, 1095, 1);
		frmBuildingMenu.getContentPane().add(separator_1);
		
		JButton btnUpdate = new JButton("Update_of_Pay");
		btnUpdate.setBounds(44, 732, 265, 67);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 32));
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (_Payment == null && _apartmentNo == null) {
				 	JOptionPane.showMessageDialog(null, "you need to insert/change a Apartment_No & Payment and then press Update Pay!");
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				}
				else if (_Payment == null) {JOptionPane.showMessageDialog(null, "you need to insert a Payment and then press Update Pay!");
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				}
				else if (_apartmentNo == null) {JOptionPane.showMessageDialog(null, "you need to insert a ApartmentNo and then press Update Pay!");
					tfInput.setText("");
					tfInput1.setText("");
					tlfmonth.setText("");
					}
				else if (_Payment != null && _apartmentNo != null)  {	
				ResultSet rs = DB.UpdateQuery("update library.resident set Payment = ? where ApartmentNo = ? ");
				ResultSet rs1 = DB.runQuery("Select * From resident where ApartmentNo="+ _apartmentNo);
				fillTable(rs1);
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				_apartmentNo = null;
				_Payment = null;
				}
			}
		});

		btnUpdate.addActionListener(
				new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
		       
			}
		});
		frmBuildingMenu.getContentPane().add(btnUpdate);
		
		JButton btnApartmentpay = new JButton("Resident_Pay");
		btnApartmentpay.setBounds(321, 732, 270, 67);
		btnApartmentpay.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(btnApartmentpay);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(34, 654, 1063, 1);
		frmBuildingMenu.getContentPane().add(separator_2);
		
		JButton btnMonthpay = new JButton("By_Month_Pay");
		btnMonthpay.setBounds(321, 657, 270, 67);
		btnMonthpay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
			
				
				if (_Month == null  ) JOptionPane.showMessageDialog(null, "you need to insert Month and then press Pay!");		 	
				
		
				
				ResultSet rs4 = DB.runQuery("Select * From resident where Last_Month='" +_Month  +  "'");
				fillTable(rs4);
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				_Payment = null;
				_Month = null;
			}
		});
		btnMonthpay.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(btnMonthpay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(638, 812, 208, 33);
		lblMonth.setHorizontalAlignment(SwingConstants.LEFT);
		lblMonth.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(lblMonth);
		
		tlfmonth = new JTextField();
		tlfmonth.setBounds(907, 812, 180, 39);
		tlfmonth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				_Month = tlfmonth.getText();
				
				System.out.println(_Month);
			}
		});
		tlfmonth.setFont(new Font("Tahoma", Font.BOLD, 22));
		tlfmonth.setColumns(10);
		frmBuildingMenu.getContentPane().add(tlfmonth);
		
		JButton btnShowAll = new JButton("Show all");
		btnShowAll.setBounds(44, 826, 547, 67);
		btnShowAll.addActionListener(new ActionListener() {
			@Override
			public void  actionPerformed(ActionEvent e) {
				ResultSet rs3 = DB.getInstance().runQuery("select * from resident");
				fillTable(rs3);
				tfInput.setText("");
				tfInput1.setText("");
				tlfmonth.setText("");
				
			}
			
		});
		btnShowAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShowAll.setFont(new Font("Dialog", Font.BOLD, 32));
		frmBuildingMenu.getContentPane().add(btnShowAll);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1191, 994, 270, 305);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\u05DC\u05D9\u05DE\u05D5\u05D3\u05D9\u05DD \u05DE\u05D3\u05DE\u05D7\\\u05E4\u05D9\u05EA\u05D5\u05D7 \u05D9\u05D9\u05E9\u05D5\u05DE\u05D9\u05DD \u05DC\u05D8\u05DC\u05E4\u05D5\u05E0\u05D9\u05DD \u05E0\u05D9\u05D9\u05D3\u05D9\u05DD\\Icons\\Build1.jpg"));
		frmBuildingMenu.getContentPane().add(lblNewLabel_1);

	}
	
	
	
	public static void fillTable(ResultSet rs) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		System.out.println(model.getRowCount());
		for (int i =  model.getRowCount() - 1;i >=0 ; i--) {
			model.removeRow(i);
		}
		
		try {
			while(rs.next()) {
				String[] row = {rs.getString("ApartmentNo"), rs.getString("fname"), rs.getString("lname"), rs.getString("Last_month"),rs.getString("Payment")};
				model.addRow(row);
				table.setRowHeight(model.getRowCount()-1 ,35);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
	}
}


