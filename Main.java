import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Tarefa[] tarefas = new Tarefa[10];
    static int quantidade = 0;

    static Pilha pilha = new Pilha(10);

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Buscar tarefa");
            System.out.println("4 - Ordenar tarefas");
            System.out.println("5 - Empilhar tarefa");
            System.out.println("6 - Desempilhar tarefa");
            System.out.println("7 - Ver topo da pilha");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    adicionarTarefa();
                    break;

                case 2:
                    listarTarefas();
                    break;

                case 3:
                    buscarTarefa();
                    break;

                case 4:
                    ordenarTarefas();
                    break;

                case 5:
                    empilharTarefa();
                    break;

                case 6:
                    desempilharTarefa();
                    break;

                case 7:
                    verTopo();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;
            }

        } while (opcao != 0);
    }

    public static void adicionarTarefa() {

        System.out.print("Nome da tarefa: ");
        String nome = scanner.nextLine();

        tarefas[quantidade] =
                new Tarefa(nome, Status.PENDENTE);

        quantidade++;

        System.out.println("Tarefa cadastrada!");
    }

    public static void listarTarefas() {

        for (int i = 0; i < quantidade; i++) {
            System.out.println(tarefas[i]);
        }
    }

    public static void buscarTarefa() {

        System.out.print("Digite o nome: ");

        String busca = scanner.nextLine();

        for (int i = 0; i < quantidade; i++) {

            if (tarefas[i].getNome().equalsIgnoreCase(busca)) {
                System.out.println("Tarefa encontrada!");
                return;
            }
        }

        System.out.println("Tarefa não encontrada!");
    }

    public static void ordenarTarefas() {

        for (int i = 0; i < quantidade - 1; i++) {

            for (int j = i + 1; j < quantidade; j++) {

                if (tarefas[i].getNome()
                        .compareToIgnoreCase(tarefas[j].getNome()) > 0) {

                    Tarefa aux = tarefas[i];
                    tarefas[i] = tarefas[j];
                    tarefas[j] = aux;
                }
            }
        }

        System.out.println("Tarefas ordenadas!");
    }

    public static void empilharTarefa() {

        System.out.print("Digite a tarefa: ");
        String tarefa = scanner.nextLine();

        pilha.empilhar(tarefa);
    }

    public static void desempilharTarefa() {

        String removida = pilha.desempilhar();

        if (removida != null) {
            System.out.println("Removida: " + removida);
        } else {
            System.out.println("Pilha vazia!");
        }
    }

    public static void verTopo() {

        System.out.println("Topo: " + pilha.topo());
    }
}