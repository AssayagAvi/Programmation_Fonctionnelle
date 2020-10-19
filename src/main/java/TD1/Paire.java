package TD1;

public class Paire <T , U> {
    private T fst;
    private U snd;

    public Paire(T fst, U snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public T fst(){
        return fst;
}

    public U snd(){
        return snd;
    }

    public <V> Paire <V,U> changeFst(V val){
        return new Paire<>(val,snd);
    }

    public <V> Paire <T,V> changeSnd(V val){
        return new Paire<>(fst,val);
    }
    @Override
    public String toString(){
        return String.format("(%s, %s) :: Paire [%s, %s]", fst,snd,fst.getClass().getSimpleName(),snd.getClass().getSimpleName());
    }

}
