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
	private String status;
	
	
	public Tarefa(String nome, Timestamp prazo, Integrante responsavel, String descricao, Tarefa pai, Projeto projeto){
		this.nome = nome;
		this.descricao = descricao;
		this.prazo = prazo;
		this.pai = pai;
		this.projeto = projeto;
		this.responsavel = responsavel;
	}
	
	public Tarefa(int id, String nome, Timestamp prazo, Integrante responsavel, String descricao, Tarefa pai, Projeto projeto){
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
	
	public Integrante getResponsavel() {
		return responsavel;
	}
}
