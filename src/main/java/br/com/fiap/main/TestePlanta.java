package br.com.fiap.main;

import br.com.fiap.api.Planta;
import br.com.fiap.services.PlantaService;

import javax.swing.*;
import java.io.IOException;

public class TestePlanta {

    // String
    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws IOException {

        PlantaService plantaService = new PlantaService();

        String nome = texto("Nome da planta (em inglês). Ex.: sunflower, aloe");

        Planta planta = plantaService.getPlanta(nome);

        if (planta != null) {
            System.out.println(planta);
        } else {
            System.out.println("Planta não encontrada");
        }
    }
}


