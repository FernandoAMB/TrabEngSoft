/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

/**
 *
 * @author ferna
 */
public class Livro implements Subject {

    private String codigo, titulo, editora, autores, edicao, dataPublicacao;
    private List<Exemplar> listaExemplares;
    private List<Reserva> reservas;
    private ArrayList<ObserverLivro> observers = new ArrayList<ObserverLivro>();

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String data) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.dataPublicacao = data;
        this.listaExemplares = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void addExemplar(Exemplar ex) {
        this.listaExemplares.add(ex);
    }
    

    public void reserve(Reserva r) {
        reservas.add(r);
        if (reservas.size() > 1) notifyObservers();
    }

    public void empresta() {
        Exemplar e = getExemplarDisponivel();
        if (e != null) {
            e.emprestou();
        }
        else {
            System.out.println("Nao ha exemplares disponiveis do livro");
        }
    }

    @Override
    public void registerObserver(ObserverLivro obLivro) {
        observers.add(obLivro);
    }

    @Override
    public void removeObserver(ObserverLivro obLivro) {
        int i = observers.indexOf(obLivro);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    

    public Exemplar getExemplarDisponivel() {
        for (Exemplar e : listaExemplares) {
            if (e.estaDisponivel()) {
                return e;
            }
        }
        return null;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            ObserverLivro observer = observers.get(i);
            observer.update(this);
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public boolean identify(String code) {
        return this.codigo.equals(code);
    }
}
