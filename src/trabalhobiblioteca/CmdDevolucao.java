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
            try {
                sys.devolveLivro(args[1], args[2]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Por favor, insira o numero correto de entradas, separadas por espaco.");
            }
            finally {
                return;
            }
        }
        System.err.print("Comando " + args[0] + "errado! Tentou executar comando " + cmd); //isso nao deve acontecer nunca
    }
    
}
