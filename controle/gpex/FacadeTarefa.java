package gpex;

import gpex.bd.DAO.IntegranteDAO;
import gpex.bd.DAO.ProjetoDAO;
import gpex.bd.DAO.TarefaDAO;
import gpex.obj.Tarefa;

import java.sql.Timestamp;
import java.util.ArrayList;

public  class FacadeTarefa {
	
	
	private static FacadeTarefa instancia;
	
	
	public static FacadeTarefa getInstance(){
		
		if(instancia ==null){
			instancia = new FacadeTarefa();
		}
		
		return instancia;
		
	}
	
	public static int salvar(String nome, String descricao, Timestamp prazo, int pai_id, int projeto_id, int responsavel_id) throws Exception{
		new TarefaDAO().inserir(new Tarefa(
				nome,
				descricao,
				prazo,
				new TarefaDAO().buscarId(pai_id),
				new ProjetoDAO().buscarId(projeto_id),
				new IntegranteDAO().buscarId(responsavel_id)));
		
		return 0;
	}
	
	public static int alterar(int id, String nome, String descricao, Timestamp prazo, int reuniao_id, int pai_id, int projeto_id, int responsavel_id) throws Exception{
		new TarefaDAO().alterar(new Tarefa(
				id,
				nome,
				descricao,
				prazo,
				new TarefaDAO().buscarId(pai_id),
				new ProjetoDAO().buscarId(projeto_id),
				new IntegranteDAO().buscarId(responsavel_id)));
		
		return 0;
	}
	
	public static int deletar(int id, String nome, String descricao, Timestamp prazo, int reuniao_id, int pai_id, int projeto_id) throws Exception{
		new TarefaDAO().deletar(new Tarefa(
				id,
				nome,
				descricao,
				prazo,
				new TarefaDAO().buscarId(pai_id),
				new ProjetoDAO().buscarId(projeto_id)));
		
		return 0;
	}
	
	public ArrayList<Object[]> buscarTodos() throws Exception{
		ArrayList<Tarefa> listaTarefas = new TarefaDAO().buscarTodos();
		ArrayList<Object[]> listaTarefasSplited = new ArrayList<>();
		for (Tarefa tarefa : listaTarefas) {
			listaTarefasSplited.add(new Object[]{
					tarefa.getId()
					,tarefa.getDescricao()
					,tarefa.getPrazo()
					,tarefa.getPai().getId()
					,tarefa.getProjeto().getId()
			});
		}
		
		return listaTarefasSplited;
		
	}
	
	public Object[] buscarId(int id) throws Exception{
		Tarefa tarefa = new TarefaDAO().buscarId(id);
		return new Object[]{
				tarefa.getId()
				,tarefa.getDescricao()
				,tarefa.getPrazo()
				,tarefa.getPai().getId()
				,tarefa.getProjeto().getId()
		};
	}
	
}
