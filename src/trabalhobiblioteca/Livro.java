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

    public void ConsultaLivro() {
        System.out.println("Titulo do livro :" + getTitulo());
        System.out.println("Quantidade de reservas :" + reservas.size());
        if (!reservas.isEmpty()) {
            System.out.println("Usuarios que realizaram as reservas: ");
            for (Reserva r : reservas) {
                System.out.println(r.getInfo());
            }
        }
        System.out.println("Exemplares:");
        for (Exemplar e : listaExemplares) {
            e.printInfo();
        }
    }

    public void addExemplar(Exemplar ex) {
        this.listaExemplares.add(ex);
    }

    public void reserve(Reserva r) {
        reservas.add(r);
        if (reservas.size() > 1) {
            notifyObservers();
        }
    }

    public boolean numReservMaiornNumExem() {
        return reservas.size() >= listaExemplares.size();
    }

    public boolean temReserva(Usuario u) {
        for (Reserva r : reservas) {
            if (r.getUser() == u && r.getLivro() == this) {
                return true;
            }
        }
        return false;
    }

    public void empresta() {
        Exemplar e = getExemplarDisponivel();
        if (e != null) {
            e.emprestou();
        } else {
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

    public void removeReserva(Usuario u) {
        for (Reserva r : reservas) {
            if (r.getUser().equals(u) && r.getLivro().equals(this)) {
                reservas.remove(r);
                break;
            }
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
