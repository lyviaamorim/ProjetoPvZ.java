package br.com.fiap.main;

import br.com.fiap.services.PlantaService;

import java.io.IOException;

public class TesteListaPlantas {

    public static void main(String[] args) throws IOException {

        PlantaService plantaService = new PlantaService();

        String[] nomes = plantaService.getNomes();

        System.out.println("Total de plantas: " + nomes.length);

        for (String nome : nomes) {
            System.out.println("- " + nome);
        }
    }
}
