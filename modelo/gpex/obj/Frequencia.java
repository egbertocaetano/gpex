package gpex.obj;

public class Frequencia {
	private Integrante integrante;
	private Reuniao reuniao;
	
	public Frequencia(Integrante integrante, Reuniao reuniao){
		this.integrante = integrante;
		this.reuniao = reuniao;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

}
