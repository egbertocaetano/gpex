package gpex.bd.DAO;

import gpex.obj.Projeto;

import java.util.ArrayList;

public class ProjetoDAO extends BasicSql<Projeto>{
	private Projeto projeto;
	
	/*
	 * Insere as informações de um objeto Projeto em uma nova linha no banco de dados.
	 * @param	Objeto Projeto com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Projeto object) throws Exception{
		
		projeto = (Projeto) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Projeto VALUES('"
               + projeto.getId() + "', '" + projeto.getDescricao() + "')");
         
         System.out.println("Projeto cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Projeto passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 */
	@Override
	public void alterar(Projeto object) throws Exception {
		
		projeto = (Projeto) object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Projeto SET descricao = '" + projeto.getDescricao()
				+ "' WHERE  id = '" + projeto.getId()
				+ "';");
		
		
		System.out.println("Projeto atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Projeto fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Projeto object) throws Exception {
		
		projeto = (Projeto) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Projeto WHERE id = '" + projeto.getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Projeto
	 * @return	Uma ArrayList de objetos Projeto contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Projeto> buscarTodos() throws Exception{
		
		ArrayList<Projeto> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Projeto");
		while (rs.next()) {
			Projeto temp = new Projeto(rs.getInt("id"),
					rs.getString("descricao"));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Projeto de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Projeto com as informações da linha buscada.
	 */
	@Override
	public Projeto buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Projeto WHERE id LIKE '"
				+ id + "%';");
		
		Projeto temp = new Projeto(rs.getInt("id"),
				rs.getString("descricao"));
		
		fechaConexao();
		
		return temp;
	}
}
