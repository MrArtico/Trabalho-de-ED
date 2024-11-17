package Main;

public class Vetores {
    private int[] array1;
    private double tempoDe100;
    private int[] array2;
    private double tempoDe1000;
    private int[] array3;
    private double tempoDe10000;
    private Cronometro cronometro;

    public Vetores() {
        array1 = new int[100];
        array2 = new int[1000];
        array3 = new int[10000];
        Cronometro cronometro = new Cronometro();
    }

    public void preencherOrdenado() {
        tempoDe100 = preencherOrdenado(array1);
        tempoDe1000 = preencherOrdenado(array2);
        tempoDe10000 = preencherOrdenado(array3);
    }

    public void preencherAleatorio() {
        tempoDe100 = preencherAleatorio(array1);
        tempoDe1000 = preencherAleatorio(array2);
        tempoDe10000 = preencherAleatorio(array3);
    }

    public void preencherInverso() {
        tempoDe100 = preencherInverso(array1);
        tempoDe1000 = preencherInverso(array2);
        tempoDe10000 = preencherInverso(array3);
    }

    private double preencherOrdenado(int[] array) {
        cronometro.iniciar();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        cronometro.parar();
        return cronometro.getDuracaoMilisegundos();
    }

    private double preencherInverso(int[] array) {
        cronometro.iniciar();
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        cronometro.parar();
        return cronometro.getDuracaoMilisegundos();
    }

    private double preencherAleatorio(int[] array) {
        cronometro.iniciar();
        for (int i = 0; i < array.length; i++) {
            array[i] = Randomico.getRandom();
        }
        cronometro.parar();
        return cronometro.getDuracaoMilisegundos();
    }

    public int buscaSequencial(int[] array, int numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                return array[i];
            }
        }
        return -1;
    }

    public int buscaBinaria(int[] array, int numero) {
        int inicio = 0;
        int fim = array.length;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;

            if (array[meio] == numero) {
                return meio;
            }
            else if (array[meio] < numero) {
                inicio = meio + 1;
            }
            else {
                fim = meio - 1;
            }
        }

        return -1;
    }

    public int[] getArray1() {
        return array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public int[] getArray3() {
        return array3;
    }

    public double getTempoDe100() {
        return tempoDe100;
    }

    public double getTempoDe1000() {
        return tempoDe1000;
    }

    public double getTempoDe10000() {
        return tempoDe10000;
    }

}
