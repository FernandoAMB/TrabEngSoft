package trabalhobiblioteca;

public class AluguelFuncionario implements ComportamentoAluguel {

    public AluguelFuncionario() {
        // TODO Auto-generated constructor stub
    }

    public int TempoEmprestimo() {
        return 2;
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
        return u.getNumEmprestimos() < 3;
    }
    
    public boolean aluguelPermitidoReserva(Usuario u, Livro l) {
    	if(l.numReservMaiornNumExem()) {    		
    		if(l.temReserva(u)) {
    			l.removeReserva(u);
    			u.removeReserva(l);
    			return true;
    		}else {
    			return false;
    		}
    	}else {
    		return true;
    	}
    }
}
