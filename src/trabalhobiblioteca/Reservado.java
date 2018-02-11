package trabalhobiblioteca;

public class Reservado implements EstadoExemplar {
	public EstadoExemplar estado;
	private static Reservado instancia;

	public Reservado() {
	}
    
	public static Reservado getInstancia() {
    	if(instancia == null) {
    		instancia = new Reservado();
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
