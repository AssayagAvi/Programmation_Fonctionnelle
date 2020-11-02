package TD1.Exercice_3Bis;

import java.util.Set;

public interface Arbre<T extends Sommable<T> & Comparable<T>> {
    int taille();
    boolean contient(final T val);
    Set<T> valeurs();
    T somme();
    T min();
    T max();
    boolean estTrie();
}
