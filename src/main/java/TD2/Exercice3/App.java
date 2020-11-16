package TD2.Exercice3;

import java.util.*;
import java.util.function.Predicate;

public class App {


    static  Predicate<Etudiant> tousLesEtudiants = x -> true;

    static Predicate<Etudiant> aDEF = e-> {
        Set<Matiere> toutesLesMatieresDeLetudiant = App.toutesLesMatieresDeLannee(e.annee());
        for(Matiere m : toutesLesMatieresDeLetudiant){
            if (!e.notes().containsKey(m)){
                return true;
            }
        }
        return false;
    };

    static Predicate<Etudiant> aNoteEliminatoire = x -> {
        boolean defaillant = false;
        for(double note : x.notes().values()){
            if(note < 6) {
                defaillant = true;
                break;
            }
        }
        return defaillant;
    };

    // En supposant que la fonction moyenne fonctionne
    //Unboxing of 'moyenne(x)' may produce 'NullPointerException'
    static Predicate<Etudiant> naPasLaMoyennev1 = x -> moyenne(x)<10;


    // En supposant que la fonction moyenne fonctionne
    // D'abord verifier x==null ensuite x<= 10
    static Predicate<Etudiant> naPasLaMoyennev2 = x -> moyenne(x)==null || moyenne(x)<10;



    /*  1. naPasLaMoyennev1 -> aNoteEliminatoire -> aDEF == Erreur dabord verifier aDEF
        2. aNoteEliminatoire -> naPasLaMoyennev1 -> aDEF == Erreur dabord verifier aDEF
        3. aDEF -> aNoteEliminatoire -> naPasLaMoyennev1 == OK Session 2
        4. aDEF -> naPasLaMoyennev1 -> aNoteEliminatoire  == OK Session 2
        L'ordre entre "aNoteEliminatoire" et "naPasLaMoyennev1" ne change rien      */
    static Predicate<Etudiant> session2v1 = x-> aDEF.or(naPasLaMoyennev1).or(aNoteEliminatoire).test(x);


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

    private static Map<Matiere,Integer> matiereEtCoeffEtudiant(Etudiant etudiant){
        Map<Matiere,Integer> tmp = new HashMap<>();
        for (UE ue : etudiant.annee().ues()){
            tmp.putAll(ue.ects());
        }
        return tmp;
    }


    public static Double moyenne(Etudiant etudiant) {

        if(aDEF.test(etudiant))
            return null;

        Double numerateur = 0.0;
        Double denominateur = 0.0;
        Map<Matiere, Integer> etudiantMatieresAndEcts = matiereEtCoeffEtudiant(etudiant);

        for (Matiere m : etudiantMatieresAndEcts.keySet()) {
            numerateur += etudiant.notes().get(m) * etudiantMatieresAndEcts.get(m);
            denominateur += etudiantMatieresAndEcts.get(m);
        }
        return numerateur / denominateur;
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

        // afficheSi("Etudiants (foreach) :",tousLesEtudiants,a1);
        // afficheSi("Etudiants Défaillant :",aDEF,a1);
        // afficheSi("Etudiants Note Eliminatoire",aNoteEliminatoire,a1);
        // afficheSi("Etudiants pas la moyenne V1",naPasLaMoyennev1,a1);
        //afficheSi("Etudiants pas la moyenne V2",naPasLaMoyennev2,a1);
        afficheSi("Etudiants pas la moyenne V2",session2v1,a1);
    }




}
