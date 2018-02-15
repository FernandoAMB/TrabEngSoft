package trabalhobiblioteca;

public class Aluno extends Usuario{

	public Aluno(String id, String nome) {
		super(id, nome, new AluguelAluno());
	}

}
