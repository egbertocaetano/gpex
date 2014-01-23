package gpex.obj;

import java.sql.Timestamp;

public class Tarefa {
	private int id;
	private String descricao;
	private Timestamp prazo;
	private Reuniao reuniao;
	private Tarefa pai;
	private Projeto projeto;
	
	public Tarefa(int id, String descricao, Timestamp prazo, Reuniao reuniao, Tarefa pai, Projeto projeto){
		this.id = id;
		this.descricao = descricao;
		this.prazo = prazo;
		this.reuniao = reuniao;
		this.pai = pai;
		this.projeto = projeto;
	}
	
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public Timestamp getPrazo() {
		return prazo;
	}
	public Reuniao getReuniao() {
		return reuniao;
	}
	public Tarefa getPai() {
		return pai;
	}
	public Projeto getProjeto() {
		return projeto;
	}
}
