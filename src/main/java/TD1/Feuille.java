package TD1;

import java.util.Set;

public class Feuille implements Arbre{
    public final int valeur;

    public Feuille(int valeur) {
        this.valeur = valeur;
    }


    @Override
    public int taille() {
        return 1;
    }

    @Override
    public boolean contient(Integer val) {
        return false;
    }

    @Override
    public Set<Integer> valeurs() {
        return null;
    }

    @Override
    public Integer somme() {
        return null;
    }

    @Override
    public Integer min() {
        return null;
    }

    @Override
    public Integer max() {
        return null;
    }

    @Override
    public boolean estTrie() {
        return false;
    }
}
