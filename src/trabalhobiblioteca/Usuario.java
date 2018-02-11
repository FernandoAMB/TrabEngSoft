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
	private String id, nome;
	private ComportamentoAluguel comportamentoAluguel;
	private ArrayList<Exemplar> arrExemplaresEmprestados = new ArrayList<>();
	private ArrayList<Date> arrDateDevolucao = new ArrayList<>();
	private boolean suspenso = false;

	public Usuario(String id, String nome, ComportamentoAluguel comportamentoAluguel) {
		this.id = id;
		this.nome = nome;
		this.comportamentoAluguel = comportamentoAluguel;
	}
	
	public void alugaLivro(Exemplar exemplar) {
		//acrescentar se o usu�rio ja tem o limite de livro na m�o
		if(!suspenso) {
			if(exemplar.estaDisponivel()) {	
				arrExemplaresEmprestados.add(exemplar);
				int i = arrExemplaresEmprestados.indexOf(exemplar);
//				arrDateDevolucao.add(i, CalcDataDevolucao());
			}
		}else {
			System.out.println("O usu�rio n�o pode fazer emprestimo, pois est� suspenso");
		}
	}
			
	public void Devolver(Exemplar exemplar) {
		int i = arrExemplaresEmprestados.indexOf(exemplar);
		arrExemplaresEmprestados.remove(exemplar);
		arrDateDevolucao.remove(i);
                exemplar.devolver();
                
//		exemplar.disponivel = true;
	}
        
        public String getId() {
            return this.id;
        }
        
        public boolean equals(Usuario u) {
            return this.id.equals(u.getId());
        }
        
        public boolean identify (String id) {
            return this.id.equals(id);
        }

}
