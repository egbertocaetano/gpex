package gpex.obj;

import java.util.Date;

public class Selecao {
	private int id;
	private Date data;
	
	public Selecao(int id, Date data){
		this.id = id;
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public Date getData() {
		return data;
	}
}
