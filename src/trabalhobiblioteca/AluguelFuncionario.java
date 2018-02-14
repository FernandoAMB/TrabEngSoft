package trabalhobiblioteca;

public class AluguelFuncionario implements ComportamentoAluguel {

    public AluguelFuncionario() {
        // TODO Auto-generated constructor stub
    }

    public int TempoEmprestimo() {
        return 2;
    }

    @Override
    public boolean aluguelPermitido(Usuario u, Livro l) {
        return u.getNumEmprestimos() <= 3 && !u.estaAtrasado() && !u.jaAlugou(l);
    }
}
