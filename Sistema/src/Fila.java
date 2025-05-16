import java.util.NoSuchElementException;

public class Fila<E> {
    private Celula<E> frente;
    private Celula<E> tras;
    private int tamanho;

    public Fila() {
        Celula<E> sentinela = new Celula<>();
        frente = tras = sentinela;
        tamanho = 0;
    }

    public boolean estaVazia() {
        return frente == tras;
    }

    public void enfileirar(E item) {
        Celula<E> novaCelula = new Celula<>(item);
        tras.setProximaCelula(novaCelula);
        tras = novaCelula;
        tamanho++;
    }

    public E consultarPrimeiro() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }
        return frente.getProximaCelula().getItem();
    }

    public E desenfileirar() {
        if (estaVazia()) {
            throw new NoSuchElementException("Fila vazia!");
        }

        Celula<E> celulaRemovida = frente.getProximaCelula();
        E item = celulaRemovida.getItem();
        frente.setProximaCelula(celulaRemovida.getProximaCelula());

        if (celulaRemovida == tras) {
            tras = frente;
        }

        celulaRemovida.setProximaCelula(null);
        tamanho--;
        return item;
    }

    public void imprime() {
        if (estaVazia()) {
            System.out.println("⚠️ A fila está vazia.");
            return;
        }

        System.out.println("\n--- Pacientes na Fila ---");
        Celula<E> aux = frente.getProximaCelula();
        int pos = 1;
        while (aux != null) {
            System.out.println(pos++ + ". " + aux.getItem());
            aux = aux.getProximaCelula();
        }
    }

    public int tamanho() {
        return tamanho;
    }
}
