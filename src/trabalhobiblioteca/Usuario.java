/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ferna
 */
public abstract class Usuario {

    private String id, nome;
    private ComportamentoAluguel comportamentoAluguel;
    private ArrayList<Emprestimo> emprestimos, histEmprestimos;
    private boolean suspenso = false;
    private boolean exemplarIgual = false;
    private boolean maxExemplar = false;
    private boolean EmprestimoReserva = false;
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
        suspenso = !comportamentoAluguel.aluguelPermitidoSusp(this, l);
        exemplarIgual = comportamentoAluguel.aluguelPermitidoIgual(this, l);
        maxExemplar = comportamentoAluguel.aluguelPermitidoMax(this);
        EmprestimoReserva = comportamentoAluguel.aluguelPermitidoReserva(this, l);
        if (EmprestimoReserva) {
            if (maxExemplar) {
                if (exemplarIgual) {
                    if (suspenso) {
                        System.out.println("Emprestimo do livro " + l.getTitulo() + " nao efetivado para " + this.nome + ". O usuario esta suspenso");
                    } else {
                        Exemplar e = l.getExemplarDisponivel();
                        if (e == null) {
                            System.out.println("Nao ha exemplares disponiveis do livro " + l.getTitulo());
                        }
                        if (e.estaDisponivel()) {
                            l.removeReserva(this);
                            this.removeReserva(l);
                            Emprestimo emp = new Emprestimo(this, e);
                            emp.SetDataDevolucao(this.getTempoEmprestimo());
                            emprestimos.add(emp);
                            e.setEmprestimo(emp);
                            System.out.println("Emprestimo do exemplar " + e.getId() + " do livro " + l.getTitulo() + " efetivado para " + this.nome);
                        } else {
                            System.out.println("Emprestimo nao efetivado para " + this.nome + ". O exemplar " + l.getTitulo() + " nao esta disponivel");
                        }
                    }
                } else {
                    System.out.println("Emprestimo do livro " + l.getTitulo() + " nao efetivado para " + this.nome + ". O usuario ja tem um livro igual emprestado");
                }
            } else {
                System.out.println("Emprestimo do livro " + l.getTitulo() + " nao efetivado para " + this.nome + ". O usuario ja possui a quantidade maxima de livos");
            }
        } else {
            System.out.println("Emprestimo do livro " + l.getTitulo() + " nao efetivado para " + this.nome + ". O livro esta reservado");
        }
    }

    public int getTempoEmprestimo() {
        return comportamentoAluguel.TempoEmprestimo();
    }


    public void Devolver(Livro l) {
        for (Emprestimo e : emprestimos) {
            if (e.referToLivro(l)) {
                e.devolver();
                histEmprestimos.add(e);
                emprestimos.remove(e);
                return;
            }
        }
        System.out.println("O usuario " + this.nome + " nao possui emprestimo em aberto do livro " + l.getTitulo());
    }

    public void removeReserva(Livro livro) {
        for (Reserva r : reservas) {
            if (r.getLivro().equals(livro)) {
                reservas.remove(r);
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public boolean jaAlugou(Livro l) {
        for (Emprestimo e : emprestimos) {
            if (e.referToLivro(l)) {
                return true;
            }
        }
        return false;
    }

    public boolean estaAtrasado() {
        for (Emprestimo e : emprestimos) {
            if (e.estaAtrasado()) {
                return true;
            }
        }
        return false;
    }

    public void reservaLivro(Livro l) {
        if (reservas.size() < 3) {
            Reserva r = new Reserva(this, l);
            Calendar d = Calendar.getInstance();
            r.setDataSolicitacao(d);
            reservas.add(r);
            System.out.println("Reserva do livro " + l.getTitulo() + " foi efetuada para " + this.nome);
        } else {
            System.out.println("O usuario " + this.nome + " ja possui 3 reservas");
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

    public void ConsultaUsuario() {
        System.out.println("Emprestimos Correntes :");
        for (Emprestimo e : emprestimos) {
            System.out.println(e.getExemplar().getLivro().getTitulo());
            System.out.println(e.getDataEmprestimo());
            System.out.println(e.getDataDevolucao());
        }
        System.out.println("Emprestimos Passados :");
        for (Emprestimo e : histEmprestimos) {
            System.out.println(e.getExemplar().getLivro().getTitulo());
            System.out.println(e.getDataEmprestimo());
            System.out.println(e.getDataDevolucao());
        }
        System.out.println("Reservas :");
        for (Reserva r : reservas) {
            System.out.println(r.getLivro().getTitulo());
            System.out.println(r.getDataSolicitacao());
        }

    }

//    public Usuario getUserExempEmprestado(Exemplar exemplar) {
//    	for (Emprestimo e : emprestimos) {
//    		if(e.getExemplar() == exemplar) {
//    	    	return this;
//    		}
//    	}
//    	return null;
//    }
}
