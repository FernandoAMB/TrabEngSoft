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
//		Exemplar e = Exemplar.getInstancia();
		e.setEstado(Disponivel.getInstancia());
		System.out.println("O exemplar esta disponivel");
	}

	@Override
	public void emprestou(Exemplar e) {
//		Exemplar e = Exemplar.getInstancia();
		e.setEstado(Emprestado.getInstancia());
		System.out.println("O exemplar esta emprestado");
	}
}
