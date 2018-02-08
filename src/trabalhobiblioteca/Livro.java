/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author ferna
 */
public class Livro {
    private String codigo, titulo, editora, autores;
    private int edicao;
    private String dataPublicacao;
    private List<Exemplar> listaExemplares;

    public Livro(String codigo, String titulo, String editora, String autores, int edicao, String data) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.dataPublicacao = data;
        this.listaExemplares = new ArrayList<>();
    }
    
    public void addExemplar(Exemplar ex) {
        this.listaExemplares.add(ex);
    }
    
    public void reserve() {
        for (Exemplar e : listaExemplares) {
            if (e.reserve()) break;
        }
    }

    
    
}
