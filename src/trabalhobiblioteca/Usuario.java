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
public class Usuario {
	public int id;
	public String nome;
	public ComportamentoAluguel comportamentoAluguel;
	public int tempoSuspenso = 0;
	public ArrayList<Exemplar> arrExemplaresEmprestados = new ArrayList<Exemplar>();
	public ArrayList<Date> arrDateDevolucao = new ArrayList<Date>();
	
	public Usuario(int id, String nome, ComportamentoAluguel comportamentoAluguel) {
		this.id = id;
		this.nome = nome;
		this.comportamentoAluguel = comportamentoAluguel;
	}
	
	public void Emprestimo(Exemplar exemplar) {
		//acrescentar se o usuário ja tem o limite de livro na mão
		//acrescentar se o livro ta reservado
		if(tempoSuspenso == 0) {
			if(exemplar.disponivel) {
				arrExemplaresEmprestados.add(exemplar);
				int i = arrExemplaresEmprestados.indexOf(exemplar);
				arrDateDevolucao.add(i, CalcDevolucao());
			}else {
				System.out.println("O exemplar não está disponivel");
			}
		}else {
			System.out.println("O usuário não pode fazer emprestimo, pois está suspenso");
		}
	}
	
	public Date CalcDevolucao() {
		Calendar devolucaoData = Calendar.getInstance();
		devolucaoData.add(Calendar.DATE, comportamentoAluguel.TempoEmprestimo());
		return devolucaoData.getTime();
	}
			
	public void Devolver(Exemplar exemplar) {
		int i = arrExemplaresEmprestados.indexOf(exemplar);
		arrExemplaresEmprestados.remove(exemplar);
		arrDateDevolucao.remove(i);
		exemplar.disponivel = true;
	}

}
