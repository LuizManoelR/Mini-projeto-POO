package loja.view;

import loja.controller.ProdutoController;
import loja.model.Produto;
import loja.service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class InterfaceProduto {

    /*public static Scanner scanner = new Scanner(System.in);
    
    public static void exibirMenu(ProdutoController produtoController) {
        int opcao;
        

        do {
            System.out.println("\n===== MENU PRODUTOS =====");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Buscar Produto por Código");
            System.out.println("3. Buscar Produto por Nome");
            System.out.println("4. Remover Produto");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto(produtoController);
                    break;
                case 2:
                    buscarPorCodigo(produtoController);
                    break;
                case 3:
                    buscarPorNome(produtoController);
                    break;
                case 4:
                    removerProduto(produtoController);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }*/

    public static void cadastrarProduto(ProdutoController controller, Scanner scanner) {
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço Custo: ");
        float preco = scanner.nextFloat();
        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        
        ProdutoService ps = new ProdutoService(null, null);
        Produto produto = ps.criarProduto(nome, estoque, preco);
        controller.addProduto(produto);
    }

    public static void buscarPorCodigo(ProdutoController controller, Scanner scanner) {
        System.out.print("\nDigite o código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = controller.buscarProduto(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            produto.exibir();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    /*public static void buscarPorNome(ProdutoController controller, Scanner scanner) {
        System.out.print("\nDigite parte do nome do produto: ");
        String nome = scanner.nextLine();

        List<Produto> encontrados = controller.buscarProdutoPorNome(nome);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
        } else {
            System.out.println("Produtos encontrados:");
            for (Produto p : encontrados) {
                System.out.println("Código: " + p.getCodigo() + ", Nome: " + p.getNome() + ", Preço: R$" + p.getPreco());
            }
        }
    }*/

    public static void alterarProduto(ProdutoController controller, Scanner scanner) {
        
        System.out.println("\n--- Alterar Produto ---");
        System.out.print("codigo: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço Custo: ");
        float preco = scanner.nextFloat();
        System.out.print("Estoque: ");
        int estoque = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        controller.alterarProduto(codigo, nome, estoque, preco);
    }
}

