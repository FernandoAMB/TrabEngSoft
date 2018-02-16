package trabalhobiblioteca;

public class AluguelProfessor implements ComportamentoAluguel {

    public AluguelProfessor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int TempoEmprestimo() {
        return 7;
    }

    @Override
    public boolean aluguelPermitidoIgual(Usuario u, Livro l) {		//se ja alugou igual
        return !u.jaAlugou(l);
    }

    @Override
    public boolean aluguelPermitidoSusp(Usuario u, Livro l) {
        return true;
    }

    @Override
    public boolean aluguelPermitidoMax(Usuario u) {
        return true;
    }

    @Override
    public boolean aluguelPermitidoReserva(Usuario u, Livro l) {
        return true;
    }
}
