import java.util.ArrayList;

public class Pilha<T> {
    private ArrayList<T> elementos;

    public Pilha() {
        elementos = new ArrayList<>();
    }

    public void push(T valor) {
        elementos.add(valor);
    }

    public T pop() {
        if (!isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }
}
