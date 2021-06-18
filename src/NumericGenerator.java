import java.util.Random;

class NumericGenerator {
    private static NumericGenerator instance;
    private Random rnd;

    private NumericGenerator() {
        rnd = new Random();
    }

    public static NumericGenerator getInstance() {
        if(instance == null) {
            instance = new NumericGenerator();
        }
        return instance;
    }

    public double nextDouble() {
        return rnd.nextDouble();
    }
}

