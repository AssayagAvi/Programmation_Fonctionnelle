package TD1.Exercice_3;

import java.util.Set;

public interface Arbre {
    int taille();
    boolean contient(final Integer val);
    Set<Integer> valeurs();
    Integer somme();
    Integer min();
    Integer max();
    boolean estTrie();
}