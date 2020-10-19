package TD1;

import java.util.List;
import java.util.Set;

public class Noeud implements Arbre{
    public final List<Arbre> fils;

    public Noeud(List<Arbre> fils) {
        this.fils = fils;
    }


    @Override
    public int taille() {
        return 0;
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
