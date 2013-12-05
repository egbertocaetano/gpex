package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Tarefa;
import gpex.obj.Tarefa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TarefaDAO {
	/*
	TODO:
	private Connection conexao;
	private Statement comando;
	
	public void insere(Tarefa tarefa){
	      conectar();
	      try {
	         comando.executeUpdate("INSERT INTO Tarefa VALUES('"
	               + tarefa.getId() + "', '" + tarefa.getNome() + "',"
	               + tarefa.getMatricula() + ",'" + tarefa.getEmail() + "')");
	         System.out.println("Inserida!");
	      } catch (SQLException e) {
	         System.out.println("Erro ao inserir Tarefa" + e.getMessage());
	      } finally {
	         fechar();
	      }
	   }
	
	public void apaga(int id) {
	      conectar();
	      try {
	         comando.executeUpdate("DELETE FROM Tarefa WHERE id = '" + id
	                     + "';");
	      } catch (SQLException e) {
	         System.out.println("Erro ao apagar Tarefa" + e.getMessage());
	      } finally {
	         fechar();
	      }
	}

	public Vector<Tarefa> buscarTodos() {  
	      conectar();  
	      Vector<Tarefa> resultados = new Vector<Tarefa>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Tarefa");  
	         while (rs.next()) {  
	            Tarefa temp = new Tarefa();  
	            // pega todos os atributos do Tarefa  
	            temp.setId(rs.getInt("id"));  
	            temp.setNome(rs.getString("nome"));  
	            temp.setMatricula(rs.getString("matricula"));  
	            temp.setEmail(rs.getString("email"));  
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Tarefas" + e.getMessage());  
	         return null;  
	      }  
	   }  
	  
	   public void atualizar(Tarefa tarefa) {  
	      conectar();
	      String com = "UPDATE Tarefa SET nome = '" + tarefa.getNome()  
	            + "', matricula =" + tarefa.getMatricula() + ", email = '"  
	            + tarefa.getEmail() + "' WHERE  id = '" + tarefa.getId() + "';";  
	      System.out.println("Atualizada!");  
	      try {  
	         comando.executeUpdate(com);  
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } finally {  
	         fechar();
	      }  
	   }  
	  
	   public Vector<Tarefa> buscar(int id) {  
	      conectar();  
	      Vector<Tarefa> resultados = new Vector<Tarefa>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Tarefa WHERE id LIKE '"  
	               + id + "%';");  
	         while (rs.next()) {  
	            Tarefa temp = new Tarefa();  
	            // pega todos os atributos da Tarefa  
	            temp.setId(rs.getInt("id"));  
	            temp.setNome(rs.getString("nome"));  
	            temp.setMatricula(rs.getString("matricula"));  
	            temp.setEmail(rs.getString("email"));  
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Tarefa" + e.getMessage());  
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
	   }*/
}
