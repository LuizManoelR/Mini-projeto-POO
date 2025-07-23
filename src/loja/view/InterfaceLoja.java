package loja.view;

import java.util.Scanner;
import loja.controller.ClienteController;
import loja.controller.NotaController;
import loja.controller.ProdutoController;

public class InterfaceLoja {

    private Scanner scanner;
    
    private ClienteController clienteController;
    private ProdutoController produtoController;
    private NotaController notaController;


    public InterfaceLoja() {
        scanner = new Scanner(System.in);
        clienteController = new ClienteController();
        produtoController = new ProdutoController();
        notaController = new NotaController();
    }

    public void iniciar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> alterarProduto();
                case 3 -> cadastrarCliente();
                case 4 -> alterarCliente();
                case 5 -> criarNotaCompra();
                case 6 -> listarNotas();
                case 7 -> listarProdutos();
                case 8 -> listarClientes();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n========= MENU DA LOJA =========");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Alterar Produto");
        System.out.println("3. Cadastrar Cliente");
        System.out.println("4. Alterar Cliente");
        System.out.println("5. Criar Nota de Compra");
        System.out.println("6. Listar Notas Emitidas");
        System.out.println("7. Listar Produtos");
        System.out.println("8. Listar Clientes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ========== MÉTODOS PLACEHOLDER ==========

    private void cadastrarProduto() {
        InterfaceProduto.cadastrarProduto(produtoController, scanner);;
    }

    private void alterarProduto() {
        InterfaceProduto.alterarProduto(produtoController, scanner);;
    }

    private void cadastrarCliente() {
        InterfaceCliente.cadastrarCliente(clienteController, scanner);
    }

    private void alterarCliente() {
        InterfaceCliente.alterarCliente(clienteController, scanner);;
    }

    private void criarNotaCompra() {
        InterfaceNota.exibir(produtoController, clienteController, notaController, scanner);
    }

    private void listarNotas() {
        notaController.exibirNotasRegistradas();
    }

    private void listarProdutos() {
        produtoController.listarProdutos();;
    }

    private void listarClientes() {
        InterfaceCliente.listarClientes(clienteController, scanner);
    }

    // ========== MAIN ==========
    public static void main(String[] args) {
        InterfaceLoja app = new InterfaceLoja();
        app.iniciar();
    }
}
