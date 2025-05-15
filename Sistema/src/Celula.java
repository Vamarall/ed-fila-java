public class Celula<E>{

    private E item;
    private Celula<E> proximaCelula;

    public Celula(){
        this.item = null;
        setProximaCelula(null);
    }

    public void setProximaCelula(Celula<E> proximCelula) {
        this.proximaCelula = proximCelula;
    }

    public Celula(Celula<E> proxima, E item){
        this.item = item;
        setProximaCelula(proxima);

    }

    public E getItem() {
        return item;
    }

    public Celula<E> getProximaCelula() {
        return proximaCelula;
    }

    public void setItem(E item) {
        this.item = item;
    }

    
    
}