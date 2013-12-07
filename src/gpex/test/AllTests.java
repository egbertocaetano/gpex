package gpex.test;

import junit.framework.TestCase;
import gpex.obj.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class AllTests extends TestCase {

	Candidato candidato = new Candidato(0, "Valber", "20112823829",
			"valber@ufrrj.br");

	public void testaAluno() throws Exception {
		assertEquals("Valber", candidato.getNome());
	}

}
