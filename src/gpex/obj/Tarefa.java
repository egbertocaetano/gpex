package gpex.obj;

import java.sql.Timestamp;

public class Tarefa {
	private int id;
	private String descricao;
	private Timestamp prazo;
	private Timestamp reuniao;
	//private Tarefa pai;
	private int pai;
	//private Projeto projeto;
	private int projeto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Timestamp getPrazo() {
		return prazo;
	}
	public void setPrazo(Timestamp prazo) {
		this.prazo = prazo;
	}
	public Timestamp getReuniao() {
		return reuniao;
	}
	public void setReuniao(Timestamp reuniao) {
		this.reuniao = reuniao;
	}
	public int getPai() {
		return pai;
	}
	public void setPai(int pai) {
		this.pai = pai;
	}
	public int getProjeto() {
		return projeto;
	}
	public void setProjeto(int projeto) {
		this.projeto = projeto;
	}
}
