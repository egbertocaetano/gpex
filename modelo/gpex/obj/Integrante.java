package gpex.obj;

public class Integrante {
	private Candidato candidato;
	private Equipe equipe;
	
	public Integrante(Candidato candidato, Equipe equipe){
		this.candidato = candidato;
		this.equipe = equipe;
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	public Equipe getEquipe() {
		return equipe;
	}
}