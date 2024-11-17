package Main;
import java.util.Random;

public class Randomico {
    private static Random random = new Random();

    public Randomico() {
        random = new Random();
    }

    public static int getRandom() {
        return random.nextInt((int) (Math.random() * 10000) + 1);
    }
}

