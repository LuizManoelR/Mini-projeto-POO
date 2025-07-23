package loja.view;

import loja.controller.ProdutoController;
import loja.model.Produto;

import java.util.List;
import java.util.Scanner;

public class InterfaceProduto {

    private static Scanner scanner = new Scanner(System.in);
    
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
    }

    private static void cadastrarProduto(ProdutoController controller) {
        System.out.println("\n--- Cadastrar Produto ---");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer

        Produto produto = new Produto(nome, 0, null, null, null);
        controller.addProduto(produto);
    }

    private static void buscarPorCodigo(ProdutoController controller) {
        System.out.print("\nDigite o código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = controller.buscarProduto(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado:");
            System.out.println("Código: " + produto.getCodigo());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void buscarPorNome(ProdutoController controller) {
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
    }

    private static void removerProduto(ProdutoController controller) {
        System.out.print("\nDigite o código do produto a remover: ");
        String codigo = scanner.nextLine();

        controller.removeProduto(codigo);
    }
}

