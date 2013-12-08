package gpex.bd.DAO;

import gpex.obj.Criterio;

import java.util.ArrayList;

public class CriterioDAO extends BasicSql{

	private Criterio criterio;
	
	/*
	 * Insere as informações de um objeto Criterio em uma nova linha no banco de dados.
	 * @param	Objeto Criterio com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Object object) throws Exception{
		
		criterio = (Criterio) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Criterio VALUES('"
               + criterio.getId() + "', '" + criterio.getDescricao() + "')");
         
         System.out.println("Criterio cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Criterio passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 */
	@Override
	public void alterar(Object object) throws Exception {
		
		criterio = (Criterio) object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Criterio SET descricao = '" + criterio.getDescricao()
				+ "' WHERE  id = '" + criterio.getId()
				+ "';");
		
		
		System.out.println("Criterio atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Criterio fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Object object) throws Exception {
		
		criterio = (Criterio) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Criterio WHERE id = '" + criterio.getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Criterio
	 * @return	Uma ArrayList de objetos Criterio contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Object> buscarTodos() throws Exception{
		
		ArrayList<Object> resultados = new ArrayList<Object>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Criterio");
		while (rs.next()) {
			Criterio temp = new Criterio(rs.getInt("id"),
					rs.getString("descricao"));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Criterio de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Criterio com as informações da linha buscada.
	 */
	@Override
	public Object buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Criterio WHERE id LIKE '"
				+ id + "%';");
		
		Criterio temp = new Criterio(rs.getInt("id"),
				rs.getString("descricao"));
		
		fechaConexao();
		
		return temp;
	}
}
