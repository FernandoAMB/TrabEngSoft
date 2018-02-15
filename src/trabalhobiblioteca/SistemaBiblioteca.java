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
        setup();
    }

    public static SistemaBiblioteca getInstancia() {
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
    
    public void devolveLivro(String userId, String codigo) {
        Livro l = getLivro(codigo);
        Usuario u = getUsuario(userId);
        u.Devolver(l);
    }

    public void reservaLivro(String userId, String codigo) {
        Livro l = getLivro(codigo);
        Usuario u = getUsuario(userId);
        u.reservaLivro(l);
    }
    
    public void ConsultaLivro(String codigo) {
    	Livro l = getLivro(codigo);
    	l.ConsultaLivro();
    }
    public void setObserver(String userId, String codigo) {
        Usuario u = getUsuario(userId);
        Professor p;
        Livro l = getLivro(codigo);
        if (Professor.class.isAssignableFrom(u.getClass())) {
            p = (Professor) u;
            l.registerObserver(p);
        }
        else {
            System.out.println("Usuario nao e professor e nao pode observar os livros!");
        }
    }
    
    public void ConsultaUsuario(String id) {
    	Usuario u = getUsuario(id);
    	u.ConsultaUsuario();
    }

    public void ConsultaProfessor(String id) {
    	Usuario u = getUsuario(id);
        Professor p;
        if (Professor.class.isAssignableFrom(u.getClass())) {
            p = (Professor) u;
            p.ConsultaProfessor();
        }
        else {
            System.out.println("Usuario nao e professor.");
        }
    	
    }
    
    private void setup() {
        listaUsuarios.add(new Funcionario("123", "João da Silva"));
        listaUsuarios.add(new Aluno("456", "Luiz Fernando Rodrigues"));
        listaUsuarios.add(new Funcionario("789", "Pedro Paulo"));
        listaUsuarios.add(new Professor("100", "Carlos Lucena"));
        Livro engSoft, umlGuia, code, agiSoft, ref, softM, desiP, umlDist; //pra nao dar ruim com as insanidades de referencias
        engSoft = new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6a", "2000");
        umlGuia = new Livro("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7a", "2000"); 
        code = new Livro("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2a", "2014");
        agiSoft = new Livro("201", "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", "Robert Martin", "1a", "2002");
        ref = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", "Martin Fowler", "1a", "1999");
        softM = new Livro("301", "Software Metrics: A Rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3a", "2014");
        desiP = new Livro("400", "Design Partterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1a", "1994");
        umlDist = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", "Martin Fowler", "3a","2003");
        
        listaLivros.add(engSoft);
        listaLivros.add(umlGuia);
        listaLivros.add(code);
        listaLivros.add(agiSoft);
        listaLivros.add(ref);
        listaLivros.add(softM);
        listaLivros.add(desiP);
        listaLivros.add(umlDist);
        
        engSoft.addExemplar(new Exemplar(engSoft, "01"));
        engSoft.addExemplar(new Exemplar(engSoft, "02"));
        umlGuia.addExemplar(new Exemplar(umlGuia, "03"));
        code.addExemplar(new Exemplar(code, "04"));
        agiSoft.addExemplar(new Exemplar(agiSoft, "05"));
        ref.addExemplar(new Exemplar(ref, "06"));
        ref.addExemplar(new Exemplar(ref, "07"));
        desiP.addExemplar(new Exemplar(desiP, "08"));
        desiP.addExemplar(new Exemplar(desiP, "09"));
    }
}
