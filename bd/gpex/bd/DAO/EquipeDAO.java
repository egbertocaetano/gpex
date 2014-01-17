package gpex.bd.DAO;

import gpex.obj.Equipe;

import java.util.ArrayList;

public class EquipeDAO extends BasicSql<Equipe>{
	private Equipe equipe;
	
	/*
	 * Insere as informações de um objeto Equipe em uma nova linha no banco de dados.
	 * @param	Objeto Equipe com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Equipe object) throws Exception{
		
		equipe = object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Equipe VALUES('"
               + equipe.getId() + "', '" + equipe.getProjeto().getId() + "')");
         
         System.out.println("Equipe cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Equipe passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 */
	@Override
	public void alterar(Equipe object) throws Exception {
		
		equipe = object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Equipe SET descricao = '" + equipe.getProjeto().getId()
				+ "' WHERE  id = '" + equipe.getId()
				+ "';");
		
		
		System.out.println("Equipe atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Equipe fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Equipe object) throws Exception {
		
		equipe = object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Equipe WHERE id = '" + equipe.getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Equipe
	 * @return	Uma ArrayList de objetos Equipe contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Equipe> buscarTodos() throws Exception{
		
		ArrayList<Equipe> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Equipe");
		while (rs.next()) {
			Equipe temp = new Equipe(
					rs.getInt("id"),
					new ProjetoDAO().buscarId(rs.getInt("projetoId")));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Equipe de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Equipe com as informações da linha buscada.
	 */
	@Override
	public Equipe buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Equipe WHERE id LIKE '"
				+ id + "%';");
		
		Equipe temp = new Equipe(
				rs.getInt("id"),
				new ProjetoDAO().buscarId(rs.getInt("projetoId")));
		
		fechaConexao();
		
		return temp;
	}
}
