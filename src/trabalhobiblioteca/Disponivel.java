package trabalhobiblioteca;

public class Disponivel implements EstadoExemplar {
	public EstadoExemplar estado;
	private static Disponivel instancia;

	public Disponivel() {
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
