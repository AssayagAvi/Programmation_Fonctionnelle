package TD2.Exercice2;

import java.util.function.Function;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        question2();
    }


    public static void question2(){
        Paire<Integer,Integer> avi = new Paire<>(120,70);

        Predicate <Integer> tropPetit = x-> x<100;
        System.out.println("Petit :" + tropPetit.test(avi.fst));

        Predicate <Integer> tropGrand = x-> x>200;
        System.out.println("Grand :" + tropGrand.test(avi.fst));

        Predicate<Integer> tailleIncorect = tropPetit.or(tropGrand);
        System.out.println("Taille Incorect : " + tailleIncorect.test(avi.fst));

        Predicate<Integer> tailleCorrect = Predicate.not(tailleIncorect);
        System.out.println("Taille Correct :" +tailleCorrect.test(avi.fst));

        Predicate <Integer> tropLourd = x-> x>150;
        System.out.println("Lourd : " + tropLourd.test(avi.snd));

        Predicate<Integer> accesAuthorise = tailleCorrect.and(Predicate.not(tropLourd));
        System.out.println("accesAuthorise.test(avi.fst) && = " + accesAuthorise.test(avi.fst));
    }

}
