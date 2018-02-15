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
public class CmdDevolucao implements Command {
    private final SistemaBiblioteca sys;
    private final String cmd = "dev";
    
    public CmdDevolucao() {
        sys = SistemaBiblioteca.getInstancia();
    }
    
    @Override
    public void execute(String[] args) {
        if (args[0].equals(cmd)) {
            sys.devolveLivro(args[1], args[2]);
            return;
        }
        System.err.print("Comando " + args[0] + "errado! Tentou executar comando " + cmd); //isso nao deve acontecer nunca
    }
    
}
