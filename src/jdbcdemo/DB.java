package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DB {
	static String url ="jdbc:mysql://localhost:3306/library";
	static String user ="root";
	static String password ="A123456";
	static Connection myConn;
	private static DB db;
	
	private DB(){
		try {
			myConn = DriverManager.getConnection(url, user, password);
//			JOptionPane.showMessageDialog(null, "You Are Connected!");
			JOptionPane.showMessageDialog(null, "You Are Connected!","DataBase Connection",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	public static DB getInstance() { 
		if (db == null) {
			db = new DB();
		}
		return db;
	}

	static public ResultSet UpdateQuery(String query) {
		ResultSet myRs = null;
		if (query == null) return null;		
		try {			 			
//			Statement myStmt = myConn.createStatement();
			PreparedStatement pt = myConn.prepareStatement(query);
			pt.setString(1, Table._Payment);
			pt.setInt(2, Table._apartmentNo);
			pt.executeUpdate();
			
			
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}		
		return myRs;
		
	}


	


	
	public static ResultSet runQuery(String query) {
		ResultSet myRs = null;
		if (query == null) return null;
		System.out.println(query);
		try {			 			
			Statement myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(query);
			
		
			}
			catch(Exception exc)
			{
				exc.printStackTrace();
			}		
		return myRs;
		
	}
	
	
	
	
	
	
	
	
	//myStmt = myConn.prepareStatement("select * from tenant where payment > 600 and Last_Month = March ");
	
	//myStmt.setDouble(1, 1000);
	//myStmt.setString(2, "Legal");
	
	//myRs= myStmt.executeQuery();


	//Statement myStmt = myConn.createStatement();
	//String sql = "insert into tenant"
	//+ " (ApartmentNo,lname, fname, Last_Month, payment)"
	//+ " values('58', 'Barry', 'Goren','March' , '1950')";
	//System.out.println("insert completed!");
	
	//String sql1 = "update tenant"
	//		+ " set lname='Damian'"
	//		+ " where ApartmentNo=58";
	//System.out.println("update completed!");
	//myStmt.executeUpdate(sql1);
	
	//String sql2 = "delete from tenant where fname='Lori'";
	//int rowsAffected = myStmt.executeUpdate(sql2);
	//System.out.println("rows affected: "  + rowsAffected);
	//System.out.println("Delete completed!\n");
	

	

}
