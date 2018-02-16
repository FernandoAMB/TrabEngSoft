package trabalhobiblioteca;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {

    public Calendar devolucaoData, dataEmprestimo;
    private boolean devolvido = false;
    private Usuario usuario;
    private Exemplar exemplar;

    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = Calendar.getInstance();
        exemplar.emprestou();
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo.getTime();
    }

    public Date getDataDevolucao() {
        return devolucaoData.getTime();
    }

    public void SetDataDevolucao(int tempoEmprestimo) {
        devolucaoData = Calendar.getInstance();		//pega a data atual do dia
        devolucaoData.add(Calendar.DATE, tempoEmprestimo);
    }

    public boolean estaAtrasado() {
        Calendar c = Calendar.getInstance();
        return !this.devolvido && (c.after(devolucaoData));
    }

    public void devolver() {
        this.devolvido = true;
        exemplar.devolveu();
        System.out.println("O usuario " + usuario.getNome() + " devolveu o livro " + exemplar.getTitulo());
    }

    public boolean referToLivro(Livro l) {
        return exemplar.referToLivro(l);
    }

    public boolean identify(Exemplar e) {
        return this.exemplar.equals(e);
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public Usuario getUserEmprestimo() {
        return usuario;
    }

    public String getInfo() {
        return "\tPara : " + getUserEmprestimo().getNome() + '\n' + "\tData do emprestimo : " + getDataEmprestimo() + '\n' + "\tData de devolucao : " + getDataDevolucao() + '\n';
    }
}
