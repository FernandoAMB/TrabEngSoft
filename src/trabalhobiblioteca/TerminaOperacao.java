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
public class TerminaOperacao implements Command {
    private final SistemaBiblioteca sys;
    private final String cmd = "sai";

    public TerminaOperacao() {
        sys = SistemaBiblioteca.getInstancia();
    }

    @Override
    public void execute(String[] args) {
        if (args[0].equals(cmd)) {
            System.out.println("Saindo...");
            System.exit(0);
        }
        System.err.print("Comando " + args[0] + "errado! Tentou executar comando " + cmd); //isso nao deve acontecer nunca
    }
}
