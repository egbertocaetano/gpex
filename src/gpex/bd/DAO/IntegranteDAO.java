package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Integrante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class IntegranteDAO {
	private Connection conexao;
	private Statement comando;
	
	public void insere(Integrante integrante){
	      conectar();
	      try {
	         comando.executeUpdate("INSERT INTO Integrante VALUES('"
	               + integrante.getCandidatoId() + "', '" + integrante.getEquipeId() + "')");
	         System.out.println("Inserida!");
	      } catch (SQLException e) {
	         System.out.println("Erro ao inserir Integrante" + e.getMessage());
	      } finally {
	         fechar();
	      }
	   }
	
	public void apaga(int candidatoId) {
	      conectar();
	      try {
	         comando.executeUpdate("DELETE FROM Integrante WHERE candidato_id = '" + candidatoId
	                     + "';");
	      } catch (SQLException e) {
	         System.out.println("Erro ao apagar Integrante" + e.getMessage());
	      } finally {
	         fechar();
	      }
	}

	public Vector<Integrante> buscarTodos() {  
	      conectar();  
	      Vector<Integrante> resultados = new Vector<Integrante>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Integrante");  
	         while (rs.next()) {  
	            Integrante temp = new Integrante();  
	            // pega todos os atributos do Integrante  
	            temp.setCandidatoId(rs.getInt("candidato_id"));  
	            temp.setEquipeId(rs.getInt("equipe_id"));   
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Integrantes" + e.getMessage());  
	         return null;  
	      }  
	   }  
	  
	   public void atualizarCandidatoId(Integrante integrante) {  
	      conectar();
	      String com = "UPDATE Integrante SET candidato_id = '" + integrante.getCandidatoId()  
	            + "' WHERE  equipe_id = '" + integrante.getEquipeId() + "';";  
	      System.out.println("Atualizada!");  
	      try {  
	         comando.executeUpdate(com);  
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } finally {  
	         fechar();
	      }  
	   }  
	   
	   public void atualizarEquipeId(Integrante integrante) {  
		      conectar();
		      String com = "UPDATE Integrante SET equipe_id = '" + integrante.getEquipeId()  
		            + "' WHERE  candidato_id = '" + integrante.getCandidatoId() + "';";  
		      System.out.println("Atualizada!");  
		      try {  
		         comando.executeUpdate(com);  
		      } catch (SQLException e) {  
		         e.printStackTrace();  
		      } finally {  
		         fechar();
		      }  
		   }  
	  
	   public Vector<Integrante> buscar(int id) {  
	      conectar();  
	      Vector<Integrante> resultados = new Vector<Integrante>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Integrante WHERE id LIKE '"  
	               + id + "%';");  
	         while (rs.next()) {  
	            Integrante temp = new Integrante();  
	            // pega todos os atributos da Integrante  
	            temp.setCandidatoId(rs.getInt("candidato_id"));  
	            temp.setEquipeId(rs.getInt("equipe_id"));  
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Integrante" + e.getMessage());  
	         return null;  
	      }  
	  
	   }  
	
	private void conectar() {
	      try {
	         this.conexao = ConnectionFactory.getConnection();
	         this.comando = this.conexao.createStatement();
	         System.out.println("Conectado!");
	      } catch (ClassNotFoundException e) {
	    	  System.out.println("Erro ao carregar o driver" + e.getMessage());  
	      } catch (SQLException e) {
	         System.out.println("Erro ao conectar" + e.getMessage());
	      }
	   }
	
	private void fechar() {
	      try {
	         this.comando.close();
	         this.conexao.close();
	         System.out.println("Conexão Fechada");
	      } catch (SQLException e) {
	         System.out.println("Erro ao fechar conexão" + e.getMessage());
	      }
	   }
}
