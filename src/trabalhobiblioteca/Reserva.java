package trabalhobiblioteca;

public class Reserva {

    Livro livro;
    Usuario user;

    public Reserva(Usuario user, Livro livro) {
        this.livro = livro;
        this.user = user;
        livro.reserve(this);
    }

}
