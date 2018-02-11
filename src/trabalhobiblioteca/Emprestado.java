package trabalhobiblioteca;

public class Emprestado implements EstadoExemplar {
	public EstadoExemplar estado;
	private static Emprestado instancia;

	public Emprestado() {
	}
	
    public static Emprestado getInstancia() {
    	if(instancia == null) {
    		instancia = new Emprestado();
    	}
    	return instancia;
    }

	@Override
	public void devolveu(Exemplar e) {
//		Exemplar e = Exemplar.getInstancia();
		e.setEstado(new Disponivel());
		System.out.println("O exemplar esta disponivel");
	}

	@Override
	public void emprestou(Exemplar e) {
//		Exemplar e = Exemplar.getInstancia();
		e.setEstado(new Emprestado());
		System.out.println("O exemplar esta emprestado");
	}
	
	@Override
	public void reservou(Exemplar e) {
//		Exemplar e = Exemplar.getInstancia();
		e.setEstado(new Reservado());
		System.out.println("O exemplar esta reservado");
	}

}
