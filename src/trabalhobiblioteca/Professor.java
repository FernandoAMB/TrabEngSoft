package trabalhobiblioteca;

public class Professor extends Usuario implements ObserverLivro{

	public Professor(String id, String nome, ComportamentoAluguel comportamentoAluguel) {
		super(id, nome, comportamentoAluguel);
		// TODO Auto-generated constructor stub
	}
	
        @Override
	public void update(Livro livro) {
		System.out.println("O livro "+ livro.getTitulo() +" foi reservado duas vezes");
	}
}
