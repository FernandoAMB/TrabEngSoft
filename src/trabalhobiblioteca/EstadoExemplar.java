package trabalhobiblioteca;

public interface EstadoExemplar {
	public void devolveu(Exemplar e);	
	public void emprestou(Exemplar e);
	public void reservou(Exemplar e);
}
