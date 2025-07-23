package loja.view;

import java.util.Scanner;
import java.util.List;

import loja.controller.ClienteController;
import loja.model.Cliente;

public class InterfaceCliente {

       

    public static void cadastrarCliente(ClienteController clienteController, Scanner scanner) {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        boolean sucesso = clienteController.cadastrarCliente(cpf, nome, email, telefone);
        if (sucesso) {
            System.out.println("Cliente cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar cliente. CPF já existente?");
        }
    }

    public static void alterarCliente(ClienteController clienteController, Scanner scanner) {
        System.out.println("\n--- Alteração de Cliente ---");
        System.out.print("CPF do cliente a alterar: ");
        String cpf = scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo email: ");
        String email = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

        boolean sucesso = clienteController.alterarCliente(cpf, nome, email, telefone);
        if (sucesso) {
            System.out.println("Cliente alterado com sucesso!");
        } else {
            System.out.println("Cliente com CPF informado não encontrado.");
        }
    }

    public static void listarClientes(ClienteController clienteController, Scanner scanner) {
        System.out.println("\n--- Lista de Clientes ---");
        List<Cliente> clientes = clienteController.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println("CPF: " + c.getCpf());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Email: " + c.getEmail());
                System.out.println("Telefone: " + c.getTelefone());
                System.out.println("---------------------------");
            }
        }
    }

    public static void buscarClientePorCpf(ClienteController clienteController, Scanner scanner) {
        System.out.println("\n--- Buscar Cliente por CPF ---");
        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();
        Cliente cliente = clienteController.buscarClientePorCpf(cpf);
        if (cliente != null) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }public static void main(String[] args){

       
        


    }
}

