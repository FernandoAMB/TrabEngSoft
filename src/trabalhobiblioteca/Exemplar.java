/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

/**
 *
 * @author ferna
 */
public class Exemplar {

    private Livro livro;
    private String id;
    private EstadoExemplar estado;
    private Emprestimo emprestimo;

    public Exemplar(Livro livro, String id) {
        this.livro = livro;
        this.id = id;
        this.estado = Disponivel.getInstancia();
        this.emprestimo = null;
    }

    public Emprestimo getEmprestimo() {
        return this.emprestimo;
    }

    public void setEmprestimo(Emprestimo e) {
        this.emprestimo = e;
    }

    public String getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public EstadoExemplar getEstado() {
        return estado;
    }

    public void setEstado(EstadoExemplar novoEstado) {
        estado = novoEstado;
    }

    public boolean referToLivro(Livro l) {
        return livro.equals(l);
    }

    public String getTitulo() {
        return livro.getTitulo();
    }

    public boolean estaDisponivel() {
        return this.estado.getClass().equals(Disponivel.class);
    }

    public void devolveu() {
        estado.devolveu(this);
    }

    public void emprestou() {
        estado.emprestou(this);
    }

    public void printInfo() {
        System.out.println("	Codigo :"+ getId());
        	System.out.println("	Estado : "+ getEstado().toString());
        	if(getEstado().equals(Emprestado.getInstancia())) {
                    System.out.println(getEmprestimo().getInfo());
                }
    }

}
