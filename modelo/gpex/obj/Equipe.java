package gpex.obj;

public class Equipe {
	private int id;
	private Projeto projeto;
	
	public Equipe(int id, Projeto projeto){
		this.id = id;
		this.projeto = projeto;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public int getId() {
		return id;
	}	
}
