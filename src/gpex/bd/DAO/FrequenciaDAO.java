package gpex.bd.DAO;

import gpex.obj.Frequencia;

import java.util.ArrayList;

// TODO:	Seria o ideal deixar as variáveis iguais às colunas do banco?
//			Ex: É reuniao_id no banco, mas idReuniao aqui.

public class FrequenciaDAO extends BasicSql{
	
	private Frequencia frequencia;
	
	/*
	 * Insere as informações de um objeto Frequencia em uma nova linha no banco de dados.
	 * @param	Objeto Frequencia com as informações a serem inseridas.
	 */
	@Override
	public void inserir(Object object) throws Exception{
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
        stmt.executeUpdate("INSERT INTO Frequencia VALUES('"
               + frequencia.getIdIntegrante() + "', '" + frequencia.getIdReuniao() + "')");
         
         System.out.println("Frequencia cadastrada com sucesso.");
         
         fechaConexao();
	}
	
	/*
	 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Frequencia passado. 
	 * @param	Objeto cuja linha de mesmo id no banco será alterada.
	 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
	 * TODO:	set dataHoraReuniao where idIntegrante OU set idIntegrante where dataHoraReuniao?
	 * TODO 2:	Pensando bem, como essa tabela é NxN, usar qualquer um dos jeitos acima vai dar errado (vai setar o reuniao_id
	 * 			de todas as ocorrências, por exemplo).
	 */
	@Override
	public void alterar(Object object) throws Exception {
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
		/*stmt.executeUpdate("UPDATE Frequencia SET reuniao_id = '" + frequencia.getIdReuniao()
				+ "' WHERE  integrante_id = '" + frequencia.getIdIntegrante()
				+ "';");
		*/
		
		/*
		stmt.executeUpdate("UPDATE Frequencia SET integrante_id = '" + frequencia.getIdIntegrante()
				+ "' WHERE reuniao_id = '" + frequencia.getIdReuniao()
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
	public void deletar(Object object) throws Exception {
		
		frequencia = (Frequencia) object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Frequencia WHERE idIntegrante = '" + frequencia.getIdIntegrante() 
				+ "' AND idReuniao = '" + frequencia.getIdReuniao() + "';");
		
		fechaConexao();
		
		
	}
	
	/*
	 * Busca todas as linhas da tabela Frequencia
	 * @return	Uma ArrayList de objetos Frequencia contendo cada em um uma linha da tabela.
	 */
	@Override
	public ArrayList<Object> buscarTodos() throws Exception{
		
		ArrayList<Object> resultados = new ArrayList<Object>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Frequencia");
		while (rs.next()) {
			Frequencia temp = new Frequencia(rs.getInt("integrante_id"),
					rs.getInt("reuniao_id"));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
	}
	
	/*
	 * Busca uma linha da tabela Frequencia de acordo com seu id.
	 * @param	Id da linha a ser buscada.
	 * @return	Um objeto Frequencia com as informações da linha buscada.
	 * TODO:	Busca pelo idIntegrante? ou pelo idReuniao?
	 */
	@Override
	public Object buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Fequencia WHERE idIntegrante LIKE '"
				+ id + "%';");
		
		/*
		rs = stmt.executeQuery("SELECT * FROM Reuniao WHERE idIntegrante LIKE '"
				+ id + "%';");
		*/
		
		Frequencia temp = new Frequencia(rs.getInt("integrante_id"),
				rs.getInt("reuniao_id"));
		
		fechaConexao();
		
		return temp;
	}
}
