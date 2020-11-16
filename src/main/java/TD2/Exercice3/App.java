package TD2.Exercice3;

import java.util.*;
import java.util.function.Predicate;

public class App {

    private static void afficheSi(String entete, Predicate<Etudiant> condition, Annee annee) {
        System.out.println(String.format("** %s",entete));
        annee.etudiants().forEach(e -> {
            if (condition.test(e)) {
                System.out.println(e);
            }
        });

    }

    private static void afficheSi2(String entete, Predicate<Etudiant> condition, Annee annee) {
        System.out.printf("** %s%n",entete);
        for (Etudiant e : annee.etudiants()){
            if (condition.test(e)){
                System.out.println(e);
            }
        }
    }

    public static final Set<Matiere> toutesLesMatieresDeLannee(Annee a){
        Set<Matiere> rtr = new HashSet<>();
        for (UE ue : a.ues()){
            rtr.addAll(ue.ects().keySet());
        }
        return rtr;
    }

    public static Double moyenne (Etudiant etudiant, Predicate<Etudiant> predicate ){
        final double moyenneEtudiant [] = {0.0};
        final int ects [] = {0};
        if (predicate.test(etudiant)){
            return null;
        }
        etudiant.annee().ues().forEach(ue -> {
            ue.ects().forEach((matiere,coefficiant) ->{
                ects[0]= ects[0] + coefficiant;
                moyenneEtudiant[0] = etudiant.notes().get(matiere)*coefficiant;
            });
        });
        moyenneEtudiant[0] = moyenneEtudiant[0]/ects[0];
        return moyenneEtudiant[0];

    }
    public static void main(String[] args) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        Matiere m3 = new Matiere("MAT3");
        UE ue2 = new UE("UE2", Map.of(m3, 1));
        Annee a1 = new Annee(Set.of(ue1, ue2));
        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        e1.noter(m3, 10.0);
        //System.out.println(e1);
        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
        e2.noter(m1, 14.0);
        e2.noter(m3, 14.0);
        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
        e3.noter(m1, 18.0);
        e3.noter(m2, 5.0);
        e3.noter(m3, 14.0);

        Predicate<Etudiant> tousLesEtudiants = etudiant -> true;

        Predicate<Etudiant> aDEF = e-> {
            Set<Matiere> toutesLesMatieresDeLetudiant = App.toutesLesMatieresDeLannee(e.annee());
            for(Matiere m : toutesLesMatieresDeLetudiant){
                if (!e.notes().containsKey(m)){
                    return true;
                }
            }
            return false;
        };


        Predicate<Etudiant> aNoteEliminatoire = x -> {
            boolean defaillant = false;
            for(double note : x.notes().values()){
                if(note < 6) {
                    defaillant = true;
                    break;
                }
            }
            return defaillant;
        };


        //afficheSi("Etudiants (foreach) :",tousLesEtudiants,a1);
        //afficheSi("Etudiants Défaillant :",aDEF,a1);
        //afficheSi("Etudiants Note Eliminatoire",aNoteEliminatoire,a1);
    }




}
