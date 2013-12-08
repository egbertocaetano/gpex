package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Candidato;
import gpex.obj.Projeto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProjetoDAO {
	private Connection conexao;
	private Statement comando;
	
	public void insere(Projeto projeto){
	      conectar();
	      try {
	         comando.executeUpdate("INSERT INTO Projeto VALUES('"
	               + projeto.getId() + "','" + projeto.getDescricao() + "')");
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
	         comando.executeUpdate("DELETE FROM Projeto WHERE id = '" + id
	                     + "';");
	      } catch (SQLException e) {
	         System.out.println("Erro ao apagar Candidato" + e.getMessage());
	      } finally {
	         fechar();
	      }
	}

	public Vector<Projeto> buscarTodos() {  
	      conectar();  
	      Vector<Projeto> resultados = new Vector<>();
	      ResultSet rs;
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Candidato");  
	         while (rs.next()) {  
	            Projeto temp = new Projeto();  
	            // pega todos os atributos da Projeto  
	            temp.setId(rs.getInt("id"));
	            temp.setDescricao(rs.getString("descricao"));
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Projetos" + e.getMessage());  
	         return null;  
	      }  
	   }  
	  
	public void atualizar(Projeto projeto) {  
	      conectar();
	      String com = "UPDATE Projeto SET descricao = '" + projeto.getDescricao()  
	            + "' WHERE  id = '" + projeto.getId() + "';";  
	      System.out.println("Atualizada!");  
	      try {  
	         comando.executeUpdate(com);  
	      } catch (SQLException e) {  
	         e.printStackTrace();  
	      } finally {  
	         fechar();
	      }  
	   }  
	  
	   public Vector<Projeto> buscar(int id) {  
	      conectar();  
	      Vector<Projeto> resultados = new Vector<>();  
	      ResultSet rs;  
	      try {  
	         rs = comando.executeQuery("SELECT * FROM Projeto WHERE id LIKE '"  
	               + id + "%';");  
	         while (rs.next()) {  
	            Projeto temp = new Projeto();  
	            // pega todos os atributos da Projeto  
	            temp.setId(rs.getInt("id"));
	            resultados.add(temp);  
	         }  
	         return resultados;  
	      } catch (SQLException e) {  
	         System.out.println("Erro ao buscar Projeto" + e.getMessage());  
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
