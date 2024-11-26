package estrutura;

public class ArvoreAVL {

    private No raiz;

    private static class No {
        int valor;
        No esquerdo, direito;
        int altura;

        No(int valor) {
            this.valor = valor;
            this.altura = 1;
            this.esquerdo = this.direito = null;
        }
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerdo = inserir(raiz.esquerdo, valor);
        } else if (valor > raiz.valor) {
            raiz.direito = inserir(raiz.direito, valor);
        } else {
            return raiz;
        }

        raiz.altura = 1 + Math.max(obterAltura(raiz.esquerdo), obterAltura(raiz.direito));

        int fatorBalanceamento = obterFatorBalanceamento(raiz);

        if (fatorBalanceamento > 1 && valor < raiz.esquerdo.valor) {
            return rotacionarDireita(raiz);
        }

        if (fatorBalanceamento < -1 && valor > raiz.direito.valor) {
            return rotacionarEsquerda(raiz);
        }

        if (fatorBalanceamento > 1 && valor > raiz.esquerdo.valor) {
            raiz.esquerdo = rotacionarEsquerda(raiz.esquerdo);
            return rotacionarDireita(raiz);
        }

        if (fatorBalanceamento < -1 && valor < raiz.direito.valor) {
            raiz.direito = rotacionarDireita(raiz.direito);
            return rotacionarEsquerda(raiz);
        }

        return raiz;
    }

    private No rotacionarDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(obterAltura(y.esquerdo), obterAltura(y.direito)) + 1;
        x.altura = Math.max(obterAltura(x.esquerdo), obterAltura(x.direito)) + 1;

        return x;
    }

    private No rotacionarEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(obterAltura(x.esquerdo), obterAltura(x.direito)) + 1;
        y.altura = Math.max(obterAltura(y.esquerdo), obterAltura(y.direito)) + 1;

        return y;
    }

    private int obterAltura(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return raiz.altura;
    }

    private int obterFatorBalanceamento(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return obterAltura(raiz.esquerdo) - obterAltura(raiz.direito);
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No raiz, int valor) {
        if (raiz == null) {
            return false;
        }

        if (valor == raiz.valor) {
            return true;
        }

        return valor < raiz.valor ? buscar(raiz.esquerdo, valor) : buscar(raiz.direito, valor);
    }
}

