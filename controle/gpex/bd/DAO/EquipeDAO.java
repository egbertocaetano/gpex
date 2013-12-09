package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Equipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class EquipeDAO {
	private Connection conexao;
	private Statement comando;
	
	public void insere(Equipe equipe){
	      conectar();
	      try {
	         comando.executeUpdate("INSERT INTO Equipe VALUES('"
	               + equipe.getId() + "' , '" + equipe.getProjetoId() + "')");
	         System.out.println("Inserida!");
	      } catch (SQLException e) {
	         System.out.println("Erro ao inserir Equipe" + e.getMessage());
	      } finally {
	         fechar();
	      }
	   }
	
	public void apaga(int id) {
	      conectar();
	      try {
	         comando.executeUpdate("DELETE FROM Equipe WHERE id = '" + id
	                     + "';");
	      } catch (SQLException e) {
	         System.out.println("Erro ao apagar Equipe" + e.getMessage());
	      } finally {
	         fechar();
	      }
	}

	public Vector<Equipe> buscarTodos() {  
	      conectar();  
	      Vector<Equipe> resultados = new Vector<>();
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Equipe");  
	         while (rs.next()) {  
	            Equipe temp = new Equipe();  
	            // pega todos os atributos da Equipe  
	            temp.setId(rs.getInt("id"));
	            temp.setProjetoId(rs.getInt("projeto_id"));
	            resultados.add(temp);
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Equipes" + e.getMessage());  
	         return null;  
	      }  
	   }  

	
	   public void atualizar(Equipe equipe) {  
	      conectar();
	      String com = "UPDATE Equipe SET projeto_id = '" + equipe.getProjetoId()  
	            + "' WHERE  id = '" + equipe.getId() + "';";  
	      System.out.println("Atualizada!");  
	      try {  
	         comando.executeUpdate(com);  
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } finally {  
	         fechar();
	      }  
	   }  
	  
	   public Vector<Equipe> buscar(int id) {  
	      conectar();  
	      Vector<Equipe> resultados = new Vector<>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Equipe WHERE id LIKE '"  
	               + id + "%';");  
	         while (rs.next()) {  
	            Equipe temp = new Equipe();  
	            // pega todos os atributos da Equipe  
	            temp.setId(rs.getInt("id"));
	            temp.setProjetoId(rs.getInt("projeto_id"));
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Equipe" + e.getMessage());  
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
