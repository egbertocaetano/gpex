package gpex.obj;

public class Candidato {
	private int id;
	private String nome;
	private String matricula;
	private String email;
	
	public Candidato (int id, String nome, String matricula, String email){
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getEmail() {
		return email;
	}


}