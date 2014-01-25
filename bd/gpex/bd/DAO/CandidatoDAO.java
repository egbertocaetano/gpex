package gpex.bd.DAO;

import gpex.obj.Candidato;

import java.util.ArrayList;

public class CandidatoDAO extends BasicSql<Candidato>{
	
	private Candidato candidato;
	
	@Override
	public void inserir(Candidato object) throws Exception{
		
		candidato = object;
		
		abreConexao();
		stmt = con.createStatement();
		
		stmt.executeUpdate("INSERT INTO Candidato VALUES('"
				+ candidato.getId() + "', '" + candidato.getNome() + "',"
				+ candidato.getMatricula() + ",'" + candidato.getEmail()
				+ "')");
		
		System.out.println("Candidato cadastrado com sucesso.");
		
		fechaConexao();
	}

	@Override
	public void alterar(Candidato object) throws Exception {
		
		candidato = object;
		
		abreConexao();
		
		stmt.executeUpdate("UPDATE Candidato SET nome = '" + candidato.getNome()
				+ "', matricula =" + candidato.getMatricula() + ", email = '"
				+ candidato.getEmail() + "' WHERE  id = '" + candidato.getId()
				+ "';");
		
		System.out.println("Candidato atualizado com sucesso.");
		
		fechaConexao();
		
		
	}

	@Override
	public void deletar(Candidato object)throws Exception {
		
		candidato = object;
		
		abreConexao();
		
		stmt.executeUpdate("DELETE FROM Candidato WHERE id = '" + candidato.getId() + "';");
		
		fechaConexao();
		
		
	}

	@Override
	
	public ArrayList<Candidato> buscarTodos()throws Exception{
	
		
		ArrayList<Candidato> resultados = new ArrayList<>();
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Candidato");
		while (rs.next()) {
			Candidato temp = new Candidato(rs.getInt("id"),
					rs.getString("nome"), rs.getString("matricula"),
					rs.getString("email"));
			resultados.add(temp);
	
		}
		
		fechaConexao();
		
		return resultados;
		
		
	}
	
	@Override
	public Candidato buscarId(int id) throws Exception {
		
		abreConexao();
		
		rs = stmt.executeQuery("SELECT * FROM Candidato WHERE id LIKE '"
				+ id + "%';");
		
		Candidato temp = new Candidato(rs.getInt("id"),
				rs.getString("nome"), rs.getString("matricula"),
				rs.getString("email"));
		
		
		fechaConexao();
		
		return temp;
	}
}
