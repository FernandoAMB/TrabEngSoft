package trabalhobiblioteca;

public interface ComportamentoAluguel {

    public int TempoEmprestimo();

    public boolean aluguelPermitido(Usuario u, Livro l);
}
