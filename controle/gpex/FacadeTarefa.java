package gpex;

import gpex.bd.DAO.ProjetoDAO;
import gpex.bd.DAO.ReuniaoDAO;
import gpex.bd.DAO.TarefaDAO;
import gpex.obj.Tarefa;

import java.sql.Timestamp;
import java.util.ArrayList;

public class FacadeTarefa {
	
	public int inserir(int id, String descricao, Timestamp prazo, int reuniao_id, int pai_id, int projeto_id) throws Exception{
		new TarefaDAO().inserir(new Tarefa(
				id,
				descricao,
				prazo,
				new ReuniaoDAO().buscarId(reuniao_id),
				new TarefaDAO().buscarId(pai_id),
				new ProjetoDAO().buscarId(projeto_id)));
		
		return 0;
	}
	
	public int alterar(int id, String descricao, Timestamp prazo, int reuniao_id, int pai_id, int projeto_id) throws Exception{
		new TarefaDAO().alterar(new Tarefa(
				id,
				descricao,
				prazo,
				new ReuniaoDAO().buscarId(reuniao_id),
				new TarefaDAO().buscarId(pai_id),
				new ProjetoDAO().buscarId(projeto_id)));
		
		return 0;
	}
	
	public int deletar(int id, String descricao, Timestamp prazo, int reuniao_id, int pai_id, int projeto_id) throws Exception{
		new TarefaDAO().deletar(new Tarefa(
				id,
				descricao,
				prazo,
				new ReuniaoDAO().buscarId(reuniao_id),
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
					,tarefa.getReuniao().getId()
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
				,tarefa.getReuniao().getId()
				,tarefa.getPai().getId()
				,tarefa.getProjeto().getId()
		};
	}
	
}
