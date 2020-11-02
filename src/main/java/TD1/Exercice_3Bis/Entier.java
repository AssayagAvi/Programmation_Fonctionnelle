package TD1.Exercice_3Bis;

public class Entier implements Sommable<Entier> {

    private Integer valeur ;

    public Entier(Integer valeur) {
        this.valeur = valeur;
    }

    public int valeur(){
        return valeur;
    }


    @Override
    public Entier sommer(final Entier autre) {
        return new Entier(this.valeur() + autre.valeur() );
    }


    public String toString(){
        return String.format("%d :: Entier",this.valeur());
    }

    @Override
    public boolean equals(Object o){
        if (o == null) return false;
        if(!(o instanceof Entier))return false;
        return this.valeur == ((Entier)o).valeur;
    }

    @Override
    public int hashCode(){
        return valeur.hashCode();
    }
}

