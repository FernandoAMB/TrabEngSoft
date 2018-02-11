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

    public Exemplar(Livro livro, String id) {
        this.livro = livro;
        this.id = id;
        this.estado = Disponivel.getInstancia();
    }

    private Exemplar(EstadoExemplar estadoInit) {
        this.estado = estadoInit;
    }

//    public static Exemplar getInstancia() {
//    	if(instancia == null) {
//    		instancia = new Exemplar(Disponivel.getInstancia());
//    	}
//    	return instancia;
//    }
    public void setEstado(EstadoExemplar novoEstado) {
        estado = novoEstado;
    }

//    public boolean isReserved() {
//        return reservado;
//    }
    public boolean estaDisponivel() {
        return this.estado.getClass().equals(Disponivel.class);
    }

    public void devolveu() {
        estado.devolveu(this);
    }

    public void emprestou() {
        estado.emprestou(this);
    }

    public void devolver() {

    }

//    public boolean reserve() {
//        if (!isReserved()) {
//            this.reservado = true;
//            return true;
//        }
//        return false;
//    }
}
