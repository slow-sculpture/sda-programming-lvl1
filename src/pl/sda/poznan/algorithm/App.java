package pl.sda.poznan.algorithm;

public class App {


    public static void main(String[] args) {
        //algorytm euklidesa
        int result = MathUtils.NWD(24, 6);
        System.out.println(result);

        //silnia
        try {
            System.out.println(MathUtils.factorial(5));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        //fibonacci
        try {
            System.out.println(MathUtils.fibonacci(4));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}
