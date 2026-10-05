package br.com.fiap.services;

import br.com.fiap.api.Zumbi;
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

public class ZumbiService {

    private static final String URL_BASE = "https://pvz-2-api.vercel.app/api/zombies";

    // Busca UM zumbi pelo nome (ex.: "basic zombie")
    public Zumbi getZumbi(String nome) throws IOException {

        Zumbi zumbi = null;

        if (nome == null || nome.isBlank()) {
            return null;
        }

        String nomeUrl = URLEncoder
                .encode(nome.trim().toLowerCase(), StandardCharsets.UTF_8)
                .replace("+", "%20");

        HttpGet request = new HttpGet(URL_BASE + "/" + nomeUrl);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if (response.getStatusLine().getStatusCode() == 200) {

                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    String result = EntityUtils.toString(entity);

                    Gson gson = new Gson();
                    zumbi = gson.fromJson(result, Zumbi.class);
                }
            }
        }
        return zumbi;
    }

    // Busca a LISTA com o nome de todos os zumbis
    public String[] getNomes() throws IOException {

        String[] nomes = null;

        HttpGet request = new HttpGet(URL_BASE);

        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .disableRedirectHandling().build();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                nomes = new Gson().fromJson(result, String[].class);
            }
        }
        return nomes;
    }
}