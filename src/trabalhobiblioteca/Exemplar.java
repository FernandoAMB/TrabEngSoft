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
    private boolean disponivel;
    private boolean reservado;

    public Exemplar(Livro livro, String id) {
        this.livro = livro;
        this.id = id;
        this.disponivel = true;
        this.reservado = false;
    }
    
    public boolean isReserved() {
        return reservado;
    }
    
    public boolean reserve() {
        if (!isReserved()) {
            this.reservado = true;
            return true;
        }
        return false;
    }
    
    
    
    
    
    
}
