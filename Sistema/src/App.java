import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Fila<Paciente> filaDePacientes = new Fila<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
       System.out.println("\n==============================");
        System.out.println("     SISTEMA DE ATENDIMENTO");
        System.out.println("==============================");
        System.out.println("1. Adicionar paciente");
        System.out.println("2. Listar fila");
        System.out.println("3. Atender próximo paciente");
        System.out.println("4. Sair");
        System.out.print("\nEscolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome");
                    String nome = sc.nextLine();

                    System.out.println("Idade");
                    Integer idade = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Motivo da consulta");
                    for (MotivoConsulta m : MotivoConsulta.values()) {
                        System.out.println("- " + m);
                    }
                    MotivoConsulta motivoConsulta = MotivoConsulta.valueOf(sc.nextLine().toUpperCase());

                    System.out.println("Prioridade");
                    for (Prioridade p : Prioridade.values()) {
                        System.out.println("- " + p);
                    }
                    Prioridade prioridade = Prioridade.valueOf(sc.nextLine().toUpperCase());

                    Paciente novoPaciente = new Paciente(nome, idade, motivoConsulta, prioridade);
                    filaDePacientes.enfileirar(novoPaciente);
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;

                    case 2: filaDePacientes.imprime();
                    break;

                default:
                    break;
            }
        }

    }
}
