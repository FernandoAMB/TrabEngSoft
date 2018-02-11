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
public class Livro implements Subject{
    public String codigo, titulo, editora, autores;
    private int edicao;
    private String dataPublicacao;
    private List<Exemplar> listaExemplares;
    public Reserva reserva;
    
	private ArrayList<ObserverLivro> observers = new ArrayList<ObserverLivro>();

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

	@Override
	public void notifyObservers() {		//ajusatar para se for feita a reserva 2 vezes
		for (int i = 0; i < observers.size(); i++) {
			ObserverLivro observer = observers.get(i);
			observer.update(this);
		}		
	}
    
//    public void reserve() {
//        for (Exemplar e : listaExemplares) {
//            if (e.reserve()) break;
//        }
//    }
    
  
    
}
