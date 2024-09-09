package Útil;

import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public Agenda() {
        menuOpcoes();
    }

    private void menuOpcoes() {
        int opcao;
        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    Menu.ADICIONAR.criarNovoContato(sc, contatos);
                    break;
                case 2:
                    Menu.DETALHAR.listar(sc, contatos);
                    break;
                case 3:
                    Menu.EDITAR.editarContato(sc, contatos);
                    break;
                case 4:
                    Menu.REMOVER.removerContato(sc, contatos);
                    break;
                case 5:
                    Menu.TRANSFERIR.realizarOperacao(sc, contatos);
                    break;
                case 6:
                    Menu.SAIR.sair();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }

    private void menu() {
        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################");
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Listar contatos");
        System.out.println("3 - Editar contato");
        System.out.println("4 - Remover contato");
        System.out.println("5 - Realizar transferência");
        System.out.println("6 - Sair");
    }