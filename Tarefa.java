public class Tarefa {

    private String nome;
    private Status status;

    public Tarefa(String nome, Status status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return nome + " - " + status;
    }
}