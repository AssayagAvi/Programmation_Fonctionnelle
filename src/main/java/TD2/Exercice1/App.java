package TD2.Exercice1;

public class App {

    public static void main(String[] args) {
       question1();
    }

    public static void question1(){
        Somme <Integer> sommeInt = (a,b) -> a + b;
        Somme <Double> sommeDouble = (a,b) -> a + b;
        Somme <Float> sommeFloat = (a,b) -> a + b;
        Somme <String> sommeString = (a,b) -> a + b;

    }
}
