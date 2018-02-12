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
	}

	public void SetDataDevolucao(int tempoEmprestimo) {
		devolucaoData = Calendar.getInstance();		//pega a data atual do dia
		devolucaoData.add(Calendar.DATE, tempoEmprestimo);
	}
        
        public void devolver() {
            this.devolvido = true;
            exemplar.devolver();
        }
        
        public boolean identify(Exemplar e) {
            return this.exemplar.equals(e);
        }
}
