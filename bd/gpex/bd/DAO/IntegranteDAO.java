package gpex.bd.DAO;

import gpex.obj.Candidato;
import gpex.obj.Equipe;
import gpex.obj.Integrante;
import gpex.obj.Projeto;

import java.util.ArrayList;

public class IntegranteDAO extends BasicSql<Integrante>{
	private Integrante integrante;
	
	/*
	 * Insere as informações de um objeto Integrante em uma nova linha no banco de dados.
	 * @param	Objeto Integrante com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Integrante object) throws Exception{
		
		integrante = object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Integrante VALUES('"
               + integrante.getCandidato().getId() + "', '" + integrante.getEquipe().getId() + "')");
         
         System.out.println("Integrante cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Integrante passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 * TODO:	set candidatoId where equipeId OU set equipeId where candidatoId?
	 * TODO 2:	Pensando bem, como essa tabela é NxN, usar qualquer um dos jeitos acima vai dar errado (vai setar o equipeId
	 * 			de todas as ocorrências, por exemplo).
	 */
	@Override
	public void alterar(Integrante object) throws Exception {
		
		integrante = object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Integrante SET equipeId = '" + integrante.getEquipe().getId()
				+ "' WHERE candidatoId = '" + integrante.getCandidato().getId()
				+ "';");
		
		
		System.out.println("Integrante atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Integrante fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Integrante object) throws Exception {
		
		integrante = object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Integrante WHERE equipeId = '" + integrante.getEquipe().getId() 
				+ "' AND candidatoId = '" + integrante.getCandidato().getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Integrante
	 * @return	Uma ArrayList de objetos Integrante contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Integrante> buscarTodos() throws Exception{
		
		ArrayList<Integrante> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Integrante");
		while (rs.next()) {
			Integrante temp = new Integrante(
					new CandidatoDAO().buscarId(rs.getInt("candidatoId")),
					new EquipeDAO().buscarId(rs.getInt("equipeId")));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Integrante de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Integrante com as informações da linha buscada.
	 * TODO:	É melhor passar o objeto como parâmentro?
	 */
	@Override
	public Integrante buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Integrante WHERE candidatoId LIKE '" + id + "%';");
		
		Integrante temp = new Integrante(
				new CandidatoDAO().buscarId(rs.getInt("candidatoId")),
				new EquipeDAO().buscarId(rs.getInt("equipeId")));
				//new Candidato(10, "sahduas", "hsuh", "haushuahs"), new Equipe(29, new Projeto(22, "descricaosd")));
		
		fechaConexao();
		
		return temp;
	}
}
