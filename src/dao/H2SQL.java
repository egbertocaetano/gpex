package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class H2SQL {

	
	protected Connection conn;
	protected Statement stmt;
	protected ResultSet st;
	
	
	public void connect(){
		
		try{
			conn = DriverManager.getConnection("");
		}catch(SQLException ex){
			
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendoErro:" + ex.getErrorCode() );
		}
	}
	
	
	public void disconnect(){
		
	}
}
