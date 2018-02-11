package trabalhobiblioteca;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	public Calendar devolucaoData;
	private boolean devolvido =  false;
	public Usuario usuario;
	
	public Emprestimo(Usuario usuario){
		this.usuario = usuario;
	}

	public Date CalcDataDevolucao() {
		devolucaoData = Calendar.getInstance();		//pega a data atual do dia
		devolucaoData.add(Calendar.DATE, usuario.comportamentoAluguel.TempoEmprestimo());
		return devolucaoData.getTime();
	}
}
