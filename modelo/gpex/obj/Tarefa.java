package gpex.obj;

import java.sql.Timestamp;

public class Tarefa {
	
	private int id;
	private String nome;
	private String descricao;
	private Timestamp prazo;
	private Tarefa pai;
	private Projeto projeto;
	private Integrante responsavel;
	
	
	public Tarefa(String nome, String descricao, Timestamp prazo,Tarefa pai, Projeto projeto, Integrante responsavel){
		this.nome = nome;
		this.descricao = descricao;
		this.prazo = prazo;
		this.pai = pai;
		this.projeto = projeto;
		this.responsavel = responsavel;
	}
	
	public Tarefa(int id, String nome, String descricao, Timestamp prazo,Tarefa pai, Projeto projeto, Integrante responsavel){
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.prazo = prazo;
		this.pai = pai;
		this.projeto = projeto;
		this.responsavel = responsavel;
	}
	
	public int getId() {
		return id;
	}
	public String getNome(){
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public Timestamp getPrazo() {
		return prazo;
	}
	public Tarefa getPai() {
		return pai;
	}
	public Projeto getProjeto() {
		return projeto;
	}
}
