package trabalhobiblioteca;

public class Professor extends Usuario implements ObserverLivro {

    private int updateCount = 0;
    
    public Professor(String id, String nome, ComportamentoAluguel comportamentoAluguel) {
        super(id, nome, comportamentoAluguel);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Livro livro) {
        updateCount++;
        System.out.println("O livro " + livro.getTitulo() + " foi reservado duas vezes");
    }
 
    public void ConsultaProfessor(){
        System.out.println("Quantidade de vezes que foi notificado: "+ updateCount);
    }
}
