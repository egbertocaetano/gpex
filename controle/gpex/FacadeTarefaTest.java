package gpex;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FacadeTarefaTest {

	/*@Test
	public void inserirTest() {
		FacadeTarefa fct = new FacadeTarefa();
		
		try{
			assertEquals("Deve retornar 0", 0, fct.salvar(null, null, null, (Integer) null, (Integer) null, (Integer) null));
		}catch(Exception e){
			e.printStackTrace();
//			fail("Não deveria lançar exceções");
		}
	}
	*/
	@Test
	public void alterarTest() {
		FacadeTarefa fct = new FacadeTarefa();
		
		try{
			assertEquals("Deve retornar 0", 0, fct.alterar(1, null, null, null, (Integer) null, (Integer) null, (Integer) null));
		}catch(Exception e){
			e.printStackTrace();
//			fail("Não deveria lançar exceções");
		}
	}
	
	@Test
	public void deletarTest() {
		FacadeTarefa fct = new FacadeTarefa();
		
		try{
			assertEquals("Deve retornar 0", 0, fct.deletar(1, null, null, null, (Integer) null, (Integer) null, (Integer) null));
		}catch(Exception e){
			e.printStackTrace();
//			fail("Não deveria lançar exceções");
		}
	}
	
	@Test
	public void buscarTodos() {
		FacadeTarefa fct = new FacadeTarefa();
		
		try{
			assertEquals("Deve retornar um ArrayList", new ArrayList<Object[]>(), fct.buscarTodos());
		}catch(Exception e){
			e.printStackTrace();
//			fail("Não deveria lançar exceções");
		}
	}
	
	@Test
	public void buscarId() {
		FacadeTarefa fct = new FacadeTarefa();
		
		try{
			assertEquals("Deve retornar 0", new Object[]{}, fct.buscarId(1));
		}catch(Exception e){
			e.printStackTrace();
//			fail("Não deveria lançar exceções");
		}
	}

}
