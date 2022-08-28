package com.rashmi;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
public class SelectOperation {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///movies","root", null);   
			
			if(con!=null){
				System.out.println("Connected Successfullty");
			}
			else{
			System.out.println("Connected....");	
			}
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from movie");
	
			while(rs.next()){
			//System.out.println(rs.getInt(1)+" - "+rs.getString(2)+" - "+rs.getString(3)+" - "+rs.getString(4));
			System.out.println(rs.getInt("Sr No")+" - "+rs.getString("MovieName")+" - "+rs.getString("Hero")+" - "+rs.getString("Heroine"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
