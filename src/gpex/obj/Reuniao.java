package gpex.obj;

import java.sql.Timestamp;

public class Reuniao {
	private int id;
	private Timestamp dataHora;
	private String observacao;
	
	public Reuniao(int id, Timestamp dataHora, String observacao){
		this.id = id;
		this.dataHora = dataHora;
		this.observacao = observacao;
	}
	
	public int getId() {
		return id;
	}
	public Timestamp getDataHora() {
		return dataHora;
	}
	public String getObservacao() {
		return observacao;
	}
}
