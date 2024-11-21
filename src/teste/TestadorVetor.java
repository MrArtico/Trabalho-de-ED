package teste;

import estrutura.Vetor;
import algoritmos.Ordenacao;
import util.Cronometro;

import java.util.Random;

public class TestadorVetor {
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

            System.out.println("\n--- Finalizando bloco... ---\n");
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
    
        double tempoInsercao = calcularMedia(() -> {
            for (int valor : dados) {
                vetor.inserir(valor);
            }
        });
        System.out.println(String.format("Tempo médio de inserção no vetor (%s): %f ms", ordem, tempoInsercao));
    
        double tempoBubbleSort = calcularMedia(() -> {
            int[] copia = vetor.getDados();
            Ordenacao.bubbleSort(copia);
        });
        System.out.println(String.format("Tempo médio de Bubble Sort: %f ms", tempoBubbleSort));
    
        double tempoQuickSort = calcularMedia(() -> {
            int[] copia = vetor.getDados();
            Ordenacao.quickSort(copia, 0, copia.length - 1);
        });
        System.out.println(String.format("Tempo médio de QuickSort: %f ms", tempoQuickSort));
    
        int primeiroElemento = dados[0];
        int ultimoElemento = dados[dados.length - 1];
        int elementoMeio = dados[dados.length / 2];
        int valorInexistente = -1;
        Random random = new Random();
        int aleatorio1 = dados[random.nextInt(tamanho)];

        double tempoBuscaSequencial = calcularMedia(() -> {
            vetor.buscaSequencial(primeiroElemento);
        });
        System.out.println(String.format("(Primeiro Elemento): tempo médio de busca sequencial: %f ms", tempoBuscaSequencial));
        double tempoBuscaSequencial2 = calcularMedia(() -> {
            vetor.buscaSequencial(ultimoElemento);
        });
        System.out.println(String.format("(Ultimo Elemento): tempo médio de busca sequencial: %f ms", tempoBuscaSequencial2));
        double tempoBuscaSequencial3 = calcularMedia(() -> {
            vetor.buscaSequencial(elementoMeio);
        });
        System.out.println(String.format("(Elemento do Meio): tempo médio de busca sequencial: %f ms", tempoBuscaSequencial3));
        double tempoBuscaSequencial4 = calcularMedia(() -> {
            vetor.buscaSequencial(valorInexistente);
        });
        System.out.println(String.format("(Valor Inexistente): tempo médio de busca sequencial: %f ms\n\n", tempoBuscaSequencial4));
        
        int[] dadosOrdenados = vetor.getDados();
        Ordenacao.quickSort(dadosOrdenados, 0, dadosOrdenados.length - 1);

        double tempoBuscaBinaria = calcularMedia(() -> {
            vetor.buscaBinaria(primeiroElemento);
        });
        System.out.println(String.format("(Primeiro elemento): tempo médio de busca binária: %f ms", tempoBuscaBinaria));
        double tempoBuscaBinaria2 = calcularMedia(() -> {
            vetor.buscaBinaria(ultimoElemento);
        });
        System.out.println(String.format("(Ultimo Elemento): tempo médio de busca binária: %f ms", tempoBuscaBinaria2));
        double tempoBuscaBinaria3 = calcularMedia(() -> {
            vetor.buscaBinaria(elementoMeio);
        });
        System.out.println(String.format("(Elemento do Meio): tempo médio de busca binária: %f ms", tempoBuscaBinaria3));
        double tempoBuscaBinaria4 = calcularMedia(() -> {
            vetor.buscaBinaria(valorInexistente);
        });
        System.out.println(String.format("(Valor Inexistente): tempo médio de busca binária: %f ms", tempoBuscaBinaria4));
        
        double tempoBuscaSequencialAleatoria = calcularMedia(() -> {
            vetor.buscaSequencial(aleatorio1);
        });
        System.out.println(String.format("(Elemento Aleatorio): tempo médio de busca binária: %f ms\n\n", tempoBuscaSequencialAleatoria));
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
