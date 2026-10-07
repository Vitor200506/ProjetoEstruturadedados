public class Pilha {

    private String[] elementos;
    private int topo;

    public Pilha(int tamanho) {
        elementos = new String[tamanho];
        topo = -1;
    }

    public void empilhar(String elemento) {

        if (topo < elementos.length - 1) {
            topo++;
            elementos[topo] = elemento;
        }
    }

    public String desempilhar() {

        if (topo >= 0) {
            String removido = elementos[topo];
            topo--;
            return removido;
        }

        return null;
    }

    public String topo() {

        if (topo >= 0) {
            return elementos[topo];
        }

        return null;
    }
}