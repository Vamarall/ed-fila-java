import java.util.NoSuchElementException;
import java.util.function.Predicate;

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

    // Metodo que calcula quantos itens a frente do passado como parametro
    public int quantosAFrente(Paciente paciente) {

        Celula<E> aux = this.frente.getProximaCelula();
        int cont = 0;

        while (aux != null) {
            if (aux.getItem().equals(paciente)) {
                return cont;
            }
            aux = aux.getProximaCelula();
            cont++;
        }

        // Item nao encontrado
        return -1;

    }

    public E buscarPeloNome(Predicate<E> condicional) {
        Celula<E> aux = this.frente.getProximaCelula();

        while (aux != null) {
            if (condicional.test(aux.getItem())) {
                return aux.getItem();
            }
            aux = aux.getProximaCelula();
        }
        return null;
    }

    public Fila<E> filtrar(Predicate<E> condicional) {
        // Criar uma nova fila
        Fila<E> subFila = new Fila<>();
        Celula<E> aux = this.frente.getProximaCelula();

        if (estaVazia()) {
            System.out.println("⚠️ A fila está vazia.");
        }

        while (aux != null) {
            if (condicional.test(aux.getItem())) {
                subFila.enfileirar(aux.getItem());
            }
            aux = aux.getProximaCelula();
        }

        return subFila;

    }

    // Capaz de concatenar, ao final da fila original, a fila passada como parâmetro
    // para o método
    public void concatenar(Fila<E> fila) {

        if (fila.estaVazia()) {
            System.out.println("⚠️ A fila está vazia.");
        }
        if (this == fila) {
            throw new IllegalArgumentException("Não é possível concatenar a fila com ela mesma.");
        }

        Celula<E> aux = fila.frente.getProximaCelula();

        while (aux != null) {
            enfileirar(aux.getItem());
            aux = aux.getProximaCelula();
        }
    }

    // Capaz de criar e retornar uma cópia exata da fila
    public Fila<E> copiar() {
        if (estaVazia()) {
            return null;
        }
        Fila<E> copiaFila = new Fila<>();
        Celula<E> aux = this.frente.getProximaCelula();

        while (aux != null) {
            copiaFila.enfileirar(aux.getItem());
            aux = aux.getProximaCelula();
        }

        return copiaFila;
    }
    // Verifica a existência, na fila, de item correspondente àquele que foi passado
    // como parametro
    public boolean verificaExistencia(E item) {
        if (estaVazia()) {return false;}
        Celula<E> aux = this.frente.getProximaCelula();

        while (aux != null) {
            if (aux.getItem().equals(item)) {
                return true;
            }
            aux = aux.getProximaCelula();
        }

        return false;

    }

    public int tamanho() {
        return tamanho;
    }
}
