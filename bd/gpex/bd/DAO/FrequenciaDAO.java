package gpex.bd.DAO;

import gpex.obj.Frequencia;

import java.util.ArrayList;

public class FrequenciaDAO extends BasicSql<Frequencia>{
	
	private Frequencia frequencia;
	
	/*
	 * Insere as informações de um objeto Frequencia em uma nova linha no banco de dados.
	 * @param	Objeto Frequencia com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Frequencia object) throws Exception{
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Frequencia VALUES('"
               + frequencia.getIntegrante().getCandidato().getId() + "', '" + frequencia.getReuniao().getId() + "')");
         
         System.out.println("Frequencia cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Frequencia passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 * TODO:	set reuniaoId where integranteId OU set integranteId where reuniaoId?
	 * TODO 2:	Pensando bem, como essa tabela é NxN, usar qualquer um dos jeitos acima vai dar errado (vai setar o reuniaoId
	 * 			de todas as ocorrências, por exemplo).
	 */
	@Override
	public void alterar(Frequencia object) throws Exception {
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
		/*stmt.executeUpdate("UPDATE Frequencia SET reuniaoId = '" + frequencia.getReuniaoId()
				+ "' WHERE  integranteId = '" + frequencia.getIntegranteId()
				+ "';");
		*/
		
		/*
		stmt.executeUpdate("UPDATE Frequencia SET integranteId = '" + frequencia.getIntegranteId()
				+ "' WHERE reuniaoId = '" + frequencia.getReuniaoId()
				+ "';");
		*/
		
		System.out.println("Frequencia atualizada com sucesso.");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Deleta um objeto no banco de acordo com o id do objeto Frequencia fornecido.
	 * @param	Objeto cuja linha de mesmo id no banco será deletada.
	 */
	@Override
	public void deletar(Frequencia object) throws Exception {
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Frequencia WHERE integranteId = '" + frequencia.getIntegrante().getCandidato().getId() 
				+ "' AND reuniaoId = '" + frequencia.getReuniao().getId() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Frequencia
	 * @return	Uma ArrayList de objetos Frequencia contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Frequencia> buscarTodos() throws Exception{
		
		ArrayList<Frequencia> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Frequencia");
		while (rs.next()) {
			Frequencia temp = new Frequencia(
					new IntegranteDAO().buscarId(rs.getInt("integranteId")),
					new ReuniaoDAO().buscarId(rs.getInt("reuniaoId")));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Frequencia de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Frequencia com as informações da linha buscada.
	 * TODO:	Busca pelo IntegranteId? ou pelo ReuniaoId?
	 */
	@Override
	public Frequencia buscarId(int integranteId) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Fequencia WHERE integranteId LIKE '"
				+ integranteId + "%';");
		
		Frequencia temp = new Frequencia(
				new IntegranteDAO().buscarId(rs.getInt("integranteId")),
				new ReuniaoDAO().buscarId(rs.getInt("reuniaoId")));
		
		fechaConexao();
		
		return temp;
	}
}
