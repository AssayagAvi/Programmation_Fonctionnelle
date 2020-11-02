package TD1.Exercice_2;

public class App {
    public static void question2() {
        Paire<Integer, String> a1 = new Paire<>(2, "Deux");
        System.out.println(a1);
        Paire<Double, String> a2 = a1.changeFst(1.0);
        System.out.println(a2);
        Paire<Double, Paire<Integer,String>> a3 = a2.changeSnd(a1);
        System.out.println(a3);
    }

    public static void main(String[] args) {
      question2();

    }
}