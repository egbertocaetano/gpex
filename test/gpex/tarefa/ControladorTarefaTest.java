package gpex.tarefa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import gpex.obj.Projeto;
import gpex.obj.Reuniao;
import gpex.obj.Tarefa;

import java.sql.Timestamp;

import org.junit.Test;

public class ControladorTarefaTest {
	
	private Tarefa tarefa;
	private ControladorTarefa controlador;

	@Test
	public void testInsereComDescricaoNula() throws Exception {
		controlador = new ControladorTarefa();
		tarefa = new Tarefa(0, null, new Timestamp(System.currentTimeMillis()), 
				new Reuniao(0, new Timestamp(System.currentTimeMillis()), null), null, new Projeto(0, null));
		try{
			controlador.insere(tarefa);
			fail("Uma excecao deveria ter sido lancada");
		}catch(ExcecaoInsercao e){
			assertEquals(ControladorTarefa.DESCRICAO_NAO_PODE_SER_NULA, e.getMessage());
		}
		
	}
	
}
