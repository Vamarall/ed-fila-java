import java.util.NoSuchElementException;

public class Fila<E> {

    private Celula<E> tras;
    private Celula<E> frente;
    private Integer tamanho;

    public Fila() {
        // Instanciando celula sentinela (Celula auxiliar)
        Celula<E> sentinela = new Celula<>();
        frente = tras = sentinela;
        tamanho = 0;

    }

    // Verifica se a lista está vazia.
    public boolean estaVazia() {
        return (frente == tras);
    }

    // Adiciona item na fila.
    public void enfileirar(E item) {
        Celula<E> novaCelula = new Celula<E>(item);
        tras.setProximaCelula(novaCelula);
        tras.getProximaCelula();
        tamanho++;

    }

    // Adiciona item na fila.
    public E consultarPrimeiro() {
        if (estaVazia()) {
            throw new NoSuchElementException("Nao há nenhum item na fila!");
        }

        return frente.getProximaCelula().getItem();
    }

    public E desenfileirar() {
        Celula<E> celulaRemovida;
        E item;

        celulaRemovida = frente.getProximaCelula();
        frente.setProximaCelula(celulaRemovida.getProximaCelula()); // Atualiza referencia para pular a celula removida

        celulaRemovida.setProximaCelula(null);

        // Caso o item desenfileirado seja também o último da fila.
        if (frente == tras) {
            tras = frente;
        }

        item = consultarPrimeiro();

        return item;

    }

    

}
