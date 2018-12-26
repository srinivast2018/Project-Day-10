package com.ibm.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	public Statement connectDatabase()throws SQLException
	{
	Connection c=DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries","foodsonfinger_atoz","welcome@123");
	Statement stmt=c.createStatement();

	return stmt;
	}
	
	
	public int countRecords(String query)throws SQLException
	{
		int count=0;
		Connection c=DriverManager.getConnection("jdbc:mysql://foodsonfinger.com:3306/foodsonfinger_atozgroceries","foodsonfinger_atoz","welcome@123");
		Statement st=c.createStatement();
		ResultSet rs=st.executeQuery(query);
	
		if(rs.next())
		{
		count=rs.getInt(1);
		}
		return count;
	}
	
}
