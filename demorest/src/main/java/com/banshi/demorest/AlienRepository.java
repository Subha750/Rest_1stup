package com.banshi.demorest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository 
{ 
  Connection con=null;
  
  public AlienRepository()
  {
	  String url="jdbc:mysql://localhost:3306/banshiplg";
	  String username="root";
	  String password="banshi";
	  try
	  {
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection(url,username,password);
	  }
	  catch(Exception e)
	  {
		 System.out.println(e); 
	  }
  }
  
  public List<Alien> getAliens()
  {
	  List<Alien>aliens=new ArrayList<>();
	  String sql="select * from alien";
	  try
	  {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			Alien a=new Alien();
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			
			aliens.add(a);
		}
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  return aliens;
  }
  public Alien getAlien(int id)
  {
	  String sql="select * from alien where id="+id;
	  Alien a=new Alien();
	  try
	  {
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next())
		{
			
			a.setId(rs.getInt(1));
			a.setName(rs.getString(2));
			
		}
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  return a;
  }
public void create(Alien a1) {
	String sql="insert into alien values(?,?)";
	 
	  try
	  {
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,a1.getId());
		st.setString(2,a1.getName());
		st.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
}

//update resources
public void update(Alien a1) {
	String sql="update alien set name=? where id=?";
	 
	  try
	  {
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,a1.getName());
		st.setInt(2,a1.getId());
		st.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
}
public void delete(int id) {
	String sql="delete from alien where id=?";
	 
	  try
	  {
		PreparedStatement st=con.prepareStatement(sql);
		st.setInt(1,id);
		st.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	  
}

}
