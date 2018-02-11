package trabalhobiblioteca;

public class Professor extends Usuario implements ObserverLivro{

	public Professor(int id, String nome, ComportamentoAluguel comportamentoAluguel) {
		super(id, nome, comportamentoAluguel);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Livro livro) {
		System.out.println("O livro "+ livro.titulo +" foi reservado duas vezes");
	}
}
