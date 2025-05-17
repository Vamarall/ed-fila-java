import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Fila<Paciente> filaDePacientes = new Fila<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==============================");
            System.out.println("     SISTEMA DE ATENDIMENTO");
            System.out.println("==============================");
            System.out.println("1. Adicionar paciente");
            System.out.println("2. Listar fila");
            System.out.println("3. Atender próximo paciente");
            System.out.println("4. Ver quantos pacientes estão à frente de um nome");
            System.out.println("5. Filtrar por prioridade");
            System.out.println("6. Concatenar uma nova fila");
            System.out.println("7. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Nome:");
                    String nome = sc.nextLine();

                    System.out.println("Idade:");
                    int idade = Integer.parseInt(sc.nextLine());

                    System.out.println("Motivo da consulta:");
                    for (MotivoConsulta m : MotivoConsulta.values()) {
                        System.out.println("- " + m);
                    }
                    MotivoConsulta motivoConsulta = MotivoConsulta.valueOf(sc.nextLine().toUpperCase());

                    System.out.println("Prioridade:");
                    for (Prioridade p : Prioridade.values()) {
                        System.out.println("- " + p);
                    }
                    Prioridade prioridade = Prioridade.valueOf(sc.nextLine().toUpperCase());

                    filaDePacientes.enfileirar(new Paciente(nome, idade, motivoConsulta, prioridade));
                    System.out.println("✅ Paciente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("📋 Fila de pacientes:");
                    filaDePacientes.imprime();
                    break;

                case 3:
                    System.out.println("🔔 Chamando próximo paciente...");
                    Paciente atendido = filaDePacientes.desenfileirar();
                    if (atendido != null) {
                        System.out.println("✅ " + atendido.getNome() + " foi atendido.");
                    } else {
                        System.out.println("⚠️ Fila vazia.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do paciente:");
                    String nomeBusca = sc.nextLine();
                    Paciente paciente = filaDePacientes.buscarPeloNome(x -> x.getNome().equalsIgnoreCase(nomeBusca));

                    if (paciente != null) {
                        int posicao = filaDePacientes.quantosAFrente(paciente);
                        System.out.println("📍 Há " + posicao + " paciente(s) à frente de " + nomeBusca + ".");
                    } else {
                        System.out.println("❌ Paciente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o tipo de prioridade:");
                    for (Prioridade p : Prioridade.values()) {
                        System.out.println("- " + p);
                    }
                    Prioridade prioridadeFiltro = Prioridade.valueOf(sc.nextLine().toUpperCase());

                    Fila<Paciente> filtrada = filaDePacientes.filtrar(p -> p.getPrioridade().equals(prioridadeFiltro));
                    System.out.println("🎯 Pacientes com prioridade " + prioridadeFiltro + ":");
                    filtrada.imprime();
                    break;

                case 6:
                    System.out.println("Adicionando nova fila com 1 paciente para concatenar...");

                    System.out.println("Nome:");
                    String nome2 = sc.nextLine();

                    System.out.println("Idade:");
                    int idade2 = Integer.parseInt(sc.nextLine());

                    System.out.println("Motivo da consulta:");
                    for (MotivoConsulta m : MotivoConsulta.values()) {
                        System.out.println("- " + m);
                    }
                    MotivoConsulta motivo2 = MotivoConsulta.valueOf(sc.nextLine().toUpperCase());

                    System.out.println("Prioridade:");
                    for (Prioridade p : Prioridade.values()) {
                        System.out.println("- " + p);
                    }
                    Prioridade prioridade2 = Prioridade.valueOf(sc.nextLine().toUpperCase());

                    Fila<Paciente> novaFila = new Fila<>();
                    novaFila.enfileirar(new Paciente(nome2, idade2, motivo2, prioridade2));
                    filaDePacientes.concatenar(novaFila);
                    System.out.println("✅ Fila concatenada com sucesso.");
                    break;

                case 7:
                    System.out.println("👋 Encerrando o sistema. Até mais!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Opção inválida. Tente novamente.");
            }
        }
    }
}
