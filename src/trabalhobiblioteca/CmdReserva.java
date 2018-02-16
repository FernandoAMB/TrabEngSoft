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
public class CmdReserva implements Command{
    private final SistemaBiblioteca sys;
    private final String cmd = "res";

    public CmdReserva() {
        sys = SistemaBiblioteca.getInstancia();
    }

    @Override
    public void execute(String[] args) {
        if (args[0].equals(cmd)) { //isso deve ser sempre verdade
            try {
                sys.reservaLivro(args[1], args[2]);
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
