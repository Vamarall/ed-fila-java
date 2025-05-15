
public class Fila<E> {

    private Celula<E> tras;
    private Celula<E> frente;

    public Fila(){
        //Instanciando celula sentinela (Celula auxiliar)
        Celula<E> sentinela = new Celula<>();
    }
    
}
