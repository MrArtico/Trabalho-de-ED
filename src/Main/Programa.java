package Main;

public class Programa {
    public static Randomico randomico;

    public static void main(String[] args) {
        new Programa();
    }

    public Programa() {
        randomico = new Randomico();

        Vetores ordenadoA = new Vetores();
        Vetores inversoA = new Vetores();
        Vetores aleatorioA = new Vetores();

        ordenadoA.preencherOrdenado();
        inversoA.preencherInverso();
        aleatorioA.preencherAleatorio();
    }

}