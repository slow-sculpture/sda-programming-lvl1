package pl.sda.poznan.algorithm;

public class MathUtils {
    /**
     * Algorytm Euklidesa
     */
    public static int NWD(int a, int b) {
        while (a != b) {
            if (a < b) {
                b = b - a;
            } else {
                a = a - b;
            }

        }
        return a;
    }

    /**
     * Obliczanie silni rekurencyjnie
     */
    public static int factorial (int n){
        if (n < 0) {
            throw new IllegalArgumentException("n must be > than 0");
        }
        if (n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

    /**
     * Fibonacci rekurencyjnie
     * */
    public static int fibonacci(int n){
        if (n < 0){
            throw new IllegalArgumentException("Achtung!!!! n must be > than 0");
        }
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n -2);
        }

    }
}
