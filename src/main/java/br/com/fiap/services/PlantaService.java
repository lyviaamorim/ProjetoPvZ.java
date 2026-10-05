package br.com.fiap.services;

import br.com.fiap.api.Planta;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class PlantaService {

    private static final String URL_BASE = "https://pvz-2-api.vercel.app/api/plants";

    // Busca UMA planta pelo nome (ex.: "peashooter", "aloe")
    public Planta getPlanta(String nome) throws IOException {

        Planta planta = null;

        if (nome == null || nome.isBlank()) {
            return null;
        }

        // NOVO: nomes com espaço precisam ser codificados na URL
        // (basic zombie -> basic%20zombie)
        String nomeUrl = URLEncoder
                .encode(nome.trim().toLowerCase(), StandardCharsets.UTF_8)
                .replace("+", "%20");

        // request
        HttpGet request = new HttpGet(URL_BASE + "/" + nomeUrl);

        // client + response (try-with-resources fecha os dois automaticamente)
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // NOVO: só converte se a API respondeu 200 (planta existe)
            if (response.getStatusLine().getStatusCode() == 200) {

                // entity
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String result = EntityUtils.toString(entity);

                    Gson gson = new Gson();
                    planta = gson.fromJson(result, Planta.class);
                }
            }
        }
        return planta;
    }

    // Busca a LISTA com o nome de todas as plantas
    // (a API devolve um array de textos)
    public String[] getNomes() throws IOException {

        String[] nomes = null;

        HttpGet request = new HttpGet(URL_BASE);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);

                // O JSON é um array, então convertemos para String[]
                nomes = new Gson().fromJson(result, String[].class);
            }
        }
        return nomes;
    }
}

