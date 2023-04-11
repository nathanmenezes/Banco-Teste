import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.Conta;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 99;
        List<Conta> contas = new ArrayList<>();

        while (opcao != 9) {
            System.out.println("-----------------");
            System.out.println("[1] - Criar Conta");
            System.out.println("[2] - Depositar");
            System.out.println("[3] - Transferir");
            System.out.println("[4] - Dados da Conta");
            System.out.println("[5] - Cadastrar PIX");
            System.out.println("[6] - Listar Contas");
            System.out.println("[7] - Sacar");
            System.out.println("[9] - Encerrar Programa");
            System.out.println("-----------------");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();
                    for (Conta conta : contas) {
                        while(conta.getCliente().getCpf().equals(cpf)) {
                            System.out.println("Cliente já cadastrado, tente novamente!");
                            System.out.println("CPF: ");
                            cpf = sc.nextLine();
                        }
                    }
                    System.out.print("Digite o Telefone: ");
                    String telefone = sc.nextLine();

                    contas.add(new Conta(new Cliente(nome, cpf, telefone)));
                    System.out.println("Cliente Cadastrado com Sucesso!");

                    break;
                case 2:
                    if (!contas.isEmpty()) {
                        System.out.println(" Digite o seu cpf para efutuar o deposito: ");
                        String contaCPF = sc.nextLine();

                        for (Conta conta : contas) {
                            if (conta.getCliente().getCpf().equals(contaCPF)) {
                                System.out.println("Digite a quantia do deposito: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();
                                conta.deposito(valor);
                            }
                        }
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }

                    break;

                case 3:
                    if (!contas.isEmpty()) {
                        System.out.print("Digite o CPF para efetuar a transferencia: ");
                        String encontrarCPF = sc.nextLine();
                        for (Conta conta : contas) {
                            if (conta.getCliente().getCpf().equals(encontrarCPF)) {

                                System.out.println("Digite a quantia da transferencia: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();
                                System.out.print("Digite o pix para efetuar a transferencia: ");
                                String pix = sc.nextLine();

                                for (Conta conta2 : contas) {
                                    for (String chavePix : conta2.getChavesPix()) {
                                        if (chavePix.equals(pix)) {
                                            conta.transferir(valor, conta2);
                                            System.out.println("Transferencia Efetuada com Sucesso!");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }

                    break;

                case 4:
                    if (!contas.isEmpty()) {
                        System.out.println("Digite seu CPF para mostrar os dados da conta: ");
                        String encontrarCPF = sc.nextLine();

                        for (Conta conta : contas) {
                            if (conta.getCliente().getCpf().equals(encontrarCPF)) {
                                System.out.println(conta);
                            }
                        }
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }

                    break;

                case 5:
                    if (!contas.isEmpty()) {
                        System.out.println("Digite o cpf da conta que vai cadastrar o pix: ");
                        String encontrarCPF = sc.nextLine();

                        for (Conta conta : contas) {
                            if (conta.getCliente().getCpf().equals(encontrarCPF)) {
                                System.out.print("Digite a chave pix: ");
                                String pix = sc.nextLine();
                                conta.getChavesPix().add(pix);
                            }
                        }
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }

                    break;
                case 6:
                    if (!contas.isEmpty()) {
                        System.out.println("LISTA DE CONTAS:");
                        for (Conta conta : contas) {
                            System.out.println("-----------------");
                            System.out.println(conta);
                        }
                        System.out.println("-----------------");
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }
                    break;
                case 7:
                if (!contas.isEmpty()) {
                    System.out.println(" Digite o seu cpf para efetuar o saque: ");
                        String contaCPF = sc.nextLine();
                        for (Conta conta : contas) {
                            if (conta.getCliente().getCpf().equals(contaCPF)) {
                                System.out.println("Digite a quantia do saque: ");
                                double valor = sc.nextDouble();
                                sc.nextLine();
                                conta.sacar(valor);
                            }
                        }
                    } else {
                        System.out.println("Lista de contas vazia!");
                    }
                    break;
                default:
                    break;
            }
        }

        sc.close();
    }
}