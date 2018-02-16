package trabalhobiblioteca;

public class Professor extends Usuario implements ObserverLivro {

    private int updateCount = 0;
    
    public Professor(String id, String nome) {
        super(id, nome, new AluguelProfessor());
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Livro livro) {
        updateCount++;
    }
 
    public void ConsultaProfessor(){
        System.out.println("Quantidade de vezes que foi notificado: "+ updateCount);
    }
}
