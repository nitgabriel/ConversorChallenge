package br.com.alura;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public double converte(String moedaPConverter, String moedaConvertida, double valor) {
        double valorConvertido = 0.0;
        String apikey = "aa69d461095c154db16a417b";
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apikey + "/latest/" + moedaPConverter);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String[] partes = responseBody.split(",");
            for (String parte : partes) {
                if (parte.contains(moedaConvertida)) {
                    String[] valorConvertidoString = parte.split(":");
                    valorConvertido = Double.parseDouble(valorConvertidoString[1]);
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Não consegui obter a cotação da moeda.");
        }


        return valorConvertido;
    }
}
