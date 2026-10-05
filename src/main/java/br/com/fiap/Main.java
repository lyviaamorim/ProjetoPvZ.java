package br.com.fiap;

import br.com.fiap.api.Planta;
import br.com.fiap.api.Zumbi;
import br.com.fiap.services.PlantaService;
import br.com.fiap.services.ZumbiService;

import javax.swing.*;
import java.io.IOException;

public class Main {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws IOException {

        PlantaService plantaService = new PlantaService();
        ZumbiService zumbiService = new ZumbiService();

        String opcao;

        do {
            opcao = texto("""
                    PLANTS VS ZOMBIES
                    1 - Buscar planta por nome
                    2 - Listar nomes das plantas
                    3 - Buscar zumbi por nome
                    4 - Listar nomes dos zumbis
                    0 - Sair""");

            if (opcao == null) {
                break; // clicou em Cancelar
            }

            switch (opcao) {
                case "1" -> {
                    String nome = texto("Nome da planta (em inglês)");
                    Planta planta = plantaService.getPlanta(nome);
                    System.out.println(planta != null ? planta : "Planta não encontrada");
                }
                case "2" -> {
                    for (String nome : plantaService.getNomes()) {
                        System.out.println("- " + nome);
                    }
                }
                case "3" -> {
                    String nome = texto("Nome do zumbi (em inglês)");
                    Zumbi zumbi = zumbiService.getZumbi(nome);
                    System.out.println(zumbi != null ? zumbi : "Zumbi não encontrado");
                }
                case "4" -> {
                    for (String nome : zumbiService.getNomes()) {
                        System.out.println("- " + nome);
                    }
                }
                case "0" -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida");
            }
        } while (!opcao.equals("0"));
    }
}
