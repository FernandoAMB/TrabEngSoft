package trabalhobiblioteca;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	private Calendar devolucaoData;
	private boolean devolvido =  false;
	private Usuario usuario;
	
	public Emprestimo(Usuario usuario){
		this.usuario = usuario;
	}

	public Date CalcDataDevolucao(int tempoEmprestimo) {
		devolucaoData = Calendar.getInstance();		//pega a data atual do dia
		devolucaoData.add(Calendar.DATE, tempoEmprestimo);
		return devolucaoData.getTime();
	}
        
        public void devolver() {
            this.devolvido = true;
        }
}
