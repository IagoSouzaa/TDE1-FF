import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> {
    private Queue<T> elementos;

    public Fila() {
        elementos = new LinkedList<>();
    }

    public void enqueue(T valor) {
        elementos.add(valor);
    }

    public T dequeue() {
        return elementos.poll();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
