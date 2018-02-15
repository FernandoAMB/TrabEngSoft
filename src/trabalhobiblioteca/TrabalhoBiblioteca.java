/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhobiblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 *
 * @author ferna
 */
public class TrabalhoBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Command> comandos = new HashMap<>();
        String entrada = null;
        comandos.put("emp", new CmdEmprestimo());
        comandos.put("dev", new CmdDevolucao());
        comandos.put("liv", new CmdStatusLivro());
        comandos.put("ntf", new CmdGetNotificacoes());
        comandos.put("res", new CmdReserva());
        comandos.put("obs", new CmdSetObserver());
        comandos.put("usu", new CmdStatusUsuario());
        comandos.put("sai", new TerminaOperacao());
        
        while (true) {
            try {
                entrada = b.readLine();
            }
            catch (IOException e) {
                System.err.println("IOException!");
                entrada = "sai";
            }
            finally {
                String[] argumentos = entrada.split(" ");
                comandos.get(argumentos[0]).execute(argumentos);
            }
            
        }
    }

}
