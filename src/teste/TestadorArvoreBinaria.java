package teste;

import java.util.Random;
import estrutura.ArvoreBinaria;
import util.Cronometro;

public class TestadorArvoreBinaria {

    public static void testarArvoreBinaria(int[] dados, String ordem) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("Iniciando os testes para " + ordem);
        
        double tempoInsercao = calcularMedia(() -> {
            for (int valor : dados) {
                arvore.inserir(valor);
            }
        });

        System.out.println(String.format("Tempo médio de inserção na árvore binária (%s): %.2f ms", ordem, tempoInsercao));

        double tempoBusca = calcularMedia(() -> {
            arvore.buscar(dados[0]);
            arvore.buscar(dados[dados.length - 1]);
            arvore.buscar(dados[dados.length / 2]);
            arvore.buscar(-1);
        });

        System.out.println(String.format("Tempo médio de busca na árvore binária (%s): %.2f ms", ordem, tempoBusca));
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
    public static void main(String[] args) {

        int[] tamanhos = {100, 1000, 10000};

        for (int tamanho : tamanhos) {
            System.out.println("\n--- Testando Árvores Binárias com " + tamanho + " elementos ---");

            int[] dadosOrdenados = gerarDados(tamanho, "ordenado");
            int[] dadosAleatorios = gerarDados(tamanho, "aleatorio");
            int[] dadosInvertidos = gerarDados(tamanho, "invertido");

            System.out.println(">> Ordem Ordenada:");
            testarArvoreBinaria(dadosOrdenados, "Ordenado");

            System.out.println(">> Ordem Aleatória:");
            testarArvoreBinaria(dadosAleatorios, "Aleatório");

            System.out.println(">> Ordem Invertida:");
            testarArvoreBinaria(dadosInvertidos, "Invertido");
        }
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
