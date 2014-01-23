package gpex.tarefa;

import gpex.obj.Tarefa;

public class ControladorTarefa {

	public static final String DESCRICAO_NAO_PODE_SER_NULA = "Descricao nao pode ser nula";

	public void insere(Tarefa tarefa) throws ExcecaoInsercao{
		throw new ExcecaoInsercao(DESCRICAO_NAO_PODE_SER_NULA);		
	}
	
	

}
