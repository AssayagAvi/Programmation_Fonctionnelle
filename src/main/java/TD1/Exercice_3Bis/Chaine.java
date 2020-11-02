package TD1.Exercice_3Bis;

public class Chaine implements Sommable<Chaine> {

    private String valeur;

    public String valeur(){
        return valeur;
    }

    public Chaine(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public Chaine sommer(Chaine autre) {
        return new Chaine(String.format("%s%s :: Chaine",this.valeur(),autre.valeur()));

    }

    //@Override
    public int compareTo(Chaine autre) {
        return this.valeur.compareTo(autre.valeur);
    }

    @Override
    public boolean equals(Object o) {
        if ( o == null) return true;
        if (!(o instanceof Chaine)) return false;
        return this.valeur == ((Chaine)o).valeur;
    }

    @Override
    public int hashCode() {
        return valeur.hashCode();
    }
}

