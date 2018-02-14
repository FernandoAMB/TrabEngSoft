/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferna
 */
public class SistemaBiblioteca {

    private static SistemaBiblioteca instancia;
    private List<Usuario> listaUsuarios;
    private List<Livro> listaLivros;

    private SistemaBiblioteca() {
        this.listaLivros = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
    }

    public SistemaBiblioteca getInstancia() {
        if (SistemaBiblioteca.instancia == null) {
            instancia = new SistemaBiblioteca();
        }
        return instancia;
    }

    public Usuario getUsuario(String id) {
        for (Usuario u : listaUsuarios) {
            if (u.identify(id)) {
                return u;
            }
        }
        return null;
    }

    public Livro getLivro(String codigo) {
        for (Livro l : listaLivros) {
            if (l.identify(codigo)) {
                return l;
            }
        }
        return null;
    }
    
    public void alugaLivro(String userId, String codigo) {
        Livro l = getLivro(codigo);
        Usuario u = getUsuario(userId);
        u.alugaLivro(l);
    }

    public void reservaLivro(String userId, String codigo) {
        Livro l = getLivro(codigo);
        Usuario u = getUsuario(userId);
        u.reservaLivro(l);
        
    }
    

}
