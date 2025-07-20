package loja.view;

import java.util.Scanner;

public class InterfaceLoja {

    private Scanner scanner;

    public InterfaceLoja() {
        scanner = new Scanner(System.in);
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
        System.out.println("[Interface] → Cadastrar Produto (função ainda não implementada)");
    }

    private void alterarProduto() {
        System.out.println("[Interface] → Alterar Produto (função ainda não implementada)");
    }

    private void cadastrarCliente() {
        System.out.println("[Interface] → Cadastrar Cliente (função ainda não implementada)");
    }

    private void alterarCliente() {
        System.out.println("[Interface] → Alterar Cliente (função ainda não implementada)");
    }

    private void criarNotaCompra() {
        System.out.println("[Interface] → Criar Nota de Compra (função ainda não implementada)");
    }

    private void listarNotas() {
        System.out.println("[Interface] → Listar Notas Emitidas (função ainda não implementada)");
    }

    private void listarProdutos() {
        System.out.println("[Interface] → Listar Produtos (função ainda não implementada)");
    }

    private void listarClientes() {
        System.out.println("[Interface] → Listar Clientes (função ainda não implementada)");
    }

    // ========== MAIN ==========
    public static void main(String[] args) {
        InterfaceLoja app = new InterfaceLoja();
        app.iniciar();
    }
}
