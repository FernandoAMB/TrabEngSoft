package trabalhobiblioteca;

public class Emprestado implements EstadoExemplar {
    private static Emprestado instancia;

    private Emprestado() {
    }

    public static Emprestado getInstancia() {
        if (instancia == null) {
            instancia = new Emprestado();
        }
        return instancia;
    }

    @Override
    public void devolveu(Exemplar e) {
        e.setEstado(Disponivel.getInstancia());
        System.out.println("O exemplar esta disponivel");
    }

    @Override
    public void emprestou(Exemplar e) {
        e.setEstado(Emprestado.getInstancia());
        System.out.println("O exemplar esta emprestado");
    }
    
    @Override
    public String toString() {
        return "Emprestado";
    }

}
