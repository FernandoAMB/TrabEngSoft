package trabalhobiblioteca;
import java.util.Calendar;
import java.util.Date;

public class Reserva {

    private Livro livro;
    private Usuario user;
    private Calendar dataSolicitacao;
    
    public Reserva(Usuario user, Livro livro) {
        this.livro = livro;
        this.user = user;
        livro.reserve(this);
    }
    
    public void setDataSolicitacao(Calendar data) {
    	dataSolicitacao = data;
    }
    
    public Date getDataSolicitacao() {
    	return dataSolicitacao.getTime();
    }
    
    public Usuario getUser() {
    	return user;
    }
    
    public Livro getLivro() {
    	return livro;
    }

}
