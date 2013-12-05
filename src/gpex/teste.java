package gpex;

import gpex.bd.DAO.CandidatoDAO;
import gpex.obj.Candidato;

public class teste {
	//Hey Git
	
	//git 2
	
	//git três
	
	// git 4 Thiago
	
	public static void main(String[] args) {
		Candidato candidato = new Candidato();
		CandidatoDAO candDAO = new CandidatoDAO();
		
		candidato.setId(10);
		candidato.setNome("Testenílson Testudo da Silva");
		candidato.setMatricula("2014780000");
		candidato.setEmail("testao@gmail.com");
		
		candDAO.insere(candidato);
		candDAO.apaga(10);
	}
	
}
