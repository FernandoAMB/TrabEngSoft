package trabalhobiblioteca;

public interface ComportamentoAluguel {

    public int TempoEmprestimo();

    public boolean aluguelPermitidoSusp(Usuario u, Livro l);
    public boolean aluguelPermitidoIgual(Usuario u, Livro l);
    public boolean aluguelPermitidoMax(Usuario u);
}
