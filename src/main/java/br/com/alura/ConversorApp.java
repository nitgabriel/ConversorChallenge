package br.com.alura;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String moedaPConverter = "";
        String moedaConvertida = "";
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("""
                            ****************************************************************
                            Seja bem-vindo/a ao Conversor de Moedas =]
                            
                            1) Dólar =>> Peso argentino
                            2) Peso argentino =>> Dólar
                            3) Dólar =>> Real brasileiro
                            4) Real brasileiro =>> Dólar
                            5) Dólar =>> Peso colombiano
                            6) Peso colombiano =>> Dólar
                            7) Sair
                            Escolha uma opção válida:
                            ****************************************************************
                            """
            );
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    moedaPConverter = "USD";
                    moedaConvertida = "ARS";
                    break;
                case 2:
                    moedaPConverter = "ARS";
                    moedaConvertida = "USD";
                    break;
                case 3:
                    moedaPConverter = "USD";
                    moedaConvertida = "BRL";
                    break;
                case 4:
                    moedaPConverter = "BRL";
                    moedaConvertida = "USD";
                    break;
                case 5:
                    moedaPConverter = "USD";
                    moedaConvertida = "COP";
                    break;
                case 6:
                    moedaPConverter = "COP";
                    moedaConvertida = "USD";
                    break;
                case 7:
                    System.out.println("Até mais! =]");
                    continue;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }
            System.out.println("Digite o valor a ser convertido:");
            double valor = entrada.nextDouble();
            Conversor conversor = new Conversor();
            Conversao conversao = conversor.converte(moedaPConverter);
            double valorConvertido = conversor.calcularConversao(moedaConvertida, conversao, valor);
            System.out.println("O valor " + valor + " [" + moedaPConverter + "] corresponde ao valor final de =>>> " + valorConvertido + " [" + moedaConvertida + "]" );
        }
    }
}
