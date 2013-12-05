package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Candidato;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CandidatoDAO {
	private Connection conexao;
	private Statement comando;
	
	public void insere(Candidato candidato){
	      conectar();
	      try {
	         comando.executeUpdate("INSERT INTO Candidato VALUES('"
	               + candidato.getId() + "', '" + candidato.getNome() + "',"
	               + candidato.getMatricula() + ",'" + candidato.getEmail() + "')");
	         System.out.println("Inserida!");
	      } catch (SQLException e) {
	         System.out.println("Erro ao inserir Candidato" + e.getMessage());
	      } finally {
	         fechar();
	      }
	   }
	
	public void apaga(int id) {
	      conectar();
	      try {
	         comando.executeUpdate("DELETE FROM Candidato WHERE id = '" + id
	                     + "';");
	      } catch (SQLException e) {
	         System.out.println("Erro ao apagar Candidato" + e.getMessage());
	      } finally {
	         fechar();
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
