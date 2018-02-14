package trabalhobiblioteca;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	private Calendar devolucaoData, dataEmprestimo;
	private boolean devolvido =  false;
	private Usuario usuario;
        private Exemplar exemplar;
	
	public Emprestimo(Usuario usuario, Exemplar exemplar){
		this.usuario = usuario;
                this.exemplar = exemplar;
                this.dataEmprestimo = Calendar.getInstance();
                exemplar.emprestou();
	}

	public void SetDataDevolucao(int tempoEmprestimo) {
		devolucaoData = Calendar.getInstance();		//pega a data atual do dia
		devolucaoData.add(Calendar.DATE, tempoEmprestimo);
	}
        
        public boolean estaAtrasado() {
            Calendar c = Calendar.getInstance();
            return !this.devolvido || (c.after(devolucaoData));
        }
        
        public void devolver() {
            this.devolvido = true;
            exemplar.devolver();
        }
        
        public boolean referToLivro(Livro l) {
            return exemplar.referToLivro(l);
        }
        
        public boolean identify(Exemplar e) {
            return this.exemplar.equals(e);
        }
}
