package trabalhobiblioteca;

public class Disponivel implements EstadoExemplar {
	private static Disponivel instancia;

	private Disponivel() {
	}
	
    public static Disponivel getInstancia() {
    	if(instancia == null) {
    		instancia = new Disponivel();
    	}
    	return instancia;
    }

	@Override
	public void devolveu(Exemplar e) {
		e.setEstado(Disponivel.getInstancia());
		System.out.println("O exemplar está disponivel");
	}

	@Override
	public void emprestou(Exemplar e) {
		e.setEstado(Emprestado.getInstancia());
		System.out.println("O exemplar está emprestado");
	}
}
