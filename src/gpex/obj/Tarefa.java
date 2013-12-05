package gpex.obj;

import java.util.Date;

public class Tarefa {
	private int id;
	private String descricao;
	private Date prazo;
	private Reuniao reuniao;
	private Tarefa pai;
	private Projeto projeto;
	
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
	public Tarefa getPai() {
		return pai;
	}
	public void setPai(Tarefa pai) {
		this.pai = pai;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}
