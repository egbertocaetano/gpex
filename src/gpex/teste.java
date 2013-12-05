package gpex;

import gpex.bd.DAO.CandidatoDAO;
import gpex.obj.Candidato;

import java.util.Vector;

public class teste {
	
	public static void main(String[] args) {
		Candidato candidato = new Candidato();
		CandidatoDAO candDAO = new CandidatoDAO();
		
		
		candidato.setId(10);
		candidato.setNome("Testenílson Testudo da Silva");
		candidato.setMatricula("2014780000");
		candidato.setEmail("testao@gmail.com");
		
		//candDAO.insere(candidato);
		//candDAO.apaga(10);
		
		//candidato.setMatricula("20147801111");
		//candDAO.atualizar(candidato);
		
		//Vector<Candidato> v = candDAO.buscarTodos();
		//System.out.println(v.get(0).getNome());
	}
	
}
