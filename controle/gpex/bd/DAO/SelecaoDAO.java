package gpex.bd.DAO;

import gpex.obj.Selecao;

import java.util.ArrayList;

public class SelecaoDAO extends BasicSql<Selecao>{
	private Selecao selecao;
	
	/*
	 * Insere as informações de um objeto Selecao em uma nova linha no banco de dados.
	 * @param	Objeto Selecao com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Selecao object) throws Exception{
		
		selecao = (Selecao) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Selecao VALUES('"
               + selecao.getId() + "', '" + selecao.getData() + "')");
         
         System.out.println("Selecao cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Selecao passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 */
	@Override
	public void alterar(Selecao object) throws Exception {
		
		selecao = (Selecao) object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Selecao SET data = '" + selecao.getData()
				+ "' WHERE  id = '" + selecao.getId()
				+ "';");
		
		
		System.out.println("Selecao atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Selecao fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Selecao object) throws Exception {
		
		selecao = (Selecao) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Selecao WHERE id = '" + selecao.getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Selecao
	 * @return	Uma ArrayList de objetos Selecao contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Selecao> buscarTodos() throws Exception{
		
		ArrayList<Selecao> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Selecao");
		while (rs.next()) {
			Selecao temp = new Selecao(rs.getInt("id"),
					rs.getDate("data"));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Selecao de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Selecao com as informações da linha buscada.
	 */
	@Override
	public Selecao buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Selecao WHERE id LIKE '"
				+ id + "%';");
		
		Selecao temp = new Selecao(rs.getInt("id"),
				rs.getDate("data"));
		
		fechaConexao();
		
		return temp;
	}
}
