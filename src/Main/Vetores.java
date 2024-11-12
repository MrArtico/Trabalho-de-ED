package Main;

public class Vetores {
    private int[] array1;
    private long tempoDe100;
    private int[] array2;
    private long tempoDe1000;
    private int[] array3;
    private long tempoDe10000;

    public Vetores() {
        array1 = new int[100];
        array2 = new int[1000];
        array3 = new int[10000];
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

    private long preencherOrdenado(int[] array) {
        long inicio = getNanoSecs();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return (getNanoSecs() - inicio) / 1000;

    }

    private long preencherInverso(int[] array) {
        long inicio = getNanoSecs();
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        return (getNanoSecs() - inicio) / 1000;
    }

    private long preencherAleatorio(int[] array) {
        long inicio = getNanoSecs();
        for (int i = 0; i < array.length; i++) {
            array[i] = Randomico.getRandom();
        }
        return (getNanoSecs() - inicio) / 1000;
    }

    public int buscaSequencial(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    private long getNanoSecs() {
        return System.nanoTime();
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

    public long getTempoDe100() {
        return tempoDe100;
    }

    public long getTempoDe1000() {
        return tempoDe1000;
    }

    public long getTempoDe10000() {
        return tempoDe10000;
    }

}