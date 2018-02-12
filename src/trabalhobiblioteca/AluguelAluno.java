package trabalhobiblioteca;

public class AluguelAluno implements ComportamentoAluguel {

    public AluguelAluno() {
        // TODO Auto-generated constructor stub
    }

    public int TempoEmprestimo() {
        return 5;
    }

    @Override
    public boolean aluguelPermitido(Usuario u) {
        return u.getNumEmprestimos() <= 4;
    }
}
