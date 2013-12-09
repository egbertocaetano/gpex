package gpex.bd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BasicSql<E> {

	/**
	 * Essa classe contém os comportamentos das subclasses deverão ter.
	 */
	
	protected Connection con = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	
	
	public abstract void inserir(E object) throws Exception;
	
	public abstract void alterar(Object object) throws Exception;
	
	public abstract void deletar(Object object) throws Exception;
	
	public abstract ArrayList<Object> buscarTodos() throws Exception;
	
	public abstract Object buscarId(int id) throws Exception;
	
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
