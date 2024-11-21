package estrutura;

public class Vetor {
    private int[] dados;
    private int tamanhoAtual;

    public Vetor(int capacidade) {
        dados = new int[capacidade];
        tamanhoAtual = 0;
    }

    public void inserir(int valor) {
        if (tamanhoAtual < dados.length) {
            dados[tamanhoAtual++] = valor;
        }
    }

    public int buscaSequencial(int valor) {
        for (int i = 0; i < tamanhoAtual; i++) {
            if (dados[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public int buscaBinaria(int valor) {
        int inicio = 0, fim = tamanhoAtual - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (dados[meio] == valor) {
                return meio;
            } else if (dados[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public int[] getDados() {
        int[] copia = new int[tamanhoAtual];
        System.arraycopy(dados, 0, copia, 0, tamanhoAtual);
        return copia;
    }
}
