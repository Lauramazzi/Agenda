package Útil;

import java.util.ArrayList;
import java.util.Scanner;

public enum Menu {
    ADICIONAR {
        @Override
        public void criarNovoContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Qual o nome do contato?");
            String nome = sc.nextLine();
            System.out.println("Qual o telefone do contato?");
            String telefone = sc.nextLine();
            System.out.println("Qual o email do contato?");
            String email = sc.nextLine();
            Contato contato = new Contato(nome, telefone, email);

            System.out.println("Deseja adicionar uma conta corrente ao contato? (S/N)");
            String opcaoConta = sc.nextLine();
            if (opcaoConta.equalsIgnoreCase("S")) {
                System.out.println("Digite o número da conta:");
                String numeroConta = sc.nextLine();
                System.out.println("Digite o saldo inicial:");
                double saldoInicial = sc.nextDouble();
                sc.nextLine();
                ContaCorrente conta = new ContaCorrente(numeroConta, saldoInicial);
                contato.setContaCorrente(conta);
            }

            contatos.add(contato);
            System.out.println("Contato adicionado com sucesso.");
        }
    },
    DETALHAR {
        @Override
        public void listar(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Lista de contatos:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    },
    EDITAR {
        @Override
        public void editarContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Digite o nome do contato a ser editado:");
            String nome = sc.nextLine();
            for (Contato contato : contatos) {
                if (contato.getNome().equals(nome)) {
                    System.out.println("Contato encontrado. Insira os novos dados.");
                    System.out.println("Novo telefone:");
                    contato.setTelefone(sc.nextLine());
                    System.out.println("Novo email:");
                    contato.setEmail(sc.nextLine());
                    System.out.println("Contact atualizado.");
                    return;
                }
            }
            System.out.println("Contato não encontrado.");
        }
    },
    REMOVER {
        @Override
        public void removerContato(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Digite o nome do contato a ser removido:");
            String nome = sc.nextLine();
            Contato contatoRemover = null;
            for (Contato contato : contatos) {
                if (contato.getNome().equals(nome)) {
                    contatoRemover = contato;
                    break;
                }
            }
            if (contatoRemover != null) {
                contatos.remove(contatoRemover);
                System.out.println("Contato removido.");
            } else {
                System.out.println("Contato não encontrado.");
            }
        }
    },
    TRANSFERIR {
        @Override
        public void realizarOperacao(Scanner sc, ArrayList<Contato> contatos) {
            System.out.println("Digite o nome do contato para realizar a transferência:");
            String nome = sc.nextLine();
            for (Contato contato : contatos) {
                if (contato.getNome().equals(nome) && contato.getContaCorrente() != null) {
                    System.out.println("Qual valor deseja transferir?");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    contato.getContaCorrente().realizarTransferencia(valor);
                    return;
                }
            }
            System.out.println("Contato ou conta não encontrada.");
        }
    },
    SAIR {
        @Override
        public void sair() {
            System.out.println("Saindo do sistema.");
        }
    };

    public void criarNovoContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    public void listar(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Operação não suportada.");
    }

    public void editarContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void removerContato(Scanner sc, ArrayList<Contato> contatos) {
        throw new UnsupportedOperationException("Esta operação não está disponível para esta opção.");
    }

    public void realizarOperacao(Scanner sc, ArrayList<Contato> contatos) {
    throw new UnsupportedOperationException("Operação não suportada.");
    }

    public void sair() {
        throw new UnsupportedOperationException("Operação não suportada.");
    }
}