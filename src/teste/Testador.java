package teste;

import estrutura.Vetor;
import algoritmos.Ordenacao;
import util.Cronometro;

import java.util.Random;

public class Testador {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000};

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Testando tamanho: " + tamanho + " ---");

            int[] dadosOrdenados = gerarDados(tamanho, "ordenado");
            int[] dadosReversos = gerarDados(tamanho, "reverso");
            int[] dadosAleatorios = gerarDados(tamanho, "aleatorio");

            testarVetor(dadosOrdenados, tamanho, "Ordenado");
            testarVetor(dadosReversos, tamanho, "Reverso");
            testarVetor(dadosAleatorios, tamanho, "Aleatório");
        }
    }

    private static int[] gerarDados(int tamanho, String ordem) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i + 1;
        }
        if (ordem.equals("reverso")) {
            for (int i = 0; i < tamanho / 2; i++) {
                int temp = dados[i];
                dados[i] = dados[tamanho - 1 - i];
                dados[tamanho - 1 - i] = temp;
            }
        } else if (ordem.equals("aleatorio")) {
            Random random = new Random();
            for (int i = 0; i < tamanho; i++) {
                int j = random.nextInt(tamanho);
                int temp = dados[i];
                dados[i] = dados[j];
                dados[j] = temp;
            }
        }
        return dados;
    }

    private static void testarVetor(int[] dados, int tamanho, String ordem) {
        Vetor vetor = new Vetor(tamanho);
    
        // Inserção
        double tempoInsercao = calcularMedia(() -> {
            for (int valor : dados) {
                vetor.inserir(valor);
            }
        });
        System.out.println(String.format("Tempo médio de inserção no vetor (%s): %.2f ms", ordem, tempoInsercao));
    
        // Ordenação
        double tempoBubbleSort = calcularMedia(() -> {
            int[] copia = vetor.getDados();
            Ordenacao.bubbleSort(copia);
        });
        System.out.println(String.format("Tempo médio de Bubble Sort: %.2f ms", tempoBubbleSort));
    
        double tempoQuickSort = calcularMedia(() -> {
            int[] copia = vetor.getDados();
            Ordenacao.quickSort(copia, 0, copia.length - 1);
        });
        System.out.println(String.format("Tempo médio de QuickSort: %.2f ms", tempoQuickSort));
    
        // Busca Sequencial
        int primeiroElemento = dados[0];
        int ultimoElemento = dados[dados.length - 1];
        int elementoMeio = dados[dados.length / 2];
        int valorInexistente = -1;
    
        double tempoBuscaSequencial = calcularMedia(() -> {
            vetor.buscaSequencial(primeiroElemento);
            vetor.buscaSequencial(ultimoElemento);
            vetor.buscaSequencial(elementoMeio);
            vetor.buscaSequencial(valorInexistente);
        });
        System.out.println(String.format("Tempo médio de busca sequencial: %.2f ms", tempoBuscaSequencial));
    
        // Busca Binária
        double tempoBuscaBinaria = calcularMedia(() -> {
            int[] dadosOrdenados = vetor.getDados();
            Ordenacao.quickSort(dadosOrdenados, 0, dadosOrdenados.length - 1);
            vetor.buscaBinaria(primeiroElemento);
            vetor.buscaBinaria(ultimoElemento);
            vetor.buscaBinaria(elementoMeio);
            vetor.buscaBinaria(valorInexistente);
        });
        System.out.println(String.format("Tempo médio de busca binária: %.2f ms", tempoBuscaBinaria));
    }

    private static double calcularMedia(Runnable teste) {
        int repeticoes = 5;
        Cronometro cronometro = new Cronometro();
        double soma = 0;
    
        for (int i = 0; i < repeticoes; i++) {
            cronometro.iniciar();
            teste.run();
            cronometro.parar();
            soma += cronometro.getDuracaoMilissegundos();
        }
    
        return soma / repeticoes;
    }
}
