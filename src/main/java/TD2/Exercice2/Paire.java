package TD2.Exercice2;

public class Paire<T,U> {
    public T fst; //taille
    public U snd; //poids
    public Paire(T fst, U snd) {
        this.fst = fst;
        this.snd = snd;
    }
    @Override public String toString() {
        return String.format("(%s,%s)",fst.toString(),snd.toString());
    }
}
