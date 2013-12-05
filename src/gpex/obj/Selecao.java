package gpex.obj;

import java.sql.Timestamp;
import java.util.Date;

public class Selecao {
	private int id;
	private Date data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
}
