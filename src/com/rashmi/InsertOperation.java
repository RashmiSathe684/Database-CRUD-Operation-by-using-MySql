package com.rashmi;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class InsertOperation {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///movies","root", null);
			st=con.createStatement();
			int recordCount=st.executeUpdate("Insert into movie values(1,'RRR','JrNTR','Alia')");
			System.out.println("Record Count: "+recordCount);
			
			rs=st.executeQuery("select * from movie");
			while(rs.next()){
				System.out.println(rs.getInt("Sr No")+" - "+rs.getString("MovieName")+" - "+rs.getString("Hero")+" - "+rs.getString("Heroine"));
				}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
			st.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}
