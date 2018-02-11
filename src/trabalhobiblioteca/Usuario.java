/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author ferna
 */
public abstract class Usuario {
	public int id;
	public String nome;
	public ComportamentoAluguel comportamentoAluguel;
	
	
	public ArrayList<Exemplar> arrExemplaresEmprestados = new ArrayList<Exemplar>();
	public ArrayList<Date> arrDateDevolucao = new ArrayList<Date>();
	public boolean suspenso = false;

	public Usuario(int id, String nome, ComportamentoAluguel comportamentoAluguel) {
		this.id = id;
		this.nome = nome;
		this.comportamentoAluguel = comportamentoAluguel;
	}
	
	public void alugaLivro(Exemplar exemplar) {
		//acrescentar se o usuário ja tem o limite de livro na mão
		if(!suspenso) {
			if(exemplar.meuEstado = Disponivel) {		//como chamar a classe disponivel do state aqui?
				arrExemplaresEmprestados.add(exemplar);
				int i = arrExemplaresEmprestados.indexOf(exemplar);
//				arrDateDevolucao.add(i, CalcDataDevolucao());
			}
		}else {
			System.out.println("O usuário não pode fazer emprestimo, pois está suspenso");
		}
	}
			
	public void Devolver(Exemplar exemplar) {
		int i = arrExemplaresEmprestados.indexOf(exemplar);
		arrExemplaresEmprestados.remove(exemplar);
		arrDateDevolucao.remove(i);
//		exemplar.disponivel = true;
	}

}
