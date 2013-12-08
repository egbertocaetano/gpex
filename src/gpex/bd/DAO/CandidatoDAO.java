package gpex.bd.DAO;

import gpex.bd.ConnectionFactory;
import gpex.obj.Candidato;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class CandidatoDAO extends BasicSql {
	private Connection conexao;
	private Statement comando;

	public void insere(Candidato candidato) {
		conectar();
		try {
			comando.executeUpdate("INSERT INTO Candidato VALUES('"
					+ candidato.getId() + "', '" + candidato.getNome() + "',"
					+ candidato.getMatricula() + ",'" + candidato.getEmail()
					+ "')");
			System.out.println("Inserida!");
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Candidato" + e.getMessage());
		} finally {
			fechar();
		}
	}

	public void apaga(int id) {
		conectar();
		try {
			comando.executeUpdate("DELETE FROM Candidato WHERE id = '" + id
					+ "';");
		} catch (SQLException e) {
			System.out.println("Erro ao apagar Candidato" + e.getMessage());
		} finally {
			fechar();
		}
	}

	public Vector<Candidato> buscarTodos() {
		conectar();
		Vector<Candidato> resultados = new Vector<Candidato>();
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM Candidato");
			while (rs.next()) {
				Candidato temp = new Candidato(rs.getInt("id"),
						rs.getString("nome"), rs.getString("matricula"),
						rs.getString("email"));
				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Candidatos" + e.getMessage());
			return null;
		}
	}

	public void atualizar(Candidato candidato) {
		conectar();
		String com = "UPDATE Candidato SET nome = '" + candidato.getNome()
				+ "', matricula =" + candidato.getMatricula() + ", email = '"
				+ candidato.getEmail() + "' WHERE  id = '" + candidato.getId()
				+ "';";
		System.out.println("Atualizada!");
		try {
			comando.executeUpdate(com);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			fechar();
		}
	}

	public Vector<Candidato> buscar(int id) {
		conectar();
		Vector<Candidato> resultados = new Vector<Candidato>();
		ResultSet rs;
		try {
			rs = comando.executeQuery("SELECT * FROM Candidato WHERE id LIKE '"
					+ id + "%';");
			while (rs.next()) {
				Candidato temp = new Candidato(rs.getInt("id"),
						rs.getString("nome"), rs.getString("matricula"),
						rs.getString("email"));
				resultados.add(temp);
			}
			return resultados;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar Candidato" + e.getMessage());
			return null;
		}

	}

	private void conectar() {
		try {
			this.conexao = ConnectionFactory.getConnection();
			this.comando = this.conexao.createStatement();
			System.out.println("Conectado!");
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao carregar o driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Erro ao conectar" + e.getMessage());
		}
	}

	private void fechar() {
		try {
			this.comando.close();
			this.conexao.close();
			System.out.println("Conexão Fechada");
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexão" + e.getMessage());
		}
	}

	@Override
	public void inserir(Candidato candidato) {
		comando.executeUpdate("INSERT INTO Candidato VALUES('"
				+ candidato.getId() + "', '" + candidato.getNome() + "',"
				+ candidato.getMatricula() + ",'" + candidato.getEmail() + "')");

	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buscar() {
		// TODO Auto-generated method stub

	}
}
