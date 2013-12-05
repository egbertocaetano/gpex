package gpex.obj;

import java.util.Date;

public class Tarefa {
	private int id;
	private String descricao;
	private Date prazo;
	private Reuniao reuniao;
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
	public Date getPrazo() {
		return prazo;
	}
	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}
	public Reuniao getReuniao() {
		return reuniao;
	}
	public void setReuniao(Reuniao reuniao) {
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
