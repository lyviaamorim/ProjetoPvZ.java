package br.com.fiap.main;

import br.com.fiap.services.ZumbiService;

import java.io.IOException;

public class TesteListaZumbis {

    public static void main(String[] args) throws IOException {

        ZumbiService zumbiService = new ZumbiService();

        String[] nomes = zumbiService.getNomes();

        System.out.println("Total de zumbis: " + nomes.length);

        for (String nome : nomes) {
            System.out.println("- " + nome);
        }
    }
}
