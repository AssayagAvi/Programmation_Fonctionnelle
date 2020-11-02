package TD1.Exercice_3Bis;

import java.util.Set;

public class Feuille<T> implements Arbre<T> {
    private final T valeur;

    public Feuille(T valeur) {
        this.valeur=valeur ;
    }

    @Override
    public int taille() {
        return 1;
    }


    @Override
    public boolean contient(final T val) {
        return val.equals(valeur);
    }

    @Override
    public Set<T> valeurs() {
        return Set.of(valeur);
    }
}
