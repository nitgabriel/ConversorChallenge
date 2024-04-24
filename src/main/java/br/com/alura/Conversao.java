package br.com.alura;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record Conversao(
        @SerializedName("base_code")
        String moedaPConverter,
        @SerializedName("conversion_rates")
        Map<String, Double> valoresMoedas
) {
}
