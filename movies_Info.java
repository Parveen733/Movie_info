package com.parveen.movies;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;




public class movies_Info {
		
	
		public static void main(String[] args) throws Exception
	    {
			
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");
	        String sql="create database cinema";
	        PreparedStatement st=con.prepareStatement(sql);
	        st.execute();
	        con.close();
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "root");
	        System.out.println("Database created successfully...");
	        Statement st2=conn.createStatement();
	       st2.executeUpdate("create table movies(movie varchar(40), actor varchar(20), actress varchar(20), release_date int(4), director varchar(25));");
	       System.out.println("Table created successfully...");
	        
	        PreparedStatement pst2=conn.prepareStatement("insert into movies values(?,?,?,?,?)");
	        pst2.setString(1, "Baahubali: The Beginning");
			pst2.setString(2, "Prabhas");
			pst2.setString(3, "Tamannaah");
			pst2.setInt(4, 2015);
			pst2.setString(5,"S. S. Rajamouli");
			pst2.executeUpdate();
			
	        //int rowCount2=pst1.executeUpdate();
	        pst2.setString(1, "Baahubali 2: The Conclusion");
			pst2.setString(2, "Prabhas");
			pst2.setString(3, "Anushka Shetty");
			pst2.setInt(4, 2017);
			pst2.setString(5,"S. S. Rajamouli");
			pst2.executeUpdate();
	       // int rowCount=pst1.executeUpdate();
			System.out.println("Values inserted successfully...");
			
			PreparedStatement pst3=conn.prepareStatement("select * from movies");
			ResultSet rs=pst3.executeQuery();
			ResultSetMetaData md=rs.getMetaData();
			System.out.println("--------------------------------------------------------------------------------------------------------");
			System.out.print("|"+md.getColumnName(1)+"\t\t\t");
			//System.out.print("\t"+md.getColumnName(1)+"\t\t");
			System.out.print("\t|"+md.getColumnName(2)+"\t\t");
			System.out.print("|"+md.getColumnName(3)+"\t");
			System.out.print("\t|"+md.getColumnName(4)+"\t");
			System.out.println("|"+md.getColumnName(5)+"       |");
			System.out.println("--------------------------------------------------------------------------------------------------------");
	        
		       
	        while(rs.next())
	        {
	            System.out.println("|"+rs.getString(1)+"\t|"+rs.getString(2)+"\t|"+rs.getString(3)+"\t\t|"+rs.getInt(4)+"\t\t|"+rs.getString(5)+"|");
	            
	        }
	        System.out.println("--------------------------------------------------------------------------------------------------------");
	    }
	}
