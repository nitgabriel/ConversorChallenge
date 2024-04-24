package br.com.alura;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public Conversao converte(String moedaPConverter) {
        String apikey = "aa69d461095c154db16a417b";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + moedaPConverter);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversao.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a cotação da moeda.");
        }
    }

    public double calcularConversao(String moedaConvertida, Conversao c, double valor) {
        return c.valoresMoedas().get(moedaConvertida) * valor;
    }
}
