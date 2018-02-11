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
//	private static Exemplar instancia;
    public EstadoExemplar meuEstado;
    
    public Exemplar(Livro livro, String id) {
    	this.livro = livro;
        this.id = id;
        new Exemplar(Disponivel.getInstancia());
    }
    
    private Exemplar(EstadoExemplar estadoInit) {
    	this.meuEstado = estadoInit;
    }
    
//    public static Exemplar getInstancia() {
//    	if(instancia == null) {
//    		instancia = new Exemplar(Disponivel.getInstancia());
//    	}
//    	return instancia;
//    }
    
    public void setEstado(EstadoExemplar novoEstado)
    {
 	   meuEstado = novoEstado;
    }
    
//    public boolean isReserved() {
//        return reservado;
//    }
    
    public void devolveu() {
    	meuEstado.devolveu(this);
    }
    
    public void emprestou() {
    	meuEstado.emprestou(this);
    }
    
    public void reservou() {
    	meuEstado.reservou(this);
    }
    
//    public boolean reserve() {
//        if (!isReserved()) {
//            this.reservado = true;
//            return true;
//        }
//        return false;
//    }
}
