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
        long t1 = ordenadoA.getTempoDe100();
        long t2 = ordenadoA.getTempoDe1000();
        long t3 = ordenadoA.getTempoDe10000();

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(ordenadoA.buscaSequencial(ordenadoA.getArray1(), 101));
    }

}