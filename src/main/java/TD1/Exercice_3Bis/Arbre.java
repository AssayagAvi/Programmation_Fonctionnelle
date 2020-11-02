package TD1.Exercice_3Bis;

import java.util.Set;

public interface Arbre<T> {
    int taille();
    boolean contient(final T val);
    Set<T> valeurs();
}
