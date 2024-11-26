package teste;

import java.util.Random;

import estrutura.ArvoreAVL;

public class TestadorArvoreAVL {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000};

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Testando Árvores AVL com " + tamanho + " elementos ---");

            int[] dadosOrdenados = gerarDados(tamanho, "ordenado");
            int[] dadosAleatorios = gerarDados(tamanho, "aleatorio");
            int[] dadosInvertidos = gerarDados(tamanho, "invertido");

            System.out.println(">> Ordem Ordenada:");
            testarArvoreAVL(dadosOrdenados, "Ordenado");

            System.out.println(">> Ordem Aleatória:");
            testarArvoreAVL(dadosAleatorios, "Aleatório");

            System.out.println(">> Ordem Invertida:");
            testarArvoreAVL(dadosInvertidos, "Invertido");
        }
    }

    public static void testarArvoreAVL(int[] dados, String ordem) {
        ArvoreAVL arvore = new ArvoreAVL();
        Random random = new Random();
        
        System.out.println("Iniciando os testes para " + ordem);
        
        double tempoInsercao = calcularMedia(() -> {
            for (int valor : dados) {
                arvore.inserir(valor);
            }
        });

        System.out.println(String.format("Tempo médio de inserção na árvore AVL (%s): %f ms", ordem, tempoInsercao));

        double tempoBusca = calcularMedia(() -> {
            arvore.buscar(dados[0]);
        });
        System.out.println(String.format("\n\nTempo médio de busca na árvore AVL (Primeiro Elemento) (%s): %f ms", ordem, tempoBusca));
        double tempoBusca2 = calcularMedia(() -> {
            arvore.buscar(dados[dados.length - 1]);
        });
        System.out.println(String.format("Tempo médio de busca na árvore AVL (Ultimo Elemento) (%s): %f ms", ordem, tempoBusca2));
        double tempoBusca3 = calcularMedia(() -> {
            arvore.buscar(dados[dados.length / 2]);
        });
        System.out.println(String.format("Tempo médio de busca na árvore AVL (Elemento do Meio) (%s): %f ms", ordem, tempoBusca3));
        double tempoBusca4 = calcularMedia(() -> {
            arvore.buscar(-1);
        });
        System.out.println(String.format("Tempo médio de busca na árvore AVL (Elemento Inexistente) (%s): %f ms\n\n", ordem, tempoBusca4));
        double tempoBusca5 = calcularMedia(() -> {
            arvore.buscar(dados[random.nextInt(dados.length)]);
        });
        System.out.println(String.format("Tempo médio de busca na árvore AVL (Elemento Aleatorio) (%s): %f ms\n\n", ordem, tempoBusca5));

    }

    private static double calcularMedia(Runnable teste) {
        int repeticoes = 5;
        double soma = 0;

        for (int i = 0; i < repeticoes; i++) {
            long tempoInicio = System.nanoTime();
            teste.run();
            long tempoFim = System.nanoTime();
            soma += (tempoFim - tempoInicio) / 1_000_000.0;
        }

        return soma / repeticoes;
    }

    public static int[] gerarDados(int tamanho, String ordem) {
        int[] dados = new int[tamanho];
        
        if (ordem.equals("ordenado")) {
            for (int i = 0; i < tamanho; i++) {
                dados[i] = i;
            }
        } else if (ordem.equals("invertido")) {
            for (int i = 0; i < tamanho; i++) {
                dados[i] = tamanho - i - 1;
            }
        } else if (ordem.equals("aleatorio")) {
            Random random = new Random();
            for (int i = 0; i < tamanho; i++) {
                dados[i] = random.nextInt();
            }
        }
        
        return dados;
    }

}

