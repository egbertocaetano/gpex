package gpex.obj;

public class Projeto {
	private int id;
	private String descricao;
	
	public Projeto(int id, String descricao){
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
}
