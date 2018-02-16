package trabalhobiblioteca;

public class AluguelAluno implements ComportamentoAluguel {

    public AluguelAluno() {
        // TODO Auto-generated constructor stub
    }

    public int TempoEmprestimo() {
        return 5;
    }

    @Override
    public boolean aluguelPermitidoSusp(Usuario u, Livro l) {			//se ta suspenso
        return !u.estaAtrasado();
    }
    
    @Override
    public boolean aluguelPermitidoIgual(Usuario u, Livro l) {			//se j� alugou igual
        return !u.jaAlugou(l);
    }
    
    @Override
    public boolean aluguelPermitidoMax(Usuario u) {			//se tem a quant maxima de emprestimos
        return u.getNumEmprestimos() < 4;
    }
    
    public boolean aluguelPermitidoReserva(Usuario u, Livro l) {
    	if(l.numReservMaiornNumExem()) {    		
                return l.temReserva(u);
    	}else {
    		return true;
    	}
    }
    
}
