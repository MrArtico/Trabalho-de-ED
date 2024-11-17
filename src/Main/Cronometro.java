package Main;

public class Cronometro {
    private long tempoInicio, tempoFim = 0;

    public Cronometro() {

    }

    public Cronometro(long tempoInicio, long tempoFim) {
        this.tempoFim = tempoFim;
        this.tempoInicio = tempoInicio;
    }

    public void iniciar() {
        tempoInicio = System.nanoTime();
    }

    public void parar() {
        tempoFim = System.nanoTime();
    }

    public long getDuracaoNanoSegundos() {
        return tempoFim - tempoInicio;
    }

    public double getDuracaoMilisegundos() {
        return getDuracaoNanoSegundos() / 1000000.0;
    }
}
