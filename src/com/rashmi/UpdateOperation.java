package com.rashmi;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class UpdateOperation {
	private static String UPDATE_QUERY="Update movie set MovieName='Bhaghi3' where MovieName='Bhaghi'"; 
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql:///movies";
	private static String user="root";
	private static String pwd=null;

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			st=con.createStatement();
			
			int recordCount=st.executeUpdate(UPDATE_QUERY);
			System.out.println("Record Count : "+recordCount);
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
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}