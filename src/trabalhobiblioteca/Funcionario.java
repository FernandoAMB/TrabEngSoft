package trabalhobiblioteca;

public class Funcionario extends Usuario{

	public Funcionario(String id, String nome) {
		super(id, nome, new AluguelFuncionario());
	}
}
