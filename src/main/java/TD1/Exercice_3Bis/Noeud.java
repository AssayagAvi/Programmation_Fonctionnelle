package TD1.Exercice_3Bis;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noeud<T extends Sommable<T> & Comparable<T>> implements Arbre<T>{

    private final List<Arbre<T>> fils;

    public Noeud(List<Arbre<T>> fils) {
        this.fils = fils;
    }

    @Override
    public int taille() {
        int rtr = 0;
        for (final Arbre<T> a : fils) {
            rtr += a.taille();
        }
        return rtr;
    }

    @Override
    public boolean contient(final T val) {
        boolean rtr = false;
        for (final Arbre<T> a : fils) {
            if (a.contient(val)) {
                rtr= true;
                break;
            }
        }
        return rtr;
    }

    @Override
    public Set<T> valeurs() {
        Set<T> rtr = new HashSet<>();
        for (final Arbre<T> a : fils) {
            rtr.addAll(a.valeurs());
        }
        return rtr;
    }

    @Override
    public T somme() {
        if (fils == null || fils.size()==0)
            return null;
        T rtr = fils.get(0).somme();
        for (int i = 1; i < fils.size(); i++)
            rtr = rtr.sommer(fils.get(i).somme());
        return rtr;
    }

    @Override
    public T min() {
        return null;
    }

    @Override
    public T max() {
        return null;
    }

    @Override
    public boolean estTrie() {
        return false;
    }
}
