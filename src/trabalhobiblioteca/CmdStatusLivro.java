/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

/**
 *
 * @author ferna
 */
public class CmdStatusLivro implements Command{

    private final SistemaBiblioteca sys;
    private final String cmd = "liv";

    public CmdStatusLivro() {
        sys = SistemaBiblioteca.getInstancia();
    }

    @Override
    public void execute(String[] args) {
        if (args[0].equals(cmd)) {
            sys.ConsultaLivro(args[1]);
            return;
        }
        System.err.print("Comando " + args[0] + "errado! Tentou executar comando " + cmd); //isso nao deve acontecer nunca
    }

}
