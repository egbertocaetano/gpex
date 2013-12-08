package gpex.bd.DAO.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BasicSql {

	/**
	 * Essa classe contém os comportamentos das subclasses deverão ter.
	 */
	
	protected Connection con = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	
	
	public abstract void inserir();
	
	public abstract void alterar();
	
	public abstract void deletar();
	
	public abstract void buscar();
	
	public void abreConexao(){
		
		try{
			
			con = DriverManager.getConnection("jdbc:h2:~/extensao;AUTO_SERVER=TRUE", "sa", "");
		
		}catch(SQLException ex){
			
			System.out.println("SQLExceptio: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("Erro: " + ex.getErrorCode());
		}
		
	}
	
	public void fechaConexao(){
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {
				System.out.println("SQLException: " + sqlEx.getMessage());
				System.out.println("SQLState: " + sqlEx.getSQLState());
				System.out.println("VendorError: " + sqlEx.getErrorCode());
			} 

			rs = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("SQLException: " + sqlEx.getMessage());
				System.out.println("SQLState: " + sqlEx.getSQLState());
				System.out.println("VendorError: " + sqlEx.getErrorCode());
			} 

			stmt = null;
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException sqlEx) {
				
				System.out.println("SQLException: " + sqlEx.getMessage());
				System.out.println("SQLState: " + sqlEx.getSQLState());
				System.out.println("VendorError: " + sqlEx.getErrorCode());
				
			} 

			con = null;
		}
		
	}
}
