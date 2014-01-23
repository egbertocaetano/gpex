package gpex.bd.DAO;

import gpex.obj.Tarefa;

import java.util.ArrayList;

public class TarefaDAO extends BasicSql<Tarefa>{
	
	private Tarefa tarefa;
	
	/*
	 * Insere as informações de um objeto Tarefa em uma nova linha no banco de dados.
	 * @param	Objeto Tarefa com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Tarefa object) throws Exception{
		
		tarefa = (Tarefa) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Tarefa VALUES('"
               + tarefa.getId() + "', '" + tarefa.getDescricao() 
               + "', '" + tarefa.getPrazo() + "', '" + tarefa.getReuniao() 
               + "', '" + tarefa.getPai() + "', '" + tarefa.getProjeto() + "')");
         
         System.out.println("Tarefa cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Tarefa passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 */
	@Override
	public void alterar(Tarefa object) throws Exception {
		
		tarefa = (Tarefa) object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Tarefa SET descricao = '" + tarefa.getDescricao() 
				+ "', prazo = '" + tarefa.getPrazo() + "', reuniaoId = " + tarefa.getReuniao() 
				+ ", tarefaPaiId = " + tarefa.getPai() + ", projetoId = " + tarefa.getProjeto() 
				+ " WHERE  id = '" + tarefa.getId() + "';");
		
		
		System.out.println("Tarefa atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Tarefa fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Tarefa object) throws Exception {
		
		tarefa = (Tarefa) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Tarefa WHERE id = '" + tarefa.getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Tarefa
	 * @return	Uma ArrayList de objetos Tarefa contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Tarefa> buscarTodos() throws Exception{
		
		ArrayList<Tarefa> resultados = new ArrayList<Tarefa>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Tarefa");
		while (rs.next()) {
			Tarefa temp = new Tarefa(rs.getInt("id"),
					rs.getString("descricao"),
					rs.getTimestamp("prazo"),
					new ReuniaoDAO().buscarId(rs.getInt("reuniaoId")),
					new TarefaDAO().buscarId(rs.getInt("tarefaPaiId")),
					new ProjetoDAO().buscarId(rs.getInt("projetoId")));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Tarefa de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Tarefa com as informações da linha buscada.
	 */
	@Override
	public Tarefa buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Tarefa WHERE id LIKE '"
				+ id + "%';");
		
		Tarefa temp = new Tarefa(rs.getInt("id"),
				rs.getString("descricao"),
				rs.getTimestamp("prazo"),
				new ReuniaoDAO().buscarId(rs.getInt("reuniaoId")),
				new TarefaDAO().buscarId(rs.getInt("tarefaPaiId")),
				new ProjetoDAO().buscarId(rs.getInt("projetoId")));
		
		fechaConexao();
		
		return temp;
	}
}
