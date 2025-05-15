
public class Fila<E> {

    private Celula<E> tras;
    private Celula<E> frente;
    private int tamanho;

    public Fila(){
        //Instanciando celula sentinela (Celula auxiliar)
        Celula<E> sentinela = new Celula<>();
        frente = tras = sentinela;
        this.tamanho = 0;

    }

    //Verifica se a lista está vazia. 
    public boolean estaVazia(){
        return (frente == tras);
    }

    //Adiciona item na fila.
    public void enfileirar(E item){
        Celula<E> novaCelula = new Celula<E>(item);
        tras.setProximaCelula(novaCelula);
        tras.getProximaCelula();

    }
    
}
