package br.com.fiap.main;

import br.com.fiap.api.Zumbi;
import br.com.fiap.services.ZumbiService;

import javax.swing.*;
import java.io.IOException;

public class TesteZumbi {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws IOException {

        ZumbiService zumbiService = new ZumbiService();

        String nome = texto("Nome do zumbi (em inglês). Ex.: basic zombie");

        Zumbi zumbi = zumbiService.getZumbi(nome);

        if (zumbi != null) {
            System.out.println(zumbi);
        } else {
            System.out.println("Zumbi não encontrado");
        }
    }
}
