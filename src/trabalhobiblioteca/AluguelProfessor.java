package trabalhobiblioteca;

public class AluguelProfessor implements ComportamentoAluguel {

    public AluguelProfessor() {
        // TODO Auto-generated constructor stub
    }

    public int TempoEmprestimo() {
        return 7;
    }

    @Override
    public boolean aluguelPermitido(Usuario u, Livro l) {
        return !u.jaAlugou(l);
    }
}
