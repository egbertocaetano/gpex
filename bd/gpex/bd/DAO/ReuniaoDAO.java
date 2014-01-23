package gpex.bd.DAO;
	
import gpex.obj.Reuniao;

import java.util.ArrayList;
	
	public class ReuniaoDAO extends BasicSql<Reuniao>{
		
		private Reuniao reuniao;
		
		/*
		 * Insere as informações de um objeto Reuniao em uma nova linha no banco de dados.
		 * @param	Objeto Reuniao com as informações a serem inseridas.
		 */
		@Override
		public void inserir(Reuniao object) throws Exception{
			
			reuniao = (Reuniao) object;
			
			abreConexao();
			
	        stmt.executeUpdate("INSERT INTO Reuniao VALUES('"
	               + reuniao.getId() + "', '" + reuniao.getDataHora() + "',"
	               + reuniao.getObservacao() + "')");
	         
	         System.out.println("Reuniao cadastrada com sucesso.");
	         
	         fechaConexao();
		}
		
		/*
		 * Altera uma linha no banco de dados cujo id coincida com a id do objeto Reuniao passado. 
		 * @param	Objeto cuja linha de mesmo id no banco será alterada.
		 * 			Todas as informações (excetuando o id) contidas neste objeto sobreporão as atuais no banco.
		 */
		@Override
		public void alterar(Reuniao object) throws Exception {
			
			reuniao = (Reuniao) object;
			
			abreConexao();
			
			stmt.executeUpdate("UPDATE Reuniao SET dataHora = '" + reuniao.getDataHora()
					+ "', observacao =" + reuniao.getObservacao() + "' WHERE  id = '" + reuniao.getId()
					+ "';");
			
			System.out.println("Reuniao atualizada com sucesso.");
			
			fechaConexao();
			
			
		}
		
		/*
		 * Deleta um objeto no banco de acordo com o id do objeto Reuniao fornecido.
		 * @param	Objeto cuja linha de mesmo id no banco será deletada.
		 */
		@Override
		public void deletar(Reuniao object) throws Exception {
			
			reuniao = (Reuniao) object;
			
			abreConexao();
			
			stmt.executeUpdate("DELETE FROM Reuniao WHERE id = '" + reuniao.getId() + "';");
			
			fechaConexao();
			
			
		}
		
		/*
		 * Busca todas as linhas da tabela Reuniao
		 * @return	Uma ArrayList de objetos Reuniao contendo cada em um uma linha da tabela.
		 */
		@Override
		public ArrayList<Reuniao> buscarTodos() throws Exception{
			
			ArrayList<Reuniao> resultados = new ArrayList<>();
			
			abreConexao();
			
			rs = stmt.executeQuery("SELECT * FROM Reuniao");
			while (rs.next()) {
				Reuniao temp = new Reuniao(rs.getInt("id"),
						rs.getTimestamp("dataHora"), rs.getString("observacao"));
				resultados.add(temp);
		
			}
			
			fechaConexao();
			
			return resultados;
		}
		
		/*
		 * Busca uma linha da tabela Reuniao de acordo com seu id.
		 * @param	Id da linha a ser buscada.
		 * @return	Um objeto Reuniao com as informações da linha buscada.
		 */
		@Override
		public Reuniao buscarId(int id) throws Exception {
			
			abreConexao();
			
			rs = stmt.executeQuery("SELECT * FROM Reuniao WHERE id LIKE '"
					+ id + "%';");
			
			Reuniao temp = new Reuniao(rs.getInt("id"),
					rs.getTimestamp("dataHora"), rs.getString("observacao"));
			
			fechaConexao();
			
			return temp;
		}
	}
