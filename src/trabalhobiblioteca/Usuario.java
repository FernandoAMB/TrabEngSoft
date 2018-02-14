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
    private ArrayList<Reserva> reservas;

    public Usuario(String id, String nome, ComportamentoAluguel comportamentoAluguel) {
        this.id = id;
        this.nome = nome;
        this.comportamentoAluguel = comportamentoAluguel;
        this.emprestimos = new ArrayList<>();
        this.histEmprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void alugaLivro(Livro l) {
        suspenso = comportamentoAluguel.aluguelPermitido(this, l);
        if (!suspenso) {
            Exemplar e = l.getExemplarDisponivel();
            if (e.estaDisponivel()) {
                Emprestimo emp = new Emprestimo(this, e);
                emp.SetDataDevolucao(this.getTempoEmprestimo());
                emprestimos.add(emp);
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
    
    public boolean jaAlugou(Livro l) {
        for (Emprestimo e : emprestimos) {
            if (e.referToLivro(l)) return true;
        }
        return false;
    }
    
    public boolean estaAtrasado() {
        for (Emprestimo e : emprestimos) {
            if (e.estaAtrasado()) return true;
        }
        return false;
    }
    
    public void reservaLivro(Livro l) {
        if (reservas.size() < 3) {
            Reserva r = new Reserva(this, l);
            reservas.add(r);
            System.out.println("Reserva realizada com sucesso!"); 
        }
        else System.out.println("Usuario ja possui 3 reservas");
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
