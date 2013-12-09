package gpex.obj;

public class Criterio {
	private int id;
	private String descricao;
	
	public Criterio(int id, String descricao){
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
