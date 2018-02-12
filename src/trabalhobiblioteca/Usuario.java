/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author ferna
 */
public abstract class Usuario {

    private String id, nome;
    private ComportamentoAluguel comportamentoAluguel;
    private ArrayList<Emprestimo> emprestimos, histEmprestimos;
    private boolean suspenso = false;

    public Usuario(String id, String nome, ComportamentoAluguel comportamentoAluguel) {
        this.id = id;
        this.nome = nome;
        this.comportamentoAluguel = comportamentoAluguel;
        this.emprestimos = new ArrayList<>();
        this.histEmprestimos = new ArrayList<>();
    }

    public void alugaLivro(Exemplar exemplar) {
        suspenso = comportamentoAluguel.aluguelPermitido(this);
        if (!suspenso) {
            if (exemplar.estaDisponivel()) {
                Emprestimo e = new Emprestimo(this, exemplar);
                e.SetDataDevolucao(this.getTempoEmprestimo());
                emprestimos.add(e);
            }
        } else {
            System.out.println("O usu�rio n�o pode fazer emprestimo, pois est� suspenso");
        }
    }

    public int getTempoEmprestimo() {
        return comportamentoAluguel.TempoEmprestimo();
    }
    public void Devolver(Exemplar exemplar) {
        for (Emprestimo e : emprestimos) {
            if (e.identify(exemplar)) {
                e.devolver();
                histEmprestimos.add(e);
                break;
            }
        }              
    }

    public String getId() {
        return this.id;
    }

    public boolean equals(Usuario u) {
        return this.id.equals(u.getId());
    }

    public boolean identify(String id) {
        return this.id.equals(id);
    }
    
    public int getNumEmprestimos() {
        return emprestimos.size();
    }

}
